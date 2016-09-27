package com.ghy.chacha.fragment;

import android.os.Handler;

import com.ghy.baseapp.adapter.baserecycler.BaseQuickAdapter;
import com.ghy.baseapp.api.RetrofitHelper;
import com.ghy.baseapp.base.AbsBaseRefreshRecyclerFragment;
import com.ghy.baseapp.common.log.Log;
import com.ghy.baseapp.common.logger.Logger;
import com.ghy.baseapp.helper.ToastHelper;
import com.ghy.chacha.activity.WebViewActivity;
import com.ghy.chacha.adapter.WeChatListAdapter;
import com.ghy.chacha.api.APIS;
import com.ghy.chacha.api.ApiService;
import com.ghy.chacha.bean.WeChatListBean;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.ghy.baseapp.base.AbsBaseActivity.ACTIVITY_STATUS_ERROR;

/**
 * Created by GHY on 2016/9/27.
 * Desc: 微信精选fragment页面
 */

public class WeChatPageFragment extends AbsBaseRefreshRecyclerFragment {

    /** Fragment当前状态是否可见 */
    protected boolean isVisible = false;
    /** Fragment是否加载了数据 */
    protected boolean isLoad = false;

    private List<WeChatListBean.ResultBean.ListBean> list;

    /**
     * 分类id
     */
    private String mCid;

    /**
     * 根据分类id请求分类数据
     * @param cid 分类id
     * @return
     */
    public static WeChatPageFragment getInstance(String cid) {
        WeChatPageFragment weChatPageFragment = new WeChatPageFragment();
        weChatPageFragment.mCid = cid;
        return weChatPageFragment;
    }

    @Override
    protected void init() {

        list = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            list.add("recycler item " + i);
//        }

    }

    @Override
    protected boolean isOpenItemDecoration() {
        return true;
    }

    /**
     * 是否加载更多，暂时关闭
     * @return
     */
    @Override
    protected boolean isOpenLoadMore() {
        return false;
    }

    @Override
    protected BaseQuickAdapter getAbsQuickAdapter() {
        return new WeChatListAdapter(getActivity(),list);
    }

    @Override
    protected void onRefreshStart() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                list.add(0, "Hello,I am a new Item");
                setOnRefreshComplete(list);
                ToastHelper.getInstance().showToast("刷新成功");
            }
        }, 3000);
    }

    @Override
    protected void onLoadMoreStart() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                listAdd = new ArrayList<>();
//                listAdd.add("Hi I am a load Message1");
//                listAdd.add("Hi I am a load Message2");
                setOnLoadMoreComplete(list);
                ToastHelper.getInstance().showToast("加载成功");
            }
        }, 3000);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(getUserVisibleHint()) {
            isVisible = true;
            Logger.i("fragment--"+mCid+"可见啦。。。。。");
            load();
            isLoad = true;
        } else {
            isVisible = false;
            Logger.i("fragment--"+mCid+"不可见。。。。。");
        }
    }

    private void load() {
        //请求数据方法
        requestWeChatList();
//        if (isLoad){
//            Logger.i("fragment--"+mCid+"已经加载过数据，不再加载数据。。。。。");
//        }else {
//            Logger.i("fragment--"+mCid+"没有加载过数据，开始加载数据。。。。。");
//            //请求数据方法
//            requestWeChatList();
//        }
    }

    private void requestWeChatList() {
        ApiService.WeChatListService api = RetrofitHelper.getRetrofit().create(ApiService.WeChatListService.class);
        Observable<WeChatListBean> observable = api.getWeChatListInfo(APIS.APPKEY,mCid);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WeChatListBean>() {

                    @Override
                    public void onCompleted() {
                        Log.i("RxJava----", "requestWeChatList--onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("RxJava----", "onError" + e.toString());
                        setFragmentStatus(ACTIVITY_STATUS_ERROR);
                    }

                    @Override
                    public void onNext(WeChatListBean weChatListBean) {
                        if (weChatListBean == null || weChatListBean.getResult() == null
                                || weChatListBean.getResult().getList().size() == 0){
                            setFragmentStatus(FRAGMENT_STATUS_EMPTY);
                            return;
                        }
                        //设置数据源
                        list = weChatListBean.getResult().getList();
                        setData(list);
                        //点击事件
                        setOnItemClickListener(new OnItemClickListener() {
                            @Override
                            public void onItemClick(int position) {
                                WebViewActivity.startWebViewActivity(getActivity(),list.get(position).getSourceUrl());
                            }
                        });
                    }
                });

    }

}
