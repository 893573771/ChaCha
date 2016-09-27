package com.ghy.chacha.adapter;

import android.content.Context;

import com.ghy.baseapp.adapter.baserecycler.BaseQuickAdapter;
import com.ghy.baseapp.adapter.baserecycler.BaseViewHolder;
import com.ghy.chacha.R;

import java.util.List;

/**
 * Created by GHY on 2016/9/27.
 * Desc:微信精选recyclerView适配器
 */

public class WeChatListAdapter extends BaseQuickAdapter<String> {

    public WeChatListAdapter(Context context, List data) {
        super(context, R.layout.item_we_chat, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_item_we_chat,item);
    }
}
