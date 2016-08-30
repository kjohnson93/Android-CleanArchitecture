package com.fernandocejas.android10.sample.domain.interactor;

import com.fernandocejas.android10.sample.domain.UserModel;
import com.fernandocejas.android10.sample.domain.executor.PostExecutionThread;
import com.fernandocejas.android10.sample.domain.executor.ThreadExecutor;
import com.fernandocejas.android10.sample.domain.repository.UserRepository;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by alten on 28/8/16.
 */
public class LogInInteractor extends UseCase {

    private Subscription subscription = Subscriptions.empty();

    @Inject
    public LogInInteractor(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
    }
//
//    @Inject
//    public GetUserList(UserRepository userRepository, ThreadExecutor threadExecutor,
//                       PostExecutionThread postExecutionThread) {
//        super(threadExecutor, postExecutionThread);
//        this.userRepository = userRepository;
//    }

    //Si LogInInterctor emite el usermodel, el presenter se puede suscribir y se emitiran estos datos.
    @Override
    protected Observable buildUseCaseObservable() {

        return null;
    }

    /*
 * Validation of the user on the log in process
 */
    private Boolean isValidUser(UserModel user) {
        if (user.getmUserName().isEmpty() || user.getmUserPassword().isEmpty()) return false;
        else return true;

    }


    public void validate(Subscriber useCaseSubscriber, final UserModel userModel) {


        Observable<Boolean> myObservable = Observable.create(new Observable.OnSubscribe<Boolean>() {
            @Override
            public void call(Subscriber<? super Boolean> subscriber) {
                if (isValidUser(userModel)) {
                    subscriber.onNext(true);
                } else {
                    subscriber.onNext(false);
                }

                subscriber.onCompleted();
            }
        });

        this.subscription = myObservable.subscribeOn(Schedulers.from(threadExecutor)).
                observeOn(postExecutionThread.getScheduler()).subscribe(useCaseSubscriber);


        //aqui  dentro emitir el booleano resultante de la validación?


//        this.subscription = this.buildUseCaseObservable()
//                .subscribeOn(Schedulers.from(threadExecutor))
//                .observeOn(postExecutionThread.getScheduler())
//                .subscribe(useCaseSubscriber);
    }
}
