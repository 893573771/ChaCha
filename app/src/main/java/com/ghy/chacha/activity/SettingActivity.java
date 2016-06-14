package com.ghy.chacha.activity;

import com.ghy.baseapp.base.AbsBaseActivity;
import com.ghy.chacha.R;
import com.ghy.chacha.helper.TitleHelper;

/**
 * 设置页面
 */
public class SettingActivity extends AbsBaseActivity {

    @Override
    protected int getLayoutID() {
        return R.layout.activity_setting;
    }

    @Override
    protected String getToolBarTitle() {
        return TitleHelper.TITLE_SETTING;
    }

    @Override
    protected void init() {

    }

}
