package com.ghy.chacha.bean;

import java.util.List;

/**
 * Created by GHY on 2016/9/22.
 * Desc:微信精选-列表
 */

public class WeChatListBean {


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
        private int curPage;
        private int total;
        /**
         * cid : 1
         * id : 4043834
         * pubTime : 2016-09-27 11:31
         * sourceUrl : http://www.yinews.cn/article/4043834.shtm
         * subTitle : 《麻雀》张若昀成手控舔屏对象！这些美手猜猜属于谁？
         * title : 《麻雀》张若昀成手控舔屏对象！这些美手猜猜属于谁？
         */

        private List<ListBean> list;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private String cid;
            private String id;
            private String pubTime;
            private String sourceUrl;
            private String subTitle;
            private String title;

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPubTime() {
                return pubTime;
            }

            public void setPubTime(String pubTime) {
                this.pubTime = pubTime;
            }

            public String getSourceUrl() {
                return sourceUrl;
            }

            public void setSourceUrl(String sourceUrl) {
                this.sourceUrl = sourceUrl;
            }

            public String getSubTitle() {
                return subTitle;
            }

            public void setSubTitle(String subTitle) {
                this.subTitle = subTitle;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
