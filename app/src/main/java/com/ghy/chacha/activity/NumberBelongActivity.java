package com.ghy.chacha.activity;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ghy.baseapp.api.RetrofitHelper;
import com.ghy.baseapp.base.AbsBaseActivity;
import com.ghy.baseapp.common.log.Log;
import com.ghy.baseapp.utils.AnimUtils;
import com.ghy.baseapp.utils.ImeUtils;
import com.ghy.baseapp.utils.SnackbarUtils;
import com.ghy.chacha.R;
import com.ghy.chacha.api.APIS;
import com.ghy.chacha.api.ApiService;
import com.ghy.chacha.bean.NumberBelongBean;
import com.ghy.chacha.helper.TitleHelper;

import butterknife.Bind;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 号码归属
 */
public class NumberBelongActivity extends AbsBaseActivity {

    @Bind(R.id.iv_clear_phone_number)
    ImageView ivClearNumber;
    @Bind(R.id.et_mobile_number)
    EditText etPhoneNumber;
    @Bind(R.id.btn_chaxun)
    Button btnChaXun;
    @Bind(R.id.tv_number_count)
    TextView tvNumberCount;
    @Bind(R.id.tv_number_rec)
    TextView tvNumberRec;

    @Bind(R.id.layout_phone_number_info)
    LinearLayout layoutPhoneInfo;

    @Bind(R.id.tv_phone_province)
    TextView tvPhoneProvince;
    @Bind(R.id.tv_phone_city)
    TextView tvPhoneCity;
    @Bind(R.id.tv_phone_city_code)
    TextView tvPhoneCityCode;
    @Bind(R.id.tv_phone_operator)
    TextView tvPhoneOperator;
    @Bind(R.id.tv_phone_zip_code)
    TextView tvPhoneZipCode;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_number_belong;
    }

    @Override
    protected String getToolBarTitle() {
        return TitleHelper.TITLE_NUMBER_BELONG;
    }

    @Override
    protected void init() {

        //添加输入监听
        etPhoneNumber.addTextChangedListener(new MyTextWatcher());

    }

    /**
     * 一键清除输入号码
     */
    @OnClick(R.id.iv_clear_phone_number)
    public void clearEditText() {
        etPhoneNumber.setText("");
    }

    /**
     * 查询按钮
     */
    @OnClick(R.id.btn_chaxun)
    public void clickChaXun() {

        //隐藏软键盘
        ImeUtils.hideSoftKeyboard(etPhoneNumber);

        int length = etPhoneNumber.getText().length();
        if (length == 0) {
            SnackbarUtils.showSnackbarDefault(btnChaXun, "手机号码不能为空！").show();
        } else if (length < 7 || length > 11) {
            SnackbarUtils.showSnackbarDefault(btnChaXun, "手机号码有误，请重新输入！").show();
        } else {
            //请求数据
            requestPhoneApi(etPhoneNumber.getText().toString());
        }

    }

    /**
     * Created by GHY on 2016/9/22.
     * MethodDesc:请求手机归属信息api
     **/
    private void requestPhoneApi(String phoneNumber) {

        ApiService.NumberBelongService api = RetrofitHelper.getRetrofit().create(ApiService.NumberBelongService.class);
        Observable<NumberBelongBean> observable = api.getPhoneInfo(APIS.APPKEY, phoneNumber);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NumberBelongBean>() {

                    @Override
                    public void onCompleted() {
                        Log.i("RxJava----", "requestPhoneApi--onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("RxJava----", "onError" + e.toString());
                        layoutPhoneInfo.setVisibility(View.GONE);
                        SnackbarUtils.showSnackbarDefault(btnChaXun, "查询出错，请重试！").show();
                    }

                    @Override
                    public void onNext(NumberBelongBean numberBean) {

                        if (numberBean.getRetCode().equals("200")) {

                            layoutPhoneInfo.setVisibility(View.VISIBLE);

                            //成功
                            tvPhoneCity.setText("所属城市：" + numberBean.getResult().getCity());
                            tvPhoneProvince.setText("所属省份：" + numberBean.getResult().getProvince());
                            tvPhoneCityCode.setText("城市区号：" + numberBean.getResult().getCityCode());
                            tvPhoneOperator.setText("卡运营商：" + numberBean.getResult().getOperator());
                            tvPhoneZipCode.setText("邮政编码：" + numberBean.getResult().getZipCode());

                            AnimUtils.phoneInfoEnterAnim(layoutPhoneInfo, 500);


                        } else if (numberBean.getRetCode().equals("20101")) {
                            //查询不到数据
                            SnackbarUtils.showSnackbarDefault(btnChaXun, "抱歉，未查询到数据！").show();

                        } else if (numberBean.getRetCode().equals("20102")) {
                            //手机号码格式错误
                            SnackbarUtils.showSnackbarDefault(btnChaXun, "手机号码有误，请重新输入！").show();
                        }


                    }
                });
    }


    /**
     * Created by GHY on 2016/9/22.
     * MethodDesc:输入监听
     **/
    private class MyTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            int length = etPhoneNumber.getText().length();
            if (length != 0) {
                ivClearNumber.setVisibility(View.VISIBLE);
                tvNumberRec.setVisibility(View.VISIBLE);
            } else {
                ivClearNumber.setVisibility(View.GONE);
                tvNumberRec.setVisibility(View.INVISIBLE);
            }

            tvNumberCount.setText(length + "/11");
            if (length > 11) {
                tvNumberCount.setTextColor(Color.parseColor("#FF4500"));
            } else {
                tvNumberCount.setTextColor(Color.parseColor("#FC8825"));
            }

            if (length >= 1 && length <= 11) {
                tvNumberRec.setText("请至少输入手机号的前 7 位");
                tvNumberRec.setTextColor(Color.parseColor("#FC8825"));
                if (length >= 2) {
                    //判断是否是一个手机号
                    if (!(etPhoneNumber.getText().toString().startsWith("13") ||
                            etPhoneNumber.getText().toString().startsWith("15") ||
                            etPhoneNumber.getText().toString().startsWith("18") ||
                            etPhoneNumber.getText().toString().startsWith("17"))) {
                        tvNumberRec.setText("这可能并不是一个手机号码！");
                        tvNumberRec.setTextColor(Color.parseColor("#FF4500"));
                    } else {
                        tvNumberRec.setText("请至少输入手机号的前 7 位");
                        tvNumberRec.setTextColor(Color.parseColor("#FC8825"));
                    }
                }
            } else if (length > 11) {
                tvNumberRec.setText("您输入的手机号码位数过长！");
                tvNumberRec.setTextColor(Color.parseColor("#FF4500"));
            }

        }
    }

}
