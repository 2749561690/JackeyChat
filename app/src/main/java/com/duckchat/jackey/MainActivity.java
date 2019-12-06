package com.duckchat.jackey;

import android.os.Bundle;
import android.text.TextUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.duckchat.basecomponent.core.BaseSP;
import com.duckchat.basecomponent.util.AndroidUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ARouter.getInstance().inject(this);
        String deviesId = BaseSP.getInstance().getString("deviesId");
        if (TextUtils.isEmpty(deviesId)) {
            deviesId = AndroidUtil.getDeviesId(this);
        }
        ARouter.getInstance().build("/login/login").withString("identity", deviesId).navigation();
    }
}
