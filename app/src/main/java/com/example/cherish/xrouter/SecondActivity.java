package com.example.cherish.xrouter;

import android.support.v7.widget.AppCompatImageView;

import com.example.common.base.BaseActivity;
import com.xrouter.annotation.annotation.BindView;

public class SecondActivity extends BaseActivity {

   @BindView(R.id.iv_img)
    AppCompatImageView iv_img;
    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_second);
    }

    @Override
    protected void mainRequest() {


    }


}
