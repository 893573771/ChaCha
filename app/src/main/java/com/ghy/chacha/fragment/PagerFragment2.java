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
import com.ghy.chacha.activity.OilTodayActivity;
import com.ghy.chacha.activity.WeChatArticleActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by HY on 2016/5/1.
 */
public class PagerFragment2 extends AbsBaseFragment {

    /** Fragment当前状态是否可见 */
    protected boolean isVisible = false;
    /** Fragment是否加载了数据 */
    protected boolean isLoad = false;

    @Bind(R.id.home_fun1)
    TextView tvHomeFun1;
    @Bind(R.id.home_fun2)
    TextView tvHomeFun2;
    @Bind(R.id.home_fun3)
    TextView tvHomeFun3;
    @Bind(R.id.home_fun4)
    TextView tvHomeFun4;

    @Bind(R.id.home_fun5)
    TextView tvHomeFun5;
    @Bind(R.id.home_fun6)
    TextView tvHomeFun6;
    @Bind(R.id.home_fun7)
    TextView tvHomeFun7;
    @Bind(R.id.home_fun8)
    TextView tvHomeFun8;

    private long defaultDelayTime = 300;//触摸动画默认延迟时间

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_pager2;
    }


    @Override
    protected void init(Bundle savedInstanceState, View contentView) {
//        Logger.i("fragment2 init。。。。。");

        tvHomeFun1.setOnTouchListener(new PagerFragment2.MyTouchListener(tvHomeFun1));
        tvHomeFun2.setOnTouchListener(new PagerFragment2.MyTouchListener(tvHomeFun2));
        tvHomeFun3.setOnTouchListener(new PagerFragment2.MyTouchListener(tvHomeFun3));
        tvHomeFun4.setOnTouchListener(new PagerFragment2.MyTouchListener(tvHomeFun4));

        tvHomeFun5.setOnTouchListener(new PagerFragment2.MyTouchListener(tvHomeFun5));
        tvHomeFun6.setOnTouchListener(new PagerFragment2.MyTouchListener(tvHomeFun6));
        tvHomeFun7.setOnTouchListener(new PagerFragment2.MyTouchListener(tvHomeFun7));
        tvHomeFun8.setOnTouchListener(new PagerFragment2.MyTouchListener(tvHomeFun8));

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

    @OnClick(R.id.home_fun5)
    public void homeFun5() {
        //待定
    }

    @OnClick(R.id.home_fun6)
    public void homeFun6() {
        //待定
    }

    @OnClick(R.id.home_fun7)
    public void homeFun7() {
        delayStartActivity(OilTodayActivity.class);
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

    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(getUserVisibleHint()) {
            isVisible = true;
//            Logger.i("fragment2可见啦。。。。。");
            load();
            isLoad = true;
        } else {
            isVisible = false;
//            Logger.i("fragment2不可见。。。。。");
        }
    }

    private void load() {
        if (isLoad){
//            Logger.i("fragment2已经加载过数据，不再加载数据。。。。。");
        }else {
//            Logger.i("fragment2没有加载过数据，开始加载数据。。。。。");
        }
    }

}
