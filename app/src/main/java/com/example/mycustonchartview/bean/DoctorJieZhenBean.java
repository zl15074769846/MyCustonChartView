package com.example.mycustonchartview.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhuliang on 2019/7/9.
 */

public class DoctorJieZhenBean extends CommentJsonBean implements Serializable {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {

        private double max;
        private int count;
        private List<DateListBean> dateList;

        public double getMax() {
            return max;
        }

        public void setMax(double max) {
            this.max = max;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<DateListBean> getDateList() {
            return dateList;
        }

        public void setDateList(List<DateListBean> dateList) {
            this.dateList = dateList;
        }

        public static class DateListBean implements Serializable {
            private String content;
            private int patientAge;
            private String createDate;
            private String orderIdStr;
            private int queueNo;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getPatientAge() {
                return patientAge;
            }

            public void setPatientAge(int patientAge) {
                this.patientAge = patientAge;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public String getOrderIdStr() {
                return orderIdStr;
            }

            public void setOrderIdStr(String orderIdStr) {
                this.orderIdStr = orderIdStr;
            }

            public int getQueueNo() {
                return queueNo;
            }

            public void setQueueNo(int queueNo) {
                this.queueNo = queueNo;
            }
        }
    }
}
