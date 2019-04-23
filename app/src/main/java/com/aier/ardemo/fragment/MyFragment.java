package com.aier.ardemo.fragment;


import android.arch.lifecycle.ViewModel;

import com.aier.ardemo.R;
import com.aier.ardemo.view.BaseFragment;

public class MyFragment extends BaseFragment {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void init() {

    }


    @Override
    protected ViewModel initViewModel() {
        return null;
    }
}
