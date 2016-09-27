package com.ghy.chacha.fragment;

import android.os.Handler;

import com.ghy.baseapp.adapter.baserecycler.BaseQuickAdapter;
import com.ghy.baseapp.base.AbsBaseRefreshRecyclerFragment;
import com.ghy.baseapp.helper.ToastHelper;
import com.ghy.chacha.adapter.WeChatListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GHY on 2016/9/27.
 * Desc: 微信精选fragment页面
 */

public class WeChatPageFragment extends AbsBaseRefreshRecyclerFragment {

    /** Fragment当前状态是否可见 */
    protected boolean isVisible = false;
    /** Fragment是否加载了数据 */
    protected boolean isLoad = false;

    private List<String> list;
    private List<String> listAdd;

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
        for (int i = 0; i < 20; i++) {
            list.add("recycler item " + i);
        }

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
                list.add(0, "Hello,I am a new Item");
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
                listAdd = new ArrayList<>();
                listAdd.add("Hi I am a load Message1");
                listAdd.add("Hi I am a load Message2");
                setOnLoadMoreComplete(listAdd);
                ToastHelper.getInstance().showToast("加载成功");
            }
        }, 3000);
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
