package com.aier.ardemo;

import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.aier.ardemo.model.QrCode;
import com.aier.ardemo.view.BaseActivity;
import com.aier.ardemo.viewmodel.LoginViewModel;
import com.aier.ardemo.viewmodel.base.LViewModelProviders;

import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    private LoginViewModel loginViewModel;


    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected ViewModel initViewModel() {
        loginViewModel = LViewModelProviders.of(this, LoginViewModel.class);
        loginViewModel.getloginLiveData().observe(this, this::handleQrCode);
        return loginViewModel;
    }

    private void handleQrCode(QrCode qrCode) {
        //  iv_qrCode.setImageBitmap(qrCode.getBitmap());
    }

//    public void createQrCode(View view) {
//        iv_qrCode.setImageBitmap(null);
//        loginViewModel.createQrCode(et_text.getText().toString(), 600);
//    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDate(Bundle savedInstanceState) {

    }

    @OnClick({R.id.quit,R.id.create_acc,R.id.bt_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.quit:
                System.exit(0);
                break;
            case R.id.create_acc:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
            case R.id.bt_login:
                startActivity(new Intent(this,MainActivity.class));
                finish();
                break;
        }
    }
}
