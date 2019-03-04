package com.hot.cherish.live.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.common.base.BaseActivity;
import com.example.common.service.ILoginService;
import com.example.common.service.ServiceFactory;
import com.hot.cherish.live.R;

public class LiveActivity extends BaseActivity {


    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_live);
    }

    @Override
    protected void mainRequest() {
        ServiceFactory.getInstance().invoke(ILoginService.class).launcher(LiveActivity.this,null);
    }
}
