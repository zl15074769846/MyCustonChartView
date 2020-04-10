package com.example.mycustonchartview.bean;


import java.io.Serializable;
import java.util.List;

/**
 * Created by zhuliang on 2019/8/1.
 */

public class MonthReportJiaoyiBean extends CommentJsonBean implements Serializable {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {

        private Object totalFollow;
        private String tagDays;   //近多少天
        private Object totalBinding;
        private Object yesterdaySum;
        private Object platformId;
        private Object hisId;
        private int platformSource;
        private String bizType;
        private String bizTypeName;
        private Object payChannel;
        private String payChannelName;
        private String platformSourceName;
        private Object payMethod;
        private int totalSum;
        private int totalAmt;
        private int successSum;
        private int successAmt;
        private String sucSumRate;
        private String sucAmtRate;
        private Object failedSum;
        private Object failedAmt;
        private Object errorSum;
        private Object errorAmt;
        private int refundSum;
        private int refundAmt;
        private String dt;

        public String getDt() {
            return dt;
        }

        public void setDt(String dt) {
            this.dt = dt;
        }

        public String getPlatformSourceName() {
            return platformSourceName;
        }

        public void setPlatformSourceName(String platformSourceName) {
            this.platformSourceName = platformSourceName;
        }

        public String getTagDays() {
            return tagDays;
        }

        public void setTagDays(String tagDays) {
            this.tagDays = tagDays;
        }

        public Object getTotalFollow() {
            return totalFollow;
        }

        public void setTotalFollow(Object totalFollow) {
            this.totalFollow = totalFollow;
        }

        public Object getTotalBinding() {
            return totalBinding;
        }

        public void setTotalBinding(Object totalBinding) {
            this.totalBinding = totalBinding;
        }

        public Object getYesterdaySum() {
            return yesterdaySum;
        }

        public void setYesterdaySum(Object yesterdaySum) {
            this.yesterdaySum = yesterdaySum;
        }

        public Object getPlatformId() {
            return platformId;
        }

        public void setPlatformId(Object platformId) {
            this.platformId = platformId;
        }

        public Object getHisId() {
            return hisId;
        }

        public void setHisId(Object hisId) {
            this.hisId = hisId;
        }

        public int getPlatformSource() {
            return platformSource;
        }

        public void setPlatformSource(int platformSource) {
            this.platformSource = platformSource;
        }

        public String getBizType() {
            return bizType;
        }

        public void setBizType(String bizType) {
            this.bizType = bizType;
        }

        public String getBizTypeName() {
            return bizTypeName;
        }

        public void setBizTypeName(String bizTypeName) {
            this.bizTypeName = bizTypeName;
        }

        public Object getPayChannel() {
            return payChannel;
        }

        public void setPayChannel(Object payChannel) {
            this.payChannel = payChannel;
        }

        public String getPayChannelName() {
            return payChannelName;
        }

        public void setPayChannelName(String payChannelName) {
            this.payChannelName = payChannelName;
        }

        public Object getPayMethod() {
            return payMethod;
        }

        public void setPayMethod(Object payMethod) {
            this.payMethod = payMethod;
        }

        public int getTotalSum() {
            return totalSum;
        }

        public void setTotalSum(int totalSum) {
            this.totalSum = totalSum;
        }

        public int getTotalAmt() {
            return totalAmt;
        }

        public void setTotalAmt(int totalAmt) {
            this.totalAmt = totalAmt;
        }

        public int getSuccessSum() {
            return successSum;
        }

        public void setSuccessSum(int successSum) {
            this.successSum = successSum;
        }

        public int getSuccessAmt() {
            return successAmt;
        }

        public void setSuccessAmt(int successAmt) {
            this.successAmt = successAmt;
        }

        public String getSucSumRate() {
            return sucSumRate;
        }

        public void setSucSumRate(String sucSumRate) {
            this.sucSumRate = sucSumRate;
        }

        public String getSucAmtRate() {
            return sucAmtRate;
        }

        public void setSucAmtRate(String sucAmtRate) {
            this.sucAmtRate = sucAmtRate;
        }

        public Object getFailedSum() {
            return failedSum;
        }

        public void setFailedSum(Object failedSum) {
            this.failedSum = failedSum;
        }

        public Object getFailedAmt() {
            return failedAmt;
        }

        public void setFailedAmt(Object failedAmt) {
            this.failedAmt = failedAmt;
        }

        public Object getErrorSum() {
            return errorSum;
        }

        public void setErrorSum(Object errorSum) {
            this.errorSum = errorSum;
        }

        public Object getErrorAmt() {
            return errorAmt;
        }

        public void setErrorAmt(Object errorAmt) {
            this.errorAmt = errorAmt;
        }

        public int getRefundSum() {
            return refundSum;
        }

        public void setRefundSum(int refundSum) {
            this.refundSum = refundSum;
        }

        public int getRefundAmt() {
            return refundAmt;
        }

        public void setRefundAmt(int refundAmt) {
            this.refundAmt = refundAmt;
        }
    }
}
