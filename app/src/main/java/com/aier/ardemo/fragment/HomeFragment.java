package com.aier.ardemo.fragment;


import android.arch.lifecycle.ViewModel;

import com.aier.ardemo.R;
import com.aier.ardemo.view.BaseFragment;

public class HomeFragment extends BaseFragment {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init() {

    }


    @Override
    protected ViewModel initViewModel() {
        return null;
    }
}
