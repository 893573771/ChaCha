package com.ghy.chacha.activity;

import com.ghy.baseapp.base.AbsBaseActivity;
import com.ghy.chacha.R;
import com.ghy.chacha.helper.TitleHelper;

/**
 * 空气质量
 */
public class AirQualityActivity extends AbsBaseActivity {

    @Override
    protected int getLayoutID() {
        return R.layout.activity_air_quality;
    }

    @Override
    protected String getToolBarTitle() {
        return TitleHelper.TITLE_AIR_QUALITY;
    }

    @Override
    protected void init() {

    }

}
