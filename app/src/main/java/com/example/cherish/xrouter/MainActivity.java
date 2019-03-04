package com.example.cherish.xrouter;

import android.content.Intent;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.example.cherish.xrouter.util.alipay.AliPayThread;
import com.example.common.base.BaseActivity;
import com.example.common.service.IActivityForResultCallBack;
import com.example.common.service.ILoginService;
import com.example.common.service.ServiceFactory;
import com.example.router.XRouter;
import com.example.router.wechat.WXAPITask;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    //   @BindView(R.id.tv_login)
    AppCompatTextView tv_login;
    //  @BindView(R.id.tv_app)
    AppCompatTextView tv_app;
    //  @BindView(R.id.tv_2)
    AppCompatTextView tv_2;
    private Map<String, Object> mParams;
    private AppCompatTextView weChatPay;
    private AppCompatTextView aliPay;
    private String resoultString="app_id=2015052600090779&biz_content=%7B%22timeout_express%22%3A%2230m%22%2C%22seller_id%22%3A%22%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22total_amount%22%3A%220.02%22%2C%22subject%22%3A%221%22%2C%22body%22%3A%22%E6%88%91%E6%98%AF%E6%B5%8B%E8%AF%95%E6%95%B0%E6%8D%AE%22%2C%22out_trade_no%22%3A%22314VYGIAGG7ZOYY%22%7D&charset=utf-8&method=alipay.trade.app.pay&sign_type=RSA2&timestamp=2016-08-15%2012%3A12%3A15&version=1.0&sign=MsbylYkCzlfYLy9PeRwUUIg9nZPeN9SfXPNavUCroGKR5Kqvx0nEnd3eRmKxJuthNUx4ERCXe552EV9PfwexqW%2B1wbKOdYtDIb4%2B7PL3Pc94RZL0zKaWcaY3tSL89%2FuAVUsQuFqEJdhIukuKygrXucvejOUgTCfoUdwTi7z%2BZzQ%3D";


    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void mainRequest() {
        tv_login = findViewById(R.id.tv_login);
        tv_app = findViewById(R.id.tv_app);
        tv_2 = findViewById(R.id.tv_2);
        weChatPay = findViewById(R.id.weChatPay);
        aliPay = findViewById(R.id.aliPay);
        mParams = new HashMap<>();
        mParams.put("phone", "1221080532");
        mParams.put("psw", "111111");
        tv_login.setText("工作");
        tv_login.setOnClickListener(this);
        tv_2.setOnClickListener(this);
        tv_app.setOnClickListener(this);
        aliPay.setOnClickListener(this);
        weChatPay.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_login:

                ServiceFactory.getInstance().invoke(ILoginService.class).launcher(MainActivity
                        .this, mParams);
                break;
            case R.id.tv_2:
                XRouter.getInstance().action("login/action").param("key", "value").invokeAction();
                //   ServiceFactory.getInstance().invoke(IIiveService.class).launcher
                // (MainActivity.this,null);
                break;
            case R.id.tv_app:
                ServiceFactory.getInstance().invoke(ILoginService.class)
                        .launcherActivityForResult(MainActivity.this, mParams, 100, new
                                IActivityForResultCallBack() {
                    @Override
                    public void invoke(Intent intent, int requestCode) {
                        startActivityForResult(intent, requestCode);
                    }
                });
                break;
            case R.id.aliPay:
                new AliPayThread(MainActivity.this,resoultString).start();
                break;
            case R.id.weChatPay:
               new WXAPITask(MainActivity.this);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 100:
                    String login = data.getStringExtra("login");
                    tv_app.setText(login);
                    break;
            }
        }
    }
}
