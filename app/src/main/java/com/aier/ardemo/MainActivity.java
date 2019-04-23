package com.aier.ardemo;

import android.arch.lifecycle.ViewModel;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.RelativeLayout;
import com.aier.ardemo.fragment.HomeFragment;
import com.aier.ardemo.fragment.MyFragment;
import com.aier.ardemo.view.BaseActivity;
import com.aier.ardemo.weight.BottomView;
import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity  implements BottomView.BottomCallBack{
    @BindView(R.id.bottom_view)
    BottomView bottomView;
    @BindView(R.id.rl_submit)
    RelativeLayout rl_submit;
    private Fragment mCurrentFrag;
    private FragmentManager fm;
    private Fragment homeFragment;
    private Fragment myFragment;
    private boolean flag = true;
    @Override
    protected void initViews() {
        fm = getSupportFragmentManager();
        homeFragment = new HomeFragment();
        myFragment = new MyFragment();
        switchContent(homeFragment);
        bottomView.setBottomCallBack(this);
    }

    @Override
    protected void initDate(Bundle savedInstanceState) {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected ViewModel initViewModel() {

        return null;
    }


    @OnClick({R.id.fab})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab:

                if(flag){
                    flag = false;
                    rl_submit.setVisibility(View.VISIBLE);
                }else {
                    flag = true;
                    rl_submit.setVisibility(View.GONE);
                }

                break;
        }

    }

    @Override
    public void setCallBack(int num) {
        switch (num){
            case 1:
                switchContent(homeFragment);
                break;
            case 2:
                switchContent(myFragment);
                break;
            case 3:

                break;
            case 4:

                break;
        }
    }

    /**
     * 动态添加fragment，不会重复创建fragment
     *
     * @param to 将要加载的fragment
     */
    public void switchContent(Fragment to) {
        if (mCurrentFrag != to) {
            if (!to.isAdded()) {// 如果to fragment没有被add则增加一个fragment
                if (mCurrentFrag != null) {
                    fm.beginTransaction().hide(mCurrentFrag).commit();
                }
                fm.beginTransaction()
                        .add(R.id.fl_content, to)
                        .commit();
            } else {
                fm.beginTransaction().hide(mCurrentFrag).show(to).commit(); // 隐藏当前的fragment，显示下一个
            }
            mCurrentFrag = to;
        }
    }

}