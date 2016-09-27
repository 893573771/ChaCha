package com.ghy.chacha.adapter;

import android.content.Context;

import com.ghy.baseapp.adapter.baserecycler.BaseQuickAdapter;
import com.ghy.baseapp.adapter.baserecycler.BaseViewHolder;
import com.ghy.chacha.R;
import com.ghy.chacha.bean.WeChatListBean;

import java.util.List;

/**
 * Created by GHY on 2016/9/27.
 * Desc:微信精选recyclerView适配器
 */

public class WeChatListAdapter extends BaseQuickAdapter<WeChatListBean.ResultBean.ListBean> {

    public WeChatListAdapter(Context context, List<WeChatListBean.ResultBean.ListBean> data) {
        super(context, R.layout.item_we_chat, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WeChatListBean.ResultBean.ListBean item) {
        helper.setText(R.id.item_we_chat_title,item.getTitle());
        helper.setText(R.id.item_we_chat_time,item.getPubTime());
    }
}
