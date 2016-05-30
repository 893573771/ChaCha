package com.ghy.chacha.fragment;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.ghy.baseapp.base.AbsBaseFragment;
import com.ghy.baseapp.utils.AnimUtils;
import com.ghy.chacha.R;

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
    }

    @OnClick(R.id.home_fun1)
    public void homeFun1(){

    }

    @OnClick(R.id.home_fun2)
    public void homeFun2(){

    }

    @OnClick(R.id.home_fun3)
    public void homeFun3(){

    }

    @OnClick(R.id.home_fun4)
    public void homeFun4(){

    }


    private class MyTouchListener implements View.OnTouchListener{
        private View view;
        public MyTouchListener(View view) {
            this.view = view;
        }
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            switch (action){
                case MotionEvent.ACTION_DOWN:
                    AnimUtils.scaleX1(view,400);
                    AnimUtils.scaleY1(view,400);
                    AnimUtils.rotation1(view,400);
                    break;
                case MotionEvent.ACTION_UP:
                    AnimUtils.scaleX2(view,400);
                    AnimUtils.scaleY2(view,400);
                    AnimUtils.rotation2(view,400);
                    break;
            }
            return false;
        }
    }

}
