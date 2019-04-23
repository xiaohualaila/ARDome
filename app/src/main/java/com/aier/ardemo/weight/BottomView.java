package com.aier.ardemo.weight;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.aier.ardemo.R;


public class BottomView extends LinearLayout implements View.OnClickListener{
    private ImageView home,my;
    private int before_state = 1;
    private BottomCallBack bottomCallBack;

    public void setBottomCallBack(BottomCallBack bottomCallBack) {
        this.bottomCallBack = bottomCallBack;
    }

    public BottomView(Context context) {
        super(context);
    }

    public BottomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
      View view = LayoutInflater.from(context).inflate(R.layout.bottom_view, this);
        home = view.findViewById(R.id.iv_home);
        my = view.findViewById(R.id.iv_my);
        home.setOnClickListener(this);
        my.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_home:
                setBottomViewState(1);
                break;
            case R.id.iv_my:
                setBottomViewState(2);
                break;


        }
    }

    private void setBottomViewState(int mAccount) {
//        hideBottomLayout();
        if (before_state != mAccount) {
            if (mAccount == 1) {
                bottomCallBack.setCallBack(1);
            } else if (mAccount == 2) {
                bottomCallBack.setCallBack(2);
            } else if (mAccount == 3) {
                bottomCallBack.setCallBack(3);
            } else if (mAccount == 4) {
                bottomCallBack.setCallBack(4);
            }

            before_state = mAccount;
        }
    }
    public interface BottomCallBack{
        void setCallBack(int num);
    }
}
