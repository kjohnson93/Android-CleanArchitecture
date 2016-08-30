package com.fernandocejas.android10.sample.presentation.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.fernandocejas.android10.sample.domain.User;
import com.fernandocejas.android10.sample.domain.UserModel;
import com.fernandocejas.android10.sample.domain.exception.DefaultErrorBundle;
import com.fernandocejas.android10.sample.domain.interactor.DefaultSubscriber;
import com.fernandocejas.android10.sample.domain.interactor.LogInInteractor;
import com.fernandocejas.android10.sample.domain.interactor.UseCase;
import com.fernandocejas.android10.sample.presentation.view.LoginView;
import com.fernandocejas.android10.sample.presentation.view.UserListView;

import javax.inject.Inject;

import rx.Subscriber;


/**
 * Created by alten on 28/8/16.
 */
public class LogInPresenter implements Presenter {

//    private final UseCase mLoginInteractor;
    private final LogInInteractor mLoginInteractor;
    private LoginView loginView;


    @Inject
    public LogInPresenter(LogInInteractor loginInteractor) {
        mLoginInteractor = loginInteractor;
    }


    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    public void loginSuccessful(){this.loginView.navigateToTabActivity();}

    public void loginUnSuccessful(){this.loginView.showError();}

    public void setView(@NonNull LoginView view) {
        this.loginView = view;
    }

    public void loginValidation(UserModel userModel){
//        (LogInInteractor) this.mLoginInteractor.validate(new LogInSubscriber(), userModel);

        Subscriber<Boolean> mySubscriber = new Subscriber<Boolean>() {

            @Override
            public void onNext(Boolean isValidUser) {
                if (isValidUser.equals(true)){
                    loginSuccessful();
                }
                else{
                    loginUnSuccessful();
                }
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {

            }
        };
//        this.mLoginInteractor.validate(new LogInSubscriber(), userModel);
          this.mLoginInteractor.validate(mySubscriber, userModel);
    }

//    private void getUserList() {
//        this.getUserListUseCase.execute(new UserListSubscriber());
//    }


//    private final class LogInSubscriber extends DefaultSubscriber<User> {
//
//        @Override public void onCompleted() {
////            UserListPresenter.this.hideViewLoading();
//        }
//
//        @Override public void onError(Throwable e) {
////            UserListPresenter.this.hideViewLoading();
////            UserListPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
////            UserListPresenter.this.showViewRetry();
//        }
//
//        @Override
//        public void onNext(User user) {
//            super.onNext(user);
//        }
//    }



}
