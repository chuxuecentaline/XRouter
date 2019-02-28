package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.BinderThread;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.example.common.base.BaseActivity;
import com.xrouter.annotation.BindView;


public class LoginActivity extends BaseActivity {

    private String phone="";
    private String pws="";
    private AppCompatEditText edit_phone,edit_psw;
    private AppCompatTextView atv_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void mainRequest() {
        phone= (String) getIntent().getSerializableExtra("phone");
        pws= (String) getIntent().getSerializableExtra("psw");
        edit_phone= findViewById(R.id.edit_phone);
        edit_psw= findViewById(R.id.edit_psw);
         atv_login = findViewById(R.id.atv_login);
        edit_phone.setText(phone);
        edit_psw.setText(pws);
        atv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("login","登陆成功了");
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }


}
