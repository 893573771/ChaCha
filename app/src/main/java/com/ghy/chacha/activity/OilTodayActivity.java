package com.ghy.chacha.activity;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ghy.baseapp.api.RetrofitHelper;
import com.ghy.baseapp.base.AbsBaseActivity;
import com.ghy.baseapp.common.log.Log;
import com.ghy.baseapp.common.utils.SPUtils;
import com.ghy.baseapp.view.WheelView;
import com.ghy.chacha.R;
import com.ghy.chacha.api.APIS;
import com.ghy.chacha.api.ApiService;
import com.ghy.chacha.bean.OilPriceBean;
import com.ghy.chacha.helper.SPKeyHelper;
import com.ghy.chacha.helper.TitleHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 今日油价
 */
public class OilTodayActivity extends AbsBaseActivity {


    /**
     * 城市省份
     */
    @Bind(R.id.oil_price_tv_city)
    TextView oilPriceTvCity;
    /**
     * 90#
     * 汽油价格
     */
    @Bind(R.id.oil_price_90)
    TextView oilPrice90;
    /**
     * 93#
     * 汽油价格
     */
    @Bind(R.id.oil_price_93)
    TextView oilPrice93;
    /**
     * 97#
     * 汽油价格
     */
    @Bind(R.id.oil_price_97)
    TextView oilPrice97;
    /**
     * 0#
     * 柴油价格
     */
    @Bind(R.id.oil_price_0)
    TextView oilPrice0;

    /**
     * 选择城市按钮
     */
    private TextView tvProvinceDone;
    /**
     * 选择的城市
     * 默认为北京
     */
    private String selectedProvince = "北京";
    /**
     * 保存的省份
     */
    private String saveProvince;
    /**
     * 保存的省份在数组位置
     */
    private int saveProvinceLocation;

    /**
     * 省份
     */
    private String provinceArray[] = {
            "安徽", "北京", "重庆", "福建", "甘肃",
            "广东", "广西", "贵州", "海南", "河北",
            "黑龙江", "河南", "湖北", "湖南", "江苏",
            "江西", "吉林", "辽宁", "内蒙古", "宁夏",
            "青海", "陕西", "山东", "上海", "山西",
            "四川", "天津", "新疆", "西藏", "云南", "浙江"};
    /**
     * 省份列表
     */
    private List<String> provinceStringList;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_oil_today;
    }

    @Override
    protected String getToolBarTitle() {
        return TitleHelper.TITLE_OIL_TODAY;
    }

    @Override
    protected void init() {

        oilPriceTvCity.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线
        oilPriceTvCity.getPaint().setAntiAlias(true);//抗锯齿

        //请求网络数据
        requestOilPrice();

        requestSaveProvinceOilPrice();

    }

    /**
     * 获取保存的省份并请求油价数据
     * <p>
     * <p>
     * <p>
     * 注意：此接口不规范，暂时不能设置省份。。。待修改优化。。。
     */
    private void requestSaveProvinceOilPrice() {
        saveProvince = SPUtils.getString(OilTodayActivity.this, SPKeyHelper.KEY_OIL_PROVINCE);
        if (saveProvince == null || saveProvince.equals("")) {
            //没有保存的省份默认请求北京
//            requestOilPriceApi(provinceArray[1]);
        } else {
//            requestOilPriceApi(saveProvince);
            setProvinceTextView(saveProvince);
        }
    }

    @OnClick(R.id.oil_price_city_layout)
    public void changeCityClick() {
        changeProvinceClick();
    }

    //请求油价数据
    private void requestOilPrice() {
        ApiService.OilTodayService api = RetrofitHelper.getRetrofit().create(ApiService.OilTodayService.class);
        Observable<OilPriceBean> observable = api.getOilPriceInfo(APIS.APPKEY);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<OilPriceBean>() {

                    @Override
                    public void onCompleted() {
                        Log.i("RxJava----", "requestPhoneApi--onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("RxJava----", "onError" + e.toString());
                    }

                    @Override
                    public void onNext(OilPriceBean oilPriceBean) {

                        oilPrice90.setText(oilPriceBean.getResult().getHenan().getGasoline90());
                        oilPrice93.setText(oilPriceBean.getResult().getHenan().getGasoline93());
                        oilPrice97.setText(oilPriceBean.getResult().getHenan().getGasoline97());
                        oilPrice0.setText(oilPriceBean.getResult().getHenan().getDieselOil0());

                    }
                });
    }

    /**
     * 切换省份
     */
    private void changeProvinceClick() {
        //弹出底部省份选择蒙版
        showProvincePopupWindow();
    }

    /**
     * 底部省份选择蒙版
     */
    private PopupWindow popupWindow;

    private void showProvincePopupWindow() {
        //导入布局文件
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.layout_province_popup_window, null);
        //省份选择控件
        WheelView wheelView = (WheelView) popupView.findViewById(R.id.province_wv);
        //完成按钮
        tvProvinceDone = (TextView) popupView.findViewById(R.id.oil_province_select_done);

        popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setAnimationStyle(R.style.AnimationPopupWindow);
        popupWindow.showAtLocation(findViewById(R.id.oil_price_fg_layout),
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        //加载省份列表
        initWheelView(wheelView);
    }

    private void initWheelView(WheelView wheelView) {
        provinceStringList = new ArrayList<>();
        for (int i = 0; i < provinceArray.length; i++) {
            provinceStringList.add(provinceArray[i]);
        }

        //根据点选的省份获取其在数组中的位置
        saveProvince = SPUtils.getString(OilTodayActivity.this, SPKeyHelper.KEY_OIL_PROVINCE);
        if (saveProvince == null || saveProvince.equals("")) {
            saveProvinceLocation = 1;
        } else {
            for (int i = 0; i < provinceArray.length; i++) {
                if (saveProvince.equals(provinceArray[i])) {
                    saveProvinceLocation = i;
                }
            }
        }

        //上下各显示2个
        wheelView.setOffset(2);
        wheelView.setItems(provinceStringList);
        //默认选中点选的省份
        wheelView.setSeletion(saveProvinceLocation);
        selectedProvince = provinceArray[saveProvinceLocation];
        wheelView.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                selectedProvince = item;
                Log.i("----oilProvince----" + selectedProvince);
            }
        });

        /**
         * 选择省份点击事件
         */
        tvProvinceDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disMissPopupWindow();
                //保存查询的省份
                SPUtils.putString(OilTodayActivity.this, SPKeyHelper.KEY_OIL_PROVINCE, selectedProvince);
                //设置省份信息
                setProvinceTextView(selectedProvince);
                //请求油价数据

            }
        });
    }

    /**
     * 设置省份信息
     *
     * @param province
     */
    private void setProvinceTextView(String province) {
        oilPriceTvCity.setText(province);
        oilPriceTvCity.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线
        oilPriceTvCity.getPaint().setAntiAlias(true);//抗锯齿
    }

    private void disMissPopupWindow() {
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

}
