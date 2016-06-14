package com.ghy.chacha.activity;

import com.ghy.baseapp.base.AbsBaseActivity;
import com.ghy.chacha.R;
import com.ghy.chacha.helper.TitleHelper;

/**
 * 号码归属
 */
public class NumberBelongActivity extends AbsBaseActivity {

    @Override
    protected int getLayoutID() {
        return R.layout.activity_number_belong;
    }

    @Override
    protected String getToolBarTitle() {
        return TitleHelper.TITLE_NUMBER_BELONG;
    }

    @Override
    protected void init() {

    }

}
