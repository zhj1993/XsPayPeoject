package com.xskj.pay.weixin;

/**
 * 创建日期：2018/4/17 on 10:55
 * 描述:
 * 作者:zhahaijun
 */
public interface WXPayCallBack {
    void onSuccess(); //支付成功

    void onError(int error_code);   //支付失败

    void onCancel();    //支付取消
}
