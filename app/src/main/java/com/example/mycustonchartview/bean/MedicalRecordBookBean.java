package com.example.mycustonchartview.bean;

import java.io.Serializable;

/**
 * Created by zhuliang on 2019/6/6.
 */

public class MedicalRecordBookBean extends CommentJsonBean implements Serializable {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {

        private Object resultCode;
        private Object resultMessage;
        private Object extFields;
        private String patName;
        private String patCardNo;
        private String patSex;
        private int patAge;
        private String recordNo;
        private String recordName;
        private String visitDate;
        private String deptCode;
        private String deptName;
        private String allergicHistory;
        private String chiefComplaint;
        private String presentIllness;
        private String historyIllness;
        private String physicalCheckUps;
        private String auxiliaryExamResult;
        private String advice;
        private String diagnose;
        private String printDate;
        private String docSignature;

        public Object getResultCode() {
            return resultCode;
        }

        public void setResultCode(Object resultCode) {
            this.resultCode = resultCode;
        }

        public Object getResultMessage() {
            return resultMessage;
        }

        public void setResultMessage(Object resultMessage) {
            this.resultMessage = resultMessage;
        }

        public Object getExtFields() {
            return extFields;
        }

        public void setExtFields(Object extFields) {
            this.extFields = extFields;
        }

        public String getPatName() {
            return patName;
        }

        public void setPatName(String patName) {
            this.patName = patName;
        }

        public String getPatCardNo() {
            return patCardNo;
        }

        public void setPatCardNo(String patCardNo) {
            this.patCardNo = patCardNo;
        }

        public String getPatSex() {
            return patSex;
        }

        public void setPatSex(String patSex) {
            this.patSex = patSex;
        }

        public int getPatAge() {
            return patAge;
        }

        public void setPatAge(int patAge) {
            this.patAge = patAge;
        }

        public String getRecordNo() {
            return recordNo;
        }

        public void setRecordNo(String recordNo) {
            this.recordNo = recordNo;
        }

        public String getRecordName() {
            return recordName;
        }

        public void setRecordName(String recordName) {
            this.recordName = recordName;
        }

        public String getVisitDate() {
            return visitDate;
        }

        public void setVisitDate(String visitDate) {
            this.visitDate = visitDate;
        }

        public String getDeptCode() {
            return deptCode;
        }

        public void setDeptCode(String deptCode) {
            this.deptCode = deptCode;
        }

        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

        public String getAllergicHistory() {
            return allergicHistory;
        }

        public void setAllergicHistory(String allergicHistory) {
            this.allergicHistory = allergicHistory;
        }

        public String getChiefComplaint() {
            return chiefComplaint;
        }

        public void setChiefComplaint(String chiefComplaint) {
            this.chiefComplaint = chiefComplaint;
        }

        public String getPresentIllness() {
            return presentIllness;
        }

        public void setPresentIllness(String presentIllness) {
            this.presentIllness = presentIllness;
        }

        public String getHistoryIllness() {
            return historyIllness;
        }

        public void setHistoryIllness(String historyIllness) {
            this.historyIllness = historyIllness;
        }

        public String getPhysicalCheckUps() {
            return physicalCheckUps;
        }

        public void setPhysicalCheckUps(String physicalCheckUps) {
            this.physicalCheckUps = physicalCheckUps;
        }

        public String getAuxiliaryExamResult() {
            return auxiliaryExamResult;
        }

        public void setAuxiliaryExamResult(String auxiliaryExamResult) {
            this.auxiliaryExamResult = auxiliaryExamResult;
        }

        public String getAdvice() {
            return advice;
        }

        public void setAdvice(String advice) {
            this.advice = advice;
        }

        public String getDiagnose() {
            return diagnose;
        }

        public void setDiagnose(String diagnose) {
            this.diagnose = diagnose;
        }

        public String getPrintDate() {
            return printDate;
        }

        public void setPrintDate(String printDate) {
            this.printDate = printDate;
        }

        public String getDocSignature() {
            return docSignature;
        }

        public void setDocSignature(String docSignature) {
            this.docSignature = docSignature;
        }
    }
}
