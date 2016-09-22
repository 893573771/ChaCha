package com.ghy.chacha.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by GHY on 2016/9/22.
 * Desc:今日油价
 */

public class OilPriceBean {

    private String msg;

    private ResultBean result;
    private String retCode;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public static class ResultBean {
        /**
         * dieselOil0 : 5.68
         * gasoline90 : 5.66(京89号)
         * gasoline93 : 6.05(京92号)
         * gasoline97 : 6.44(京95号)
         * province : beijing
         */

        @SerializedName("北京")
        private BeijingBean beijing;
        /**
         * dieselOil0 : 5.59
         * gasoline90 : 5.67
         * gasoline93 : 6
         * gasoline97 : 6.33
         * province : chongqing
         */
        @SerializedName("重庆")
        private ChongqingBean chongqing;
        /**
         * dieselOil0 : 5.3
         * gasoline90 : 5.78
         * gasoline93 : 5.67
         * gasoline97 : 6.11
         * province : xinjiang
         */

        @SerializedName("新疆")
        private XingjiangBean xinjiang;
        /**
         * dieselOil0 : 5.65
         * gasoline90 : 5.64
         * gasoline93 : 6.07
         * gasoline97 : 6.58
         * province : guangdong
         */

        @SerializedName("广东")
        private GuangdongBean guangdong;
        /**
         * dieselOil0 : 5.63
         * gasoline90 : 5.59
         * gasoline93 : 6.03
         * gasoline97 : 6.41
         * province : zhejiang
         */

        @SerializedName("浙江")
        private ZhejiangBean zhejiang;
        /**
         * dieselOil0 : 5.64
         * gasoline90 : 5.6
         * gasoline93 : 6.04
         * gasoline97 : 6.38
         * province : tianjin
         */

        @SerializedName("天津")
        private TianjinBean tianjin;
        /**
         * dieselOil0 : 5.56
         * gasoline90 : 5.57
         * gasoline93 : 5.97
         * gasoline97 : 6.45
         * province : guangxi
         */

        @SerializedName("广西")
        private GuangxiBean guangxi;
        /**
         * dieselOil0 : 6.89
         * gasoline90 : 6.66
         * gasoline93 : 6.95
         * gasoline97 : 7.45
         * province : neimenggu
         */

        @SerializedName("内蒙古")
        private NeimengguBean neimenggu;
        /**
         * dieselOil0 : 5.41
         * gasoline90 : 5.5
         * gasoline93 : 5.83
         * gasoline97 : 6.16
         * province : ningxia
         */

        @SerializedName("宁夏")
        private NingxiaBean ningxia;
        /**
         * dieselOil0 : 5.55
         * gasoline90 : 5.47
         * gasoline93 : 5.89
         * gasoline97 : 6.32
         * province : jiangxi
         */

        @SerializedName("江西")
        private JiangxiBean jiangxi;
        /**
         * dieselOil0 : 5.53
         * gasoline90 : 5.51
         * gasoline93 : 5.89
         * gasoline97 : 6.33
         * province : anhui
         */

        @SerializedName("安徽")
        private AnhuiBean anhui;
        /**
         * dieselOil0 : 5.45
         * gasoline90 : 5.92
         * gasoline93 : 5.88
         * gasoline97 : 6.21
         * province : guizhou
         */

        @SerializedName("贵州")
        private GuizhouBean guizhou;
        /**
         * dieselOil0 : 5.55
         * gasoline90 : 5.62
         * gasoline93 : 5.95
         * gasoline97 : 6.03
         * province : sanxi 陕西
         */

        @SerializedName("陕西")
        private SanxiBean sanxi;
        /**
         * dieselOil0 : 5.42
         * gasoline90 : 5.97
         * gasoline93 : 6.02
         * gasoline97 : 6.42
         * province : liaoning
         */

        @SerializedName("辽宁")
        private LiaoningBean liaoning;
        /**
         * dieselOil0 : 5.24
         * gasoline90 : 6.35
         * gasoline93 : 5.58
         * gasoline97 : 6.02
         * province : shanxi 山西
         */

        @SerializedName("山西")
        private ShanxiBean shanxi;
        /**
         * dieselOil0 : 5.45
         * gasoline90 : 5.51
         * gasoline93 : 5.87
         * gasoline97 : 6.29
         * province : qinghai
         */

        @SerializedName("青海")
        private QinghaiBean qinghai;
        /**
         * dieselOil0 : 5.61
         * gasoline90 : 5.59
         * gasoline93 : 5.96
         * gasoline97 : 6.43
         * province : sichuan
         */

        @SerializedName("四川")
        private SichuanBean sichuan;
        /**
         * dieselOil0 : 5.61
         * gasoline90 : 5.65
         * gasoline93 : 6.03
         * gasoline97 : 6.41
         * province : jiangsu
         */

        @SerializedName("江苏")
        private JiangsuBean jiangsu;
        /**
         * dieselOil0 : 5.64
         * gasoline90 : 5.6
         * gasoline93 : 6.04
         * gasoline97 : 6.38
         * province : hebei
         */

        @SerializedName("河北")
        private HebeiBean hebei;
        /**
         * dieselOil0 : 6.02
         * gasoline90 : 6.37
         * gasoline93 : 6.76
         * gasoline97 : 7.13
         * province : xizang
         */

        @SerializedName("西藏")
        private XizangBean xizang;
        /**
         * dieselOil0 : 5.64
         * gasoline90 : 5.61
         * gasoline93 : 6.03
         * gasoline97 : 6.44
         * province : fujian
         */

        @SerializedName("福建")
        private FujianBean fujian;
        /**
         * dieselOil0 : 5.38
         * gasoline90 : 5.4
         * gasoline93 : 5.77
         * gasoline97 : 6.26
         * province : jilin
         */

        @SerializedName("吉林")
        private JilinBean jilin;
        /**
         * dieselOil0 : 5.73
         * gasoline90 : 6.63
         * gasoline93 : 7.17
         * gasoline97 : 7.6
         * province : hainan
         */

        @SerializedName("海南")
        private HainanBean hainan;
        /**
         * dieselOil0 : 5.59
         * gasoline90 : 5.58
         * gasoline93 : 6.06
         * gasoline97 : 6.5
         * province : yunnan
         */

        @SerializedName("云南")
        private YunnanBean yunnan;
        /**
         * dieselOil0 : 5.55
         * gasoline90 : 5.55
         * gasoline93 : 5.9
         * gasoline97 : 6.35
         * province : hubei
         */

        @SerializedName("湖北")
        private HubeiBean hubei;
        /**
         * dieselOil0 : 5.62
         * gasoline90 : 5.61(沪89号)
         * gasoline93 : 6.02(沪92号)
         * gasoline97 : 6.4(沪95号)
         * province : shanghai
         */

        @SerializedName("上海")
        private ShanghaiBean shanghai;
        /**
         * dieselOil0 : 5.42
         * gasoline90 : 5.45
         * gasoline93 : 5.82
         * gasoline97 : 6.22
         * province : gansu
         */

        @SerializedName("甘肃")
        private GansuBean gansu;
        /**
         * dieselOil0 : 5.57
         * gasoline90 : 5.51
         * gasoline93 : 5.88
         * gasoline97 : 6.25
         * province : hunan
         */

        @SerializedName("湖南")
        private HunanBean hunan;
        /**
         * dieselOil0 : 5.53
         * gasoline90 : 5.38
         * gasoline93 : 5.86
         * gasoline97 : 6.2
         * province : henan
         */

        @SerializedName("河南")
        private HenanBean henan;
        /**
         * dieselOil0 : 5.63
         * gasoline90 : 5.6
         * gasoline93 : 6.03
         * gasoline97 : 6.47
         * province : shandong
         */

        @SerializedName("山东")
        private ShandongBean shandong;
        /**
         * dieselOil0 : 4.89
         * gasoline90 : 5.87
         * gasoline93 : 5.41
         * gasoline97 : 5.82
         * province : heilongjiang
         */

        @SerializedName("黑龙江")
        private HeilongjiangBean heilongjiang;

        public BeijingBean getBeijing() {
            return beijing;
        }

        public void setBeijing(BeijingBean beijing) {
            this.beijing = beijing;
        }

        public ChongqingBean getChongqing() {
            return chongqing;
        }

        public void setChongqing(ChongqingBean chongqing) {
            this.chongqing = chongqing;
        }

        public XingjiangBean getXinjiang() {
            return xinjiang;
        }

        public void setXinjiang(XingjiangBean xinjiang) {
            this.xinjiang = xinjiang;
        }

        public GuangdongBean getGuangdong() {
            return guangdong;
        }

        public void setGuangdong(GuangdongBean guangdong) {
            this.guangdong = guangdong;
        }

        public ZhejiangBean getZhejiang() {
            return zhejiang;
        }

        public void setZhejiang(ZhejiangBean zhejiang) {
            this.zhejiang = zhejiang;
        }

        public TianjinBean getTianjin() {
            return tianjin;
        }

        public void setTianjin(TianjinBean tianjin) {
            this.tianjin = tianjin;
        }

        public GuangxiBean getGuangxi() {
            return guangxi;
        }

        public void setGuangxi(GuangxiBean guangxi) {
            this.guangxi = guangxi;
        }

        public NeimengguBean getNeimenggu() {
            return neimenggu;
        }

        public void setNeimenggu(NeimengguBean neimenggu) {
            this.neimenggu = neimenggu;
        }

        public NingxiaBean getNingxia() {
            return ningxia;
        }

        public void setNingxia(NingxiaBean ningxia) {
            this.ningxia = ningxia;
        }

        public JiangxiBean getJiangxi() {
            return jiangxi;
        }

        public void setJiangxi(JiangxiBean jiangxi) {
            this.jiangxi = jiangxi;
        }

        public AnhuiBean getAnhui() {
            return anhui;
        }

        public void setAnhui(AnhuiBean anhui) {
            this.anhui = anhui;
        }

        public GuizhouBean getGuizhou() {
            return guizhou;
        }

        public void setGuizhou(GuizhouBean guizhou) {
            this.guizhou = guizhou;
        }

        public SanxiBean getSanxi() {
            return sanxi;
        }

        public void setSanxi(SanxiBean sanxi) {
            this.sanxi = sanxi;
        }

        public LiaoningBean getLiaoning() {
            return liaoning;
        }

        public void setLiaoning(LiaoningBean liaoning) {
            this.liaoning = liaoning;
        }

        public ShanxiBean getShanxi() {
            return shanxi;
        }

        public void setShanxi(ShanxiBean shanxi) {
            this.shanxi = shanxi;
        }

        public QinghaiBean getQinghai() {
            return qinghai;
        }

        public void setQinghai(QinghaiBean qinghai) {
            this.qinghai = qinghai;
        }

        public SichuanBean getSichuan() {
            return sichuan;
        }

        public void setSichuan(SichuanBean sichuan) {
            this.sichuan = sichuan;
        }

        public JiangsuBean getJiangsu() {
            return jiangsu;
        }

        public void setJiangsu(JiangsuBean jiangsu) {
            this.jiangsu = jiangsu;
        }

        public HebeiBean getHebei() {
            return hebei;
        }

        public void setHebei(HebeiBean hebei) {
            this.hebei = hebei;
        }

        public XizangBean getXizang() {
            return xizang;
        }

        public void setXizang(XizangBean xizang) {
            this.xizang = xizang;
        }

        public FujianBean getFujian() {
            return fujian;
        }

        public void setFujian(FujianBean fujian) {
            this.fujian = fujian;
        }

        public JilinBean getJilin() {
            return jilin;
        }

        public void setJilin(JilinBean jilin) {
            this.jilin = jilin;
        }

        public HainanBean getHainan() {
            return hainan;
        }

        public void setHainan(HainanBean hainan) {
            this.hainan = hainan;
        }

        public YunnanBean getYunnan() {
            return yunnan;
        }

        public void setYunnan(YunnanBean yunnan) {
            this.yunnan = yunnan;
        }

        public HubeiBean getHubei() {
            return hubei;
        }

        public void setHubei(HubeiBean hubei) {
            this.hubei = hubei;
        }

        public ShanghaiBean getShanghai() {
            return shanghai;
        }

        public void setShanghai(ShanghaiBean shanghai) {
            this.shanghai = shanghai;
        }

        public GansuBean getGansu() {
            return gansu;
        }

        public void setGansu(GansuBean gansu) {
            this.gansu = gansu;
        }

        public HunanBean getHunan() {
            return hunan;
        }

        public void setHunan(HunanBean hunan) {
            this.hunan = hunan;
        }

        public HenanBean getHenan() {
            return henan;
        }

        public void setHenan(HenanBean henan) {
            this.henan = henan;
        }

        public ShandongBean getShandong() {
            return shandong;
        }

        public void setShandong(ShandongBean shandong) {
            this.shandong = shandong;
        }

        public HeilongjiangBean getHeilongjiang() {
            return heilongjiang;
        }

        public void setHeilongjiang(HeilongjiangBean heilongjiang) {
            this.heilongjiang = heilongjiang;
        }

        public static class BeijingBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class ChongqingBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class XingjiangBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class GuangdongBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class ZhejiangBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class TianjinBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class GuangxiBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class NeimengguBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class NingxiaBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class JiangxiBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class AnhuiBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class GuizhouBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class SanxiBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class LiaoningBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class ShanxiBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class QinghaiBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class SichuanBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class JiangsuBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class HebeiBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class XizangBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class FujianBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class JilinBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class HainanBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class YunnanBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class HubeiBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class ShanghaiBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class GansuBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class HunanBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class HenanBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class ShandongBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class HeilongjiangBean {
            private String dieselOil0;
            private String gasoline90;
            private String gasoline93;
            private String gasoline97;
            private String province;

            public String getDieselOil0() {
                return dieselOil0;
            }

            public void setDieselOil0(String dieselOil0) {
                this.dieselOil0 = dieselOil0;
            }

            public String getGasoline90() {
                return gasoline90;
            }

            public void setGasoline90(String gasoline90) {
                this.gasoline90 = gasoline90;
            }

            public String getGasoline93() {
                return gasoline93;
            }

            public void setGasoline93(String gasoline93) {
                this.gasoline93 = gasoline93;
            }

            public String getGasoline97() {
                return gasoline97;
            }

            public void setGasoline97(String gasoline97) {
                this.gasoline97 = gasoline97;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }
    }
}
