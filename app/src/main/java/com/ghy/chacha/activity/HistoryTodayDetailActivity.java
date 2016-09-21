package com.ghy.chacha.activity;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

import com.ghy.baseapp.base.AbsBaseActivity;
import com.ghy.chacha.R;
import com.ghy.chacha.helper.TitleHelper;

import butterknife.Bind;

/**
 * 历史上的今天详情页面
 */
public class HistoryTodayDetailActivity extends AbsBaseActivity {


    @Bind(R.id.tv_his_tod_detail_title)
    TextView tvDetailTitle;
    @Bind(R.id.tv_his_tod_detail_content)
    TextView tvDetailContent;

    private static String title,content;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_history_today_detail;
    }

    @Override
    protected String getToolBarTitle() {
        return TitleHelper.TITLE_HISTORY_TODAY_DETAIL;
    }

    @Override
    protected void init() {
        tvDetailTitle.setText(title);
        tvDetailContent.setText(content);
    }

    /**
     * Created by GHY on 2016/9/21.
     * MethodDesc:开启详情页面
     **/
    public static void startHistoryTodayDetailActivity(Activity activity,String detailTitle,String detailContent){
        Intent intent = new Intent(activity, HistoryTodayDetailActivity.class);
        activity.startActivity(intent);
        title = detailTitle;
        content = detailContent;
    }
}
