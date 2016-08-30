package com.fernandocejas.android10.sample.presentation.view.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fernandocejas.android10.sample.presentation.R;
import com.fernandocejas.android10.sample.presentation.internal.di.components.LogInComponent;
import com.fernandocejas.android10.sample.presentation.presenter.LogInPresenter;
import com.fernandocejas.android10.sample.presentation.presenter.UserListPresenter;
import com.fernandocejas.android10.sample.domain.UserModel;
import com.fernandocejas.android10.sample.presentation.view.LoginView;
import com.fernandocejas.android10.sample.presentation.view.activity.SunriseActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by alten on 29/8/16.
 */


public class LogInFragment extends BaseFragment implements LoginView {


    /**
     * Interface for listening user list events.
     */
    public interface LogginButtonListener {
        void onLogginButtonClicked();
    }


    @Bind(R.id.btn_LoadData)
    Button btn_LoadData;
    @Bind(R.id.userNameEdTxt)
    EditText edt_UserName;
    @Bind(R.id.passwordEdTxt)
    EditText edt_Password;

    @Inject
    LogInPresenter logInPresenter;
    @Inject
    UserModel mUserModel;


    private LogginButtonListener logginButtonListener;

    public LogInFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof LogginButtonListener) {
            this.logginButtonListener = (LogginButtonListener) activity;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_login_screen, container, false);
        ButterKnife.bind(this, fragmentView);
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        logInPresenter.setView(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @OnClick(R.id.btn_LoadData)
    void navigateToUserList() {
        this.getComponent(LogInComponent.class).inject(this);
        mUserModel.setmUserName(edt_UserName.getText().toString());
        mUserModel.setmUserPassword(edt_Password.getText().toString());
        logInPresenter.loginValidation(mUserModel);
        logInPresenter.setView(LogInFragment.this);
    }

    @Override
    public void navigateToTabActivity() {
        Intent intent = new Intent(getActivity(), SunriseActivity.class);
        startActivity(intent);
    }

    @Override
    public void showError() {
        Toast.makeText(getActivity(), "Error: Fill your username and password", Toast.LENGTH_SHORT).show();

    }

    //    @OnClick(R.id.bt_retry) void onButtonRetryClick() {
//        UserListFragment.this.loadUserList();
//    }
//    @OnClick(R.id.btn_LoadData)
//    void onButtonLoginClick(View view) {
//        this.getComponent(LogInComponent.class).inject(this);
//        logInPresenter.setView(LogInFragment.this);
//    }


}
