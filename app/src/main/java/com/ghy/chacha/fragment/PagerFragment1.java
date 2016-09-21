package com.ghy.chacha.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.ghy.baseapp.base.AbsBaseFragment;
import com.ghy.baseapp.utils.AnimUtils;
import com.ghy.chacha.R;
import com.ghy.chacha.activity.AirQualityActivity;
import com.ghy.chacha.activity.HistoryTodayActivity;
import com.ghy.chacha.activity.IdentityCardActivity;
import com.ghy.chacha.activity.NumberBelongActivity;
import com.ghy.chacha.activity.WeChatArticleActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by HY on 2016/5/1.
 */
public class PagerFragment1 extends AbsBaseFragment {

    @Bind(R.id.home_fun1)
    TextView tvHomeFun1;
    @Bind(R.id.home_fun2)
    TextView tvHomeFun2;
    @Bind(R.id.home_fun3)
    TextView tvHomeFun3;
    @Bind(R.id.home_fun4)
    TextView tvHomeFun4;

    @Bind(R.id.home_fun8)
    TextView tvHomeFun8;

    private View[] funViews = new View[4];

    private long defaultDelayTime = 300;//触摸动画默认延迟时间

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_pager1;
    }


    @Override
    protected void init(Bundle savedInstanceState, View contentView) {
        tvHomeFun1.setOnTouchListener(new MyTouchListener(tvHomeFun1));
        tvHomeFun2.setOnTouchListener(new MyTouchListener(tvHomeFun2));
        tvHomeFun3.setOnTouchListener(new MyTouchListener(tvHomeFun3));
        tvHomeFun4.setOnTouchListener(new MyTouchListener(tvHomeFun4));

        tvHomeFun8.setOnTouchListener(new MyTouchListener(tvHomeFun8));

        initFunViews();
    }

    private void initFunViews() {
        funViews[0] = tvHomeFun1;
        funViews[1] = tvHomeFun2;
        funViews[2] = tvHomeFun3;
        funViews[3] = tvHomeFun4;
    }

    @OnClick(R.id.home_fun1)
    public void homeFun1() {
        delayStartActivity(NumberBelongActivity.class);
    }

    @OnClick(R.id.home_fun2)
    public void homeFun2() {
        delayStartActivity(AirQualityActivity.class);
    }

    @OnClick(R.id.home_fun3)
    public void homeFun3() {
        delayStartActivity(IdentityCardActivity.class);
    }

    @OnClick(R.id.home_fun4)
    public void homeFun4() {
        delayStartActivity(HistoryTodayActivity.class);
    }

    @OnClick(R.id.home_fun8)
    public void homeFun8() {
        delayStartActivity(WeChatArticleActivity.class);
    }

    /**
     * 延时开启activity,等待触摸动画执行完毕
     */
    private void delayStartActivity(final Class<?> activity) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getActivity(), activity));
            }
        }, defaultDelayTime * 2);
    }


    private class MyTouchListener implements View.OnTouchListener {
        private View view;

        public MyTouchListener(View view) {
            this.view = view;
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            switch (action) {
                case MotionEvent.ACTION_DOWN:
                    //触摸缩放动画
                    AnimUtils.touchAnimDown(view,defaultDelayTime);
                    break;
                case MotionEvent.ACTION_UP:
                    //抬起缩放动画
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            AnimUtils.touchAnimUp(view,defaultDelayTime);
                        }
                    }, defaultDelayTime);
                    break;
                case MotionEvent.ACTION_CANCEL:
                    AnimUtils.touchAnimUp(view,defaultDelayTime);
                    break;
            }
            return false;
        }
    }

}
