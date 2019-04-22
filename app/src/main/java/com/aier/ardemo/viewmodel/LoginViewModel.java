package com.aier.ardemo.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.aier.ardemo.http.datasource.QrCodeDataSource;
import com.aier.ardemo.http.repo.QrCodeRepo;
import com.aier.ardemo.model.QrCode;
import com.aier.ardemo.viewmodel.base.BaseViewModel;



/**
 * 作者：leavesC
 * 时间：2018/10/27 21:14
 * 描述：
 * GitHub：https://github.com/leavesC
 * Blog：https://www.jianshu.com/u/9df45b87cfdf
 */
public class LoginViewModel extends BaseViewModel {

    private MutableLiveData<QrCode> qrCodeLiveData;

    private QrCodeRepo qrCodeRepo;

    public LoginViewModel() {
        qrCodeLiveData = new MutableLiveData<>();
        qrCodeRepo = new QrCodeRepo(new QrCodeDataSource(this));
    }

    public void createQrCode(String text, int width) {
        qrCodeRepo.createQrCode(text, width).observe(lifecycleOwner, qrCode -> qrCodeLiveData.setValue(qrCode));
    }

    public MutableLiveData<QrCode> getQrCodeLiveData() {
        return qrCodeLiveData;
    }

}
