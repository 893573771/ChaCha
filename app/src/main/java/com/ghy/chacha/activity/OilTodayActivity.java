package com.ghy.chacha.activity;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ghy.baseapp.api.RetrofitHelper;
import com.ghy.baseapp.base.AbsBaseActivity;
import com.ghy.baseapp.common.log.Log;
import com.ghy.baseapp.common.utils.SPUtils;
import com.ghy.baseapp.utils.SnackbarUtils;
import com.ghy.baseapp.view.WheelView;
import com.ghy.chacha.R;
import com.ghy.chacha.api.APIS;
import com.ghy.chacha.api.ApiService;
import com.ghy.chacha.bean.OilPriceBean;
import com.ghy.chacha.helper.SPKeyHelper;
import com.ghy.chacha.helper.TitleHelper;

import java.text.DecimalFormat;
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
     * 提示信息
     */
    @Bind(R.id.oil_notice)
    TextView oilNotice;

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

    /**
     * 请求回来的全部省份的数据
     */
    private OilPriceBean mOilPriceBean;

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

        //获取保存的省份信息
        saveProvince = SPUtils.getString(OilTodayActivity.this, SPKeyHelper.KEY_OIL_PROVINCE);
        if (TextUtils.isEmpty(saveProvince)){
            setProvinceTextView(provinceArray[2]);
        }else {
            setProvinceTextView(saveProvince);
        }

        //请求网络数据
        requestOilPrice();
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
                        SnackbarUtils.showSnackbarDefault(oilPriceTvCity, "请求出错，请重试！").show();
                    }

                    @Override
                    public void onNext(OilPriceBean oilPriceBean) {

                        if (oilPriceBean == null){
                            SnackbarUtils.showSnackbarDefault(oilPriceTvCity, "未知错误，请重试！").show();
                            return;
                        }
                        //请求所有省份数据结束
                        //设置保存省份的油价信息
                        setSaveProvinceOilPrice(oilPriceBean);

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

        //设置背景颜色变暗
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.5f;
        getWindow().setAttributes(lp);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
            }
        });

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
        if (TextUtils.isEmpty(saveProvince)) {
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
                //注意：由于数据都已请求回来，不需要重复请求，调用设置保存的省份油价数据即可
                if (mOilPriceBean != null){
                    setSaveProvinceOilPrice(mOilPriceBean);
                }else {
                    SnackbarUtils.showSnackbarDefault(oilPriceTvCity, "抱歉，数据集为空！").show();
                }

            }
        });
    }

    /**
     * 设置选中省份文本信息（标下划线）
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

    /**
     * 设置保存省份的油价数据
     * @param oilPriceBean
     *
     * 由于接口不合理原因，此处较复杂，待优化
     */
    private void setSaveProvinceOilPrice(OilPriceBean oilPriceBean) {

        this.mOilPriceBean = oilPriceBean;

        //京沪油价提示信息默认不可见
        oilNotice.setVisibility(View.GONE);

        saveProvince = SPUtils.getString(OilTodayActivity.this, SPKeyHelper.KEY_OIL_PROVINCE);
        if (TextUtils.isEmpty(saveProvince)){
            //没有保存的省份默认为北京
            //强转处理，保留小数点后两位
            DecimalFormat df = new DecimalFormat("0.00");
            //5.2(京89号)截取5.2
            oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getBeijing().getGasoline90().substring(0,4).contains("(")?
                    oilPriceBean.getResult().getBeijing().getGasoline90().substring(0,3):oilPriceBean.getResult().getBeijing().getGasoline90().substring(0,4))));
            oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getBeijing().getGasoline93().substring(0,4).contains("(")?
                    oilPriceBean.getResult().getBeijing().getGasoline93().substring(0,3):oilPriceBean.getResult().getBeijing().getGasoline93().substring(0,4))));
            oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getBeijing().getGasoline97().substring(0,4).contains("(")?
                    oilPriceBean.getResult().getBeijing().getGasoline97().substring(0,3):oilPriceBean.getResult().getBeijing().getGasoline97().substring(0,4))));
            oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getBeijing().getDieselOil0())));
        }else {
            //各个省份油价
            if (saveProvince.equals("安徽")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getAnhui().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getAnhui().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getAnhui().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getAnhui().getDieselOil0())));
            }else if (saveProvince.equals("北京")){
                DecimalFormat df = new DecimalFormat("0.00");
                //5.2(京89号)截取5.2
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getBeijing().getGasoline90().substring(0,3))));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getBeijing().getGasoline93().substring(0,3))));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getBeijing().getGasoline97().substring(0,3))));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getBeijing().getDieselOil0())));
            }else if (saveProvince.equals("重庆")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getChongqing().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getChongqing().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getChongqing().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getChongqing().getDieselOil0())));
            }else if (saveProvince.equals("福建")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getFujian().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getFujian().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getFujian().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getFujian().getDieselOil0())));
            }else if (saveProvince.equals("甘肃")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getGansu().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getGansu().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getGansu().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getGansu().getDieselOil0())));
            }else if (saveProvince.equals("广东")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getGuangdong().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getGuangdong().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getGuangdong().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getGuangdong().getDieselOil0())));
            }else if (saveProvince.equals("广西")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getGuangxi().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getGuangxi().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getGuangxi().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getGuangxi().getDieselOil0())));
            }else if (saveProvince.equals("贵州")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getGuizhou().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getGuizhou().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getGuizhou().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getGuizhou().getDieselOil0())));
            }else if (saveProvince.equals("海南")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getHainan().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getHainan().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getHainan().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getHainan().getDieselOil0())));
            }else if (saveProvince.equals("河北")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getHebei().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getHebei().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getHebei().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getHebei().getDieselOil0())));
            }else if (saveProvince.equals("黑龙江")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getHeilongjiang().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getHeilongjiang().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getHeilongjiang().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getHeilongjiang().getDieselOil0())));
            }else if (saveProvince.equals("河南")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getHenan().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getHenan().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getHenan().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getHenan().getDieselOil0())));
            }else if (saveProvince.equals("湖北")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getHubei().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getHubei().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getHubei().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getHubei().getDieselOil0())));
            }else if (saveProvince.equals("湖南")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getHunan().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getHunan().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getHunan().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getHunan().getDieselOil0())));
            }else if (saveProvince.equals("江苏")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getJiangsu().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getJiangsu().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getJiangsu().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getJiangsu().getDieselOil0())));
            }else if (saveProvince.equals("江西")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getJiangxi().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getJiangxi().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getJiangxi().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getJiangxi().getDieselOil0())));
            }else if (saveProvince.equals("吉林")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getJilin().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getJilin().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getJilin().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getJilin().getDieselOil0())));
            }else if (saveProvince.equals("辽宁")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getLiaoning().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getLiaoning().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getLiaoning().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getLiaoning().getDieselOil0())));
            }else if (saveProvince.equals("内蒙古")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getNeimenggu().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getNeimenggu().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getNeimenggu().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getNeimenggu().getDieselOil0())));
            }else if (saveProvince.equals("宁夏")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getNingxia().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getNingxia().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getNingxia().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getNingxia().getDieselOil0())));
            }else if (saveProvince.equals("青海")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getQinghai().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getQinghai().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getQinghai().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getQinghai().getDieselOil0())));
            }else if (saveProvince.equals("陕西")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getSanxi().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getSanxi().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getSanxi().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getSanxi().getDieselOil0())));
            }else if (saveProvince.equals("山东")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getShandong().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getShandong().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getShandong().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getShandong().getDieselOil0())));
            }else if (saveProvince.equals("上海")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getShanghai().getGasoline90().substring(0,4).contains("(")?
                        oilPriceBean.getResult().getShanghai().getGasoline90().substring(0,3):oilPriceBean.getResult().getShanghai().getGasoline90().substring(0,4))));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getShanghai().getGasoline93().substring(0,4).contains("(")?
                        oilPriceBean.getResult().getShanghai().getGasoline93().substring(0,3):oilPriceBean.getResult().getShanghai().getGasoline93().substring(0,4))));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getShanghai().getGasoline97().substring(0,4).contains("(")?
                        oilPriceBean.getResult().getShanghai().getGasoline97().substring(0,3):oilPriceBean.getResult().getShanghai().getGasoline97().substring(0,4))));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getShanghai().getDieselOil0())));
            }else if (saveProvince.equals("山西")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getShanxi().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getShanxi().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getShanxi().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getShanxi().getDieselOil0())));
            }else if (saveProvince.equals("四川")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getSichuan().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getSichuan().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getSichuan().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getSichuan().getDieselOil0())));
            }else if (saveProvince.equals("天津")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getTianjin().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getTianjin().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getTianjin().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getTianjin().getDieselOil0())));
            }else if (saveProvince.equals("新疆")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getXinjiang().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getXinjiang().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getXinjiang().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getXinjiang().getDieselOil0())));
            }else if (saveProvince.equals("西藏")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getXizang().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getXizang().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getXizang().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getXizang().getDieselOil0())));
            }else if (saveProvince.equals("云南")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getYunnan().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getYunnan().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getYunnan().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getYunnan().getDieselOil0())));
            }else if (saveProvince.equals("浙江")){
                DecimalFormat df = new DecimalFormat("0.00");
                oilPrice90.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getZhejiang().getGasoline90())));
                oilPrice93.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getZhejiang().getGasoline93())));
                oilPrice97.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getZhejiang().getGasoline97())));
                oilPrice0.setText(df.format(Double.parseDouble(oilPriceBean.getResult().getZhejiang().getDieselOil0())));
            }else {
                oilPrice90.setText("0.00");
                oilPrice93.setText("0.00");
                oilPrice97.setText("0.00");
                oilPrice0.setText("0.00");
            }

            //京沪油价提示
            if (!TextUtils.isEmpty(saveProvince)){

                if (saveProvince.equals("北京")){
                    oilNotice.setVisibility(View.VISIBLE);
                    oilNotice.setText("注：90#(京89号)、93#(京92号)、97#(京95号)");
                }else if (saveProvince.equals("上海")){
                    oilNotice.setVisibility(View.VISIBLE);
                    oilNotice.setText("注：90#(沪89号)、93#(沪92号)、97#(沪95号)");
                }

            }
        }

    }

}
