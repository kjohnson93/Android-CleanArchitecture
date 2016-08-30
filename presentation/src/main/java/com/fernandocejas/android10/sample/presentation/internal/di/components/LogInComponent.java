package com.fernandocejas.android10.sample.presentation.internal.di.components;

import com.fernandocejas.android10.sample.presentation.internal.di.PerActivity;
import com.fernandocejas.android10.sample.presentation.internal.di.modules.ActivityModule;
import com.fernandocejas.android10.sample.presentation.internal.di.modules.LogInModule;
import com.fernandocejas.android10.sample.presentation.view.activity.MainActivity;
import com.fernandocejas.android10.sample.presentation.view.fragment.LogInFragment;

import dagger.Component;

/**
 * Created by alten on 28/8/16.
 */
@PerActivity @Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, LogInModule.class})
public interface LogInComponent extends ActivityComponent {
    void inject(LogInFragment logInFragment);
}
