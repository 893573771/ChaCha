package com.ghy.chacha.activity;

import com.ghy.baseapp.base.AbsBaseActivity;
import com.ghy.chacha.R;
import com.ghy.chacha.helper.TitleHelper;

/**
 * 身份证查询
 */
public class IdentityCardActivity extends AbsBaseActivity {

    @Override
    protected int getLayoutID() {
        return R.layout.activity_identity_card;
    }

    @Override
    protected String getToolBarTitle() {
        return TitleHelper.TITLE_IDENTITY_CARD;
    }

    @Override
    protected void init() {

    }

}
