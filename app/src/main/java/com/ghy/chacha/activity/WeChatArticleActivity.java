package com.ghy.chacha.activity;

import com.ghy.baseapp.base.AbsBaseActivity;
import com.ghy.chacha.R;
import com.ghy.chacha.helper.TitleHelper;

/**
 * 微信精选页面
 */
public class WeChatArticleActivity extends AbsBaseActivity {

    @Override
    protected int getLayoutID() {
        return R.layout.activity_we_chat_article;
    }

    @Override
    protected String getToolBarTitle() {
        return TitleHelper.TITLE_WE_CHAT;
    }

    @Override
    protected void init() {

    }

}
