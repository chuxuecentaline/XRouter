package com.hot.cherish.live.impl;

import android.content.Context;
import android.content.Intent;

import com.example.common.service.IIiveService;
import com.hot.cherish.live.ui.LiveActivity;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author: cherish
 * @CreateDate: 2019/2/28 13:22
 */

public class liveServiceImpl implements IIiveService {
    @Override
    public void launcher(Context context, Map<String, Object> params) {
        Intent intent = new Intent(context, LiveActivity.class);
        if(params!=null){
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                intent.putExtra(entry.getKey(), (Serializable) entry.getValue());
            }
        }
        context.startActivity(intent);
    }
}
