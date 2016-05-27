package com.ghy.baseapp.api.okhttp.builder;

import com.ghy.baseapp.api.okhttp.OkHttpUtils;
import com.ghy.baseapp.api.okhttp.request.OtherRequest;
import com.ghy.baseapp.api.okhttp.request.RequestCall;

/**
 * Created by zhy on 16/3/2.
 */
public class HeadBuilder extends GetBuilder {
    @Override
    public RequestCall build() {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers).build();
    }
}
