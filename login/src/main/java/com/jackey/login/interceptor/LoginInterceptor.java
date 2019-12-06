package com.jackey.login.interceptor;

import android.content.Context;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.duckchat.basecomponent.core.BaseSP;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录拦截器
 *
 * @author hzh
 * @version 1.0
 * @date 2018/4/9
 */
@Interceptor(priority = 1, name = "LoginIntercept")
public class LoginInterceptor implements IInterceptor {

    public Map<String, String> interceptorMap;

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        if (null == (interceptorMap.get(postcard.getPath()))) {
            //不需要登录拦截的路由 
            callback.onContinue(postcard);
        } else {
            if (BaseSP.getInstance().getBoolean("login", false)) {
                //已登录
                callback.onContinue(postcard);
            } else {
                //未登录
                callback.onInterrupt(null);
                Bundle bundle = postcard.getExtras();
                bundle.putString("targetPath", postcard.getPath());
                ARouter.getInstance().build("/login/login").with(bundle).greenChannel().navigation();
            }
        }
    }

    @Override
    public void init(Context context) {
        //添加需要拦截的路由页面
        interceptorMap = new HashMap<String, String>();
        interceptorMap.put("/user/UserRedAwardRecordUI", "/user/UserRedAwardRecordUI");
        interceptorMap.put("/user/UserAlipayUI", "/user/UserAlipayUI");
        interceptorMap.put("/user/UserShopOrderUI", "/user/UserShopOrderUI");
        interceptorMap.put("/user/UserProfitUI", "/user/UserProfitUI");
        interceptorMap.put("/user/UserYqUI", "/user/UserYqUI");
        interceptorMap.put("/user/UserNewtaskLUI", "/user/UserNewtaskLUI");
        interceptorMap.put("/user/UserStealRedMainUI", "/user/UserStealRedMainUI");
        interceptorMap.put("/user/UserDownloadUrlUI", "/user/UserDownloadUrlUI");
        interceptorMap.put("/user/UserRedAwardUI", "/user/UserRedAwardUI");
        interceptorMap.put("/user/VipIndexLUI", "/user/VipIndexLUI");

        interceptorMap.put("/store/StoreGoodsInfoAttrSelectUI", "/store/StoreGoodsInfoAttrSelectUI");
        interceptorMap.put("/store/StoreExchangeOrderInfoUI", "/store/StoreExchangeOrderInfoUI");
        interceptorMap.put("/store/StoreGoodsInfoUI", "/store/StoreGoodsInfoUI");
        interceptorMap.put("/store/StoreSaleUI", "/store/StoreSaleUI");
        interceptorMap.put("/store/StoreSaleFailUI", "/store/StoreSaleFailUI");
        interceptorMap.put("/store/StoreSaleSuccessUI", "/store/StoreSaleSuccessUI");
        interceptorMap.put("/store/SinginRUI", "/store/SinginRUI");

        interceptorMap.put("/mine/MineCoreUI", "/mine/MineCoreUI");
        interceptorMap.put("/mine/MineBalanceLUI", "/mine/MineBalanceLUI");
        interceptorMap.put("/mine/MineOrderUI", "/mine/MineOrderUI");
        interceptorMap.put("/mine/MineAchievementUI", "/mine/MineAchievementUI");
        interceptorMap.put("/mine/MineLjsyUI", "/mine/MineLjsyUI");
        interceptorMap.put("/mine/MineBalanceRUI", "/mine/MineBalanceRUI");
        interceptorMap.put("/mine/MineScoreRecharge", "/mine/MineScoreRecharge");
        interceptorMap.put("/mine/MineTeamLUI", "/mine/MineTeamLUI");
        interceptorMap.put("/mine/MineExchangeUI", "/mine/MineExchangeUI");
        interceptorMap.put("/mine/MineVisitUI", "/mine/MineVisitUI");

        interceptorMap.put("/ad/ClientIndexUI", "/ad/ClientIndexUI");
        interceptorMap.put("/ad/ClientRealnameUI", "/ad/ClientRealnameUI");
        interceptorMap.put("/ad/ClientAdProve2UI", "/ad/ClientAdProve2UI");
        interceptorMap.put("/ad/ClientFloorBillsUI", "/ad/ClientFloorBillsUI");

        interceptorMap.put("/sk/SKBuyLUI", "/sk/SKBuyLUI");
        interceptorMap.put("/sk/SKBuyUI", "/sk/SKBuyUI");

        interceptorMap.put("/singin/SigninShareUI", "/singin/SigninShareUI");

        interceptorMap.put("/comn/XWebViewActivity", "/comn/XWebViewActivity");

        interceptorMap.put("/im/ImSessionUI", "/im/ImSessionUI");

        interceptorMap.put("/miomanager/MioManagerUI", "/miomanager/MioManagerUI");
    }
}
