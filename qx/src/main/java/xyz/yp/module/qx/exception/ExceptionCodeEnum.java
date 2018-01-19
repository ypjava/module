package xyz.yp.module.qx.exception;

public enum ExceptionCodeEnum {
    UNKNOWN_ACCOUNT("401", "用户不存在");

    private String code;
    private String message;

    private ExceptionCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
