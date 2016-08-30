package com.fernandocejas.android10.sample.presentation.internal.di.modules;

import com.fernandocejas.android10.sample.domain.UserModel;
import com.fernandocejas.android10.sample.domain.interactor.LogInInteractor;
import com.fernandocejas.android10.sample.domain.interactor.UseCase;
import com.fernandocejas.android10.sample.presentation.internal.di.PerActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by alten on 28/8/16.
 */
@Module
public class LogInModule {

    public UserModel userModel;

    public LogInModule() {
    }

    @Provides
    @PerActivity
    UseCase provideLogInInteractor(LogInInteractor logInInteractor) {
        return logInInteractor;
    }

//    @Provides @PerActivity UserModel provideUserModel(UserModel userModel){
//        return userModel;
//    }

//    @Provides @PerActivity @Named("userList") UseCase provideGetUserListUseCase(
//            GetUserList getUserList) {
//        return getUserList;
//    }


}
