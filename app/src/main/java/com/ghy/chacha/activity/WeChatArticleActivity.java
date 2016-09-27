package com.ghy.chacha.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.ghy.baseapp.api.RetrofitHelper;
import com.ghy.baseapp.base.AbsBaseActivity;
import com.ghy.baseapp.common.log.Log;
import com.ghy.chacha.R;
import com.ghy.chacha.api.APIS;
import com.ghy.chacha.api.ApiService;
import com.ghy.chacha.bean.WeChatTypeBean;
import com.ghy.chacha.fragment.WeChatPageFragment;
import com.ghy.chacha.helper.TitleHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 微信精选页面
 */
public class WeChatArticleActivity extends AbsBaseActivity implements OnTabSelectListener{

    @Bind(R.id.we_chat_tab_layout)
    SlidingTabLayout mTabLayout;

    @Bind(R.id.we_chat_viewpager)
    ViewPager mViewPager;

    private MyPagerAdapter mAdapter;

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private List<WeChatTypeBean.ResultBean> mTitles = new ArrayList<>();

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

        setActivityStatus(ACTIVITY_STATUS_LOADING);
        //请求分类数据
        requestWeChatTypeData();

    }

    /**
     * Created by GHY on 2016/9/27.
     * MethodDesc:请求微信精选分类数据
     **/
    private void requestWeChatTypeData() {
        ApiService.WeChatTypeService api = RetrofitHelper.getRetrofit().create(ApiService.WeChatTypeService.class);
        Observable<WeChatTypeBean> observable = api.getWeChatTypeInfo(APIS.APPKEY);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WeChatTypeBean>() {

                    @Override
                    public void onCompleted() {
                        Log.i("RxJava----", "requestWeChatTypeData--onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("RxJava----", "onError" + e.toString());
                        setActivityStatus(ACTIVITY_STATUS_ERROR);
                    }

                    @Override
                    public void onNext(WeChatTypeBean weChatTypeBean) {
                        if (weChatTypeBean == null || weChatTypeBean.getResult().size() == 0){
                            setActivityStatus(ACTIVITY_STATUS_EMPTY);
                            return;
                        } else {
                            setActivityStatus(ACTIVITY_STATUS_SUCCESS);
                        }
                        //请求分类数据成功
                        //获取分类名
                        mTitles = weChatTypeBean.getResult();
                        //创建分类fragment
                        for (int i=0;i<weChatTypeBean.getResult().size();i++){
                            //分类id
                            String cid = weChatTypeBean.getResult().get(i).getCid();
                            mFragments.add(WeChatPageFragment.getInstance(cid));
                        }
                        //设置adapter
                        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
                        mViewPager.setAdapter(mAdapter);

                        //设置关联
                        mTabLayout.setViewPager(mViewPager);
                        mTabLayout.setOnTabSelectListener(WeChatArticleActivity.this);

                    }
                });
    }

    @Override
    public void onTabSelect(int position) {

    }

    @Override
    public void onTabReselect(int position) {

    }

    /**
     * ViewPager适配器
     */
    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position).getName();
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }

    @Override
    protected void onEmptyClick(View view) {
        super.onEmptyClick(view);
        setActivityStatus(ACTIVITY_STATUS_LOADING);
        //重新请求分类数据
        requestWeChatTypeData();
    }

    @Override
    protected void onErrorClick(View view) {
        super.onErrorClick(view);
        setActivityStatus(ACTIVITY_STATUS_LOADING);
        //重新请求分类数据
        requestWeChatTypeData();
    }
}
