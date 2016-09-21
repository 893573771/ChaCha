package com.ghy.chacha.activity;

import android.widget.ListView;

import com.ghy.baseapp.api.RetrofitHelper;
import com.ghy.baseapp.base.AbsBaseActivity;
import com.ghy.baseapp.common.log.Log;
import com.ghy.baseapp.helper.ToastHelper;
import com.ghy.chacha.R;
import com.ghy.chacha.adapter.HisTodListAdapter;
import com.ghy.chacha.api.APIS;
import com.ghy.chacha.api.ApiHisTodService;
import com.ghy.chacha.bean.HisTodBean;
import com.ghy.chacha.helper.TitleHelper;

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

        //请求历史上的今天数据
        requestHisTodData();

    }

    /**
     * Created by GHY on 2016/9/21.
     * MethodDesc:请求历史上的今天数据
     **/
    private void requestHisTodData() {

        ApiHisTodService api = RetrofitHelper.getRetrofit().create(ApiHisTodService.class);
        Observable<HisTodBean> observable = api.getHisTodInfo(APIS.APPKEY,"0921");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HisTodBean>() {
                    @Override
                    public void onCompleted() {
                        Log.i("RxJava----", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("RxJava----", "onError" + e.toString());
                        ToastHelper.getInstance().showToast("请求出错");
                    }

                    @Override
                    public void onNext(HisTodBean hisTodBean) {

                        HisTodListAdapter adapter = new HisTodListAdapter(HistoryTodayActivity.this,hisTodBean);
                        mListView.setAdapter(adapter);

                    }
                });
    }

}
