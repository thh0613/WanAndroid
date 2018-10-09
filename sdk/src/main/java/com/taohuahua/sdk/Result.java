package com.taohuahua.sdk;

public class Result<T> {

    private int status;
    private T data;
    private String message;
    private int count;
    private Object ext;



    public Result (int status, T data, String message, int count, Object ext) {
        this.status = status;
        this.data = data;
        this.message = message;
        this.count = count;
        this.ext = ext;
    }


    public  Result<T> success(T data, String message, int count) {
        return new Result<>(Status.SUCCESS, data, message, count, null);
    }

    public  Result<T> error(String msg, T data, int result) {
        return new Result<>(Status.ERROR, data, msg, 0, result);
    }

    public   Result<T> loading(T data) {
        return new Result<>(Status.LOADING, data, null, 0, null);
    }

    @Override
    public int hashCode() {
        int result = this.status;
        result = 31 * result + message.hashCode();
        result = 31 * result + data.hashCode();
        result = 31 * result + count;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else {
            if (this.getClass() == obj.getClass()) {
                Result<T> tmp = (Result<T>) obj;
                if (this.status == tmp.status && this.data == tmp.data && this.message.equals(tmp
                        .message)
                        && this.count == tmp.count && this.ext == tmp.ext) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
