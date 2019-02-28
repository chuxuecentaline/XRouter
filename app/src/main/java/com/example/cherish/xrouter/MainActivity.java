package com.example.cherish.xrouter;

import android.content.Intent;
import android.support.annotation.CallSuper;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Toast;

import com.example.common.base.BaseActivity;
import com.example.common.service.IActivityForResultCallBack;
import com.example.common.service.IIiveService;
import com.example.common.service.ILoginService;
import com.example.common.service.ServiceFactory;
import com.xrouter.annotation.BindView;

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


    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void mainRequest() {
        tv_login=findViewById(R.id.tv_login);
        tv_app=findViewById(R.id.tv_app);
        tv_2=findViewById(R.id.tv_2);
        mParams = new HashMap<>();
        mParams.put("phone","15221080532");
        mParams.put("psw","111111");
        tv_login.setText("工作");
        tv_login.setOnClickListener(this);
        tv_2.setOnClickListener(this);
        tv_app.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_login:

                ServiceFactory.getInstance().invoke(ILoginService.class).launcher(MainActivity.this,mParams);
                break;
            case R.id.tv_2:
                ServiceFactory.getInstance().invoke(IIiveService.class).launcher(MainActivity.this,null);
                break;
            case R.id.tv_app:
                ServiceFactory.getInstance().invoke(ILoginService.class).launcherActivityForResult(MainActivity.this,mParams,100, new IActivityForResultCallBack(){
                    @Override
                    public void invoke(Intent intent, int requestCode) {
                       startActivityForResult(intent,requestCode);
                    }
                });
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            switch (requestCode){
                case 100:
                    String login = data.getStringExtra("login");
                    tv_app.setText(login);
                    break;
            }
        }
    }
}
