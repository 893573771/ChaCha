package com.ghy.chacha.activity;

import com.ghy.baseapp.base.AbsBaseActivity;
import com.ghy.chacha.R;
import com.ghy.chacha.helper.TitleHelper;

/**
 * 历史上的今天
 */
public class HistoryTodayActivity extends AbsBaseActivity {

    @Override
    protected int getLayoutID() {
        return R.layout.activity_history_today;
    }

    @Override
    protected String getToolBarTitle() {
        return TitleHelper.TITLE_HISTORY_TODAY;
    }

    @Override
    protected void init() {

    }

}
