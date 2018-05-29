package com.xskj.pay.alipay;

/**
 * 创建日期：2018/4/17 on 10:52
 * 描述:
 * 作者:zhahaijun
 */
public interface AlipayPayCallBack {

    void onSuccess(); //支付成功

    void onDealing();    //正在处理中 小概率事件 此时以验证服务端异步通知结果为准

    void onError(int error_code);   //支付失败

    void onCancel();    //支付取消
}
