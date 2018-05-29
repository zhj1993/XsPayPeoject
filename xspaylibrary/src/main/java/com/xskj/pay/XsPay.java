package com.xskj.pay;

import android.app.Activity;

import com.xskj.pay.alipay.Alipay;
import com.xskj.pay.alipay.AlipayPayCallBack;
import com.xskj.pay.weixin.WXPay;
import com.xskj.pay.weixin.WXPayCallBack;

/**
 * 创建日期：2018/4/17 on 9:32
 * 描述:
 * 作者:zhahaijun
 */
public class XsPay {

    private static Activity mActivity;
    private static XsPay mXsPayManager;

    public static XsPay getInstance(Activity activity) {
        if (mXsPayManager == null) {
            synchronized (XsPay.class) {
                mXsPayManager = new XsPay();
            }
        }
        mActivity = activity;
        return mXsPayManager;
    }

    /**
     * 阿里支付
     *
     * @param order
     */
    public void aliPay(String order, AlipayPayCallBack alipayPayCallBack) {
        new Alipay(mActivity, order, alipayPayCallBack).doPay();
    }

    /**
     * weixin
     *
     * @param wxAppid
     * @param order
     * @param wxPayCallBack
     */
    public void wxPay(String wxAppid, String order, WXPayCallBack wxPayCallBack) {
        WXPay.init(mActivity, wxAppid);
        WXPay.getInstance().doPay(order, wxPayCallBack);
    }
}
