package com.ghy.chacha.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ghy.baseapp.api.RetrofitHelper;
import com.ghy.baseapp.base.AbsBaseActivity;
import com.ghy.baseapp.common.log.Log;
import com.ghy.baseapp.common.utils.DateUtils;
import com.ghy.chacha.R;
import com.ghy.chacha.adapter.HisTodListAdapter;
import com.ghy.chacha.api.APIS;
import com.ghy.chacha.api.ApiHisTodService;
import com.ghy.chacha.bean.HisTodBean;
import com.ghy.chacha.helper.TitleHelper;

import java.util.List;

import butterknife.Bind;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 历史上的今天
 */
public class HistoryTodayActivity extends AbsBaseActivity {

    @Bind(R.id.his_tod_list)
    ListView mListView;

    private List<HisTodBean.ResultBean> mList;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_history_today;
    }

    @Override
    protected String getToolBarTitle() {
        return TitleHelper.TITLE_HISTORY_TODAY;
    }

    @Override
    protected void init() {

        setActivityStatus(ACTIVITY_STATUS_LOADING);
        //请求历史上的今天数据
        requestHisTodData();

        //点击事件，跳转到历史事件详情页面
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HistoryTodayDetailActivity.startHistoryTodayDetailActivity(HistoryTodayActivity.this,
                        mList.get(position).getTitle(),mList.get(position).getEvent());
            }
        });

    }

    /**
     * Created by GHY on 2016/9/21.
     * MethodDesc:请求历史上的今天数据
     **/
    private void requestHisTodData() {

        ApiHisTodService api = RetrofitHelper.getRetrofit().create(ApiHisTodService.class);
        Observable<HisTodBean> observable = api.getHisTodInfo(APIS.APPKEY, DateUtils.getCurrentDate(DateUtils.dateFormatMMDD));
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HisTodBean>() {
                    @Override
                    public void onCompleted() {
                        Log.i("RxJava----", "requestHisTodData--onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("RxJava----", "onError" + e.toString());
                        setActivityStatus(ACTIVITY_STATUS_ERROR);
                    }

                    @Override
                    public void onNext(HisTodBean hisTodBean) {
                        if (hisTodBean == null ){
                            setActivityStatus(ACTIVITY_STATUS_EMPTY);
                        }else if (hisTodBean.getResult() == null || hisTodBean.getResult().size() == 0){
                            setActivityStatus(ACTIVITY_STATUS_EMPTY);
                        }else {
                            setActivityStatus(ACTIVITY_STATUS_SUCCESS);
                            //设置Adapter
                            HisTodListAdapter adapter = new HisTodListAdapter(HistoryTodayActivity.this,hisTodBean);
                            mListView.setAdapter(adapter);
                            mList = hisTodBean.getResult();
                        }
                    }
                });
    }

    @Override
    protected void onEmptyClick(View view) {
        super.onEmptyClick(view);
        setActivityStatus(ACTIVITY_STATUS_LOADING);
        //重新请求历史上的今天数据
        requestHisTodData();
    }

    @Override
    protected void onErrorClick(View view) {
        super.onErrorClick(view);
        setActivityStatus(ACTIVITY_STATUS_LOADING);
        //重新请求历史上的今天数据
        requestHisTodData();
    }
}
