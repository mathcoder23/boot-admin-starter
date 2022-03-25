package org.pettyfox.base.comm.web;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RestFul对象响应
 *
 * @param <T>
 * @author Petty Fox
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("通用响应体")
public class RestObjectResponse<T> {

    @ApiModelProperty("公共响应码")
    private int code;

    private int bcode;

    @ApiModelProperty("数据体")
    private T data;


    @ApiModelProperty("正常消息")
    private String msg;

    @ApiModelProperty("错误消息")
    private String errmsg;

    public static <T> RestObjectResponse<T> ok(T data) {
        RestObjectResponse<T> ok = new RestObjectResponse<>();
        ok.setData(data);
        ok.setCode(RestObjectResponseCode.API_OK);
        return ok;
    }

    public static <T> RestObjectResponse<T> err(Integer code, Integer bcode, String message) {
        RestObjectResponse<T> err = new RestObjectResponse<>();
        err.setCode(code);
        err.setBcode(bcode);
        err.setErrmsg(message);
        return err;
    }

    public static <T> RestObjectResponse<T> err(Integer code, String message) {
        RestObjectResponse<T> err = new RestObjectResponse<>();
        err.setCode(code);
        err.setErrmsg(message);
        return err;
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }
}
