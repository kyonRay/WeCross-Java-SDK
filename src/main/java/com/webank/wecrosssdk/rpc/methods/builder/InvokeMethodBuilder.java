package com.webank.wecrosssdk.rpc.methods.builder;

import com.webank.wecrosssdk.exception.ErrorCode;
import com.webank.wecrosssdk.exception.WeCrossSDKException;
import com.webank.wecrosssdk.rpc.WeCrossRPC;
import com.webank.wecrosssdk.rpc.methods.response.TransactionResponse;
import com.webank.wecrosssdk.rpc.service.AuthenticationManager;
import java.util.Arrays;

public class InvokeMethodBuilder {
    private String path;
    private String method;
    private String[] args;

    public InvokeMethodBuilder() {}

    public InvokeMethodBuilder(String path, String method, String[] args) {
        this.path = path;
        this.method = method;
        this.args = args;
    }

    public InvokeMethodBuilder build() {
        return new InvokeMethodBuilder();
    }

    public InvokeMethodBuilder path(String path) {
        this.path = path;
        return this;
    }

    public InvokeMethodBuilder method(String method) {
        this.method = method;
        return this;
    }

    public InvokeMethodBuilder args(String[] args) {
        this.args = args;
        return this;
    }

    public TransactionResponse send(WeCrossRPC weCrossRPC) throws Exception {
        if (weCrossRPC == null) {
            throw new WeCrossSDKException(
                    ErrorCode.REMOTECALL_ERROR,
                    "InvokeMethodBuilder: RPC in send(WeCrossRPC) is null");
        }
        if (AuthenticationManager.getCurrentUser() == null
                || this.path == null
                || this.method == null
                || this.args == null) {
            throw new WeCrossSDKException(
                    ErrorCode.FIELD_MISSING, "Some field(s) in InvokeMethodBuilder is null!");
        }
        return weCrossRPC.invoke(this.path, this.method, this.args).send();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    @Override
    public String toString() {
        return "InvokeMethodBuilder{"
                + "path='"
                + path
                + '\''
                + ", method='"
                + method
                + '\''
                + ", args="
                + Arrays.toString(args)
                + '}';
    }
}
