package com.example.mycustonchartview.bean;

import java.io.Serializable;

/**
 * Created by zhuliang on 2019/3/29.
 */

public class CommentJsonBean implements Serializable {

    /**
     * code : 0
     * msg : null
     * data : {"login_access_token":"1553843873318-CC44D5BA8795A8DB351841"}
     */

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
