package com.duckchat.basecomponent.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import com.activeandroid.Model;
import com.activeandroid.query.Delete;
import com.alibaba.android.arouter.launcher.ARouter;
import com.duckchat.basecomponent.core.BaseSP;

import java.util.ArrayList;
import java.util.List;

//关闭Activity的类
public class CloseAppUtil {

	public static List<Activity> activityList = new ArrayList<Activity>();

    /**
     * 退出APP
     * @param activity 当前Activity
     * */
	public static void closeApp(Activity activity) {
		// 关闭所有Activity
		for (int i = 0; i < activityList.size(); i++) {
			if (null != activityList.get(i)) {
				activityList.get(i).finish();
			}
		}
		//完全退出APP
		ActivityManager activityMgr = (ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE);
		activityMgr.killBackgroundProcesses(activity.getPackageName());
		System.exit(0);
	}
	
	/**
     * 退出登录重新登录
     * @param fromActivity 当前Activity
     * @param toRouter 目标窗口路由
     * @param clearUserClass  需要擦除用户数据所在的用户表Class       
     * */
	public static void restartLogin(Activity fromActivity, String toRouter, Class<? extends Model> clearUserClass){
        // 关闭所有Activity
        for (int i = 0; i < activityList.size(); i++) {
            if (null != activityList.get(i) && !activityList.get(i).getLocalClassName().equals(fromActivity.getLocalClassName())) {
                activityList.get(i).finish();
            }
        }
        new Delete().from(clearUserClass).execute();
        BaseSP.getInstance().put("login",false);//设置用户未登录
        BaseSP.getInstance().put("userId","");//设置用户ID为空
        ARouter.getInstance().build(toRouter).navigation(fromActivity);
        fromActivity.finish();
    }
}
