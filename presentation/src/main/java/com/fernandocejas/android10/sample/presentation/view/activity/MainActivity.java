package com.fernandocejas.android10.sample.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.fernandocejas.android10.sample.presentation.R;
import com.fernandocejas.android10.sample.presentation.internal.di.HasComponent;
import com.fernandocejas.android10.sample.presentation.internal.di.components.DaggerLogInComponent;
import com.fernandocejas.android10.sample.presentation.internal.di.components.LogInComponent;
import com.fernandocejas.android10.sample.presentation.view.fragment.LogInFragment;

/**
 * Main application screen. This is the app entry point.
 */
public class MainActivity extends BaseActivity implements HasComponent<LogInComponent>,
LogInFragment.LogginButtonListener{

//    @Bind(R.id.btn_LoadData) Button btn_LoadData;
    private LogInComponent logInComponent;

//    public static Intent getCallingIntent(Context context) {
//        return new Intent(context, .class);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
        this.initializeInjector();
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new LogInFragment());
        }
    }

    /**
     * Goes to the user list screen.
     */
    @OnClick(R.id.btn_LoadData)
    void navigateToUserList() {
//        this.navigator.navigateToUserList(this);
    }

    private void initializeInjector() {
//    this.userComponent = DaggerUserComponent.builder()
//        .applicationComponent(getApplicationComponent())
//        .activityModule(getActivityModule())
//        .build();
        this.logInComponent = DaggerLogInComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule()).build();


    }

    @Override
    public LogInComponent getComponent() {
        return logInComponent;
    }


    @Override
    public void onLogginButtonClicked() {

    }
}