package com.aier.ardemo;

import android.arch.lifecycle.ViewModel;
import android.os.Bundle;
import android.view.View;
import com.aier.ardemo.view.BaseActivity;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {
    @Override
    protected void initViews() {

    }

    @Override
    protected void initDate(Bundle savedInstanceState) {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected ViewModel initViewModel() {
        return null;
    }
    @OnClick({R.id.quit,R.id.bt_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.quit:
               finish();
                break;
            case R.id.bt_register:

                break;
        }
    }
}
