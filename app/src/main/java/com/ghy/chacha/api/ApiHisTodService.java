package com.ghy.chacha.api;


import com.ghy.chacha.bean.HisTodBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 历史上的今天api接口
 * http://apicloud.mob.com/appstore/history/query?key=123456&day=1231
 */
public interface ApiHisTodService {

    @GET(APIS.HISTORY_TODAY)
    Observable<HisTodBean> getHisTodInfo(@Query("key") String cityKey, @Query("day") String day);

}
