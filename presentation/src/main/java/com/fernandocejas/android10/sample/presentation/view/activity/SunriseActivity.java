package com.fernandocejas.android10.sample.presentation.view.activity;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

import com.fernandocejas.android10.sample.domain.UserModel;
import com.fernandocejas.android10.sample.presentation.R;


public class SunriseActivity extends Activity {

    private UserModel mUserModel;

    private Toolbar toolbar;
//    private TabLayout tabLayout;
    private ViewPager viewPager;

    private EditText mLatitudeEditText, mLongitudeEditText;
    private Button mRequestSunriseHourButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sunrise);
    }

}
