package com.aier.ardemo.http.datasource;


import com.aier.ardemo.http.basis.BaseRemoteDataSource;
import com.aier.ardemo.http.basis.callback.RequestCallback;
import com.aier.ardemo.http.basis.config.HttpConfig;
import com.aier.ardemo.http.datasource.base.IQrCodeDataSource;
import com.aier.ardemo.http.service.ApiService;
import com.aier.ardemo.model.QrCode;
import com.aier.ardemo.viewmodel.base.BaseViewModel;

/**
 * 作者：leavesC
 * 时间：2018/10/27 20:48
 * 描述：
 * GitHub：https://github.com/leavesC
 * Blog：https://www.jianshu.com/u/9df45b87cfdf
 */
public class QrCodeDataSource extends BaseRemoteDataSource implements IQrCodeDataSource {

    public QrCodeDataSource(BaseViewModel baseViewModel) {
        super(baseViewModel);
    }

    @Override
    public void createQrCode(String text, int width, RequestCallback<QrCode> callback) {
        execute(getService(ApiService.class, HttpConfig.BASE_URL_QR_CODE).createQrCode(text, width), callback);
    }

}