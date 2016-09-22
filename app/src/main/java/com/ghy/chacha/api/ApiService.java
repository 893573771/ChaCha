package com.ghy.chacha.api;

import com.ghy.chacha.bean.HisTodBean;
import com.ghy.chacha.bean.NumberBelongBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by GHY on 2016/9/22.
 * Desc:数据api接口
 */

public class ApiService {

    /**
     * 历史上的今天api接口
     * http://apicloud.mob.com/appstore/history/query?key=123456&day=1231
     */
    public interface ApiHisTodService {

        @GET(APIS.HISTORY_TODAY)
        Observable<HisTodBean> getHisTodInfo(@Query("key") String appKey, @Query("day") String day);

    }


    /**
     * 手机号码归属api接口
     * http://apicloud.mob.com/v1/mobile/address/query?key=123456&phone=13300001982
     */
    public interface NumberBelongService {

        @GET(APIS.NUMBER_BELONG)
        Observable<NumberBelongBean> getPhoneInfo(@Query("key") String appKey, @Query("phone") String phoneNumber);

    }
}
