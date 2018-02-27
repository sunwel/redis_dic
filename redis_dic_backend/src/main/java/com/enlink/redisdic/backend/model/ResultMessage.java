package com.enlink.redisdic.backend.model;

public class ResultMessage {

    private int errCode;
    private String errMsg;
    private Object result;

    public ResultMessage(){};
    public ResultMessage(int errCode,String errMsg,Object result){
        this.errCode=errCode;
        this.errMsg=errMsg;
        this.result=result;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
