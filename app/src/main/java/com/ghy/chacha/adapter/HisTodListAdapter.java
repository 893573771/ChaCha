package com.ghy.chacha.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ghy.baseapp.adapter.ViewHolder;
import com.ghy.baseapp.component.labelview.LabelTextView;
import com.ghy.chacha.R;
import com.ghy.chacha.bean.HisTodBean;

import java.util.List;

/**
 * Created by GHY on 2016/9/20.
 * Desc: 历史上的今天列表适配器
 */

public class HisTodListAdapter extends BaseAdapter {

    private List<HisTodBean.ResultBean> mList;
    private Context mContext;

    public HisTodListAdapter(Context context, HisTodBean hisTodBean) {
        mContext = context;
        mList = hisTodBean.getResult();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_his_tod_list, null);
        }

        TextView tvtitle = ViewHolder.get(convertView, R.id.tv_his_tod_title);
        LabelTextView tvdate = ViewHolder.get(convertView, R.id.tv_his_tod_date);
        TextView tvcontent = ViewHolder.get(convertView, R.id.tv_his_tod_content);

        tvtitle.setText(mList.get(position).getTitle());
        String date = mList.get(position).getDate().substring(0, 4);//截取年份19940921--1994
        int day = Integer.parseInt(date);
        tvdate.setLabelText(day >= 1000 && day <= 2100 ? date : "未知");
        tvcontent.setText(mList.get(position).getEvent());

        return convertView;
    }
}
