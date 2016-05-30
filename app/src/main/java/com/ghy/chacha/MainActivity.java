package com.ghy.chacha;

import com.ghy.baseapp.base.AbsBaseActivity;

public class MainActivity extends AbsBaseActivity {

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected String getToolBarTitle() {
        return "知道吗";
    }

    @Override
    protected boolean isOpenToolBarLeftBack() {
        return false;
    }

    @Override
    protected void init() {

    }

}
