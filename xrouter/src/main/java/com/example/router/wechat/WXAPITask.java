package com.example.router.wechat;

import android.app.Activity;

import com.example.router.utils.Consts;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * 微信支付
 *
 * @Author: cherish
 * @CreateDate: 2019/3/4 16:37
 */

public class WXAPITask {
    public WXAPITask(Activity activity) {
        IWXAPI api = WXAPIFactory.createWXAPI(activity, Consts.APP_ID);
        PayReq request = new PayReq();
        request.appId = Consts.APP_ID;
        request.partnerId = "1900006771";
        request.prepayId= "wx041601271720488fbfdf8aa04069937440";
        request.packageValue = "Sign=WXPay";
        request.nonceStr= "ed75d297179518b119ae0cf61efeb4cf";
        request.timeStamp= "1551686487";
        request.sign= "64AB19814A1B77772C446EEC7CCB69F1";
        api.sendReq(request);
    }
}
