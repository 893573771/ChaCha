package com.ghy.chacha;

import com.ghy.baseapp.BaseApplication;
import com.mob.mobapi.MobAPI;

/**
 * Created by GHY on 2016/5/27.
 */
public class ChaChaApplication  extends BaseApplication{

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化Mob SDK
        initMobSdk();
    }

    private void initMobSdk() {
        MobAPI.initSDK(this, "133df0f3cd5d8");
    }
}
