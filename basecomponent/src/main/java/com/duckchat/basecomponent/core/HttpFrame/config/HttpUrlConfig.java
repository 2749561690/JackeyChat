package com.duckchat.basecomponent.core.HttpFrame.config;

import com.duckchat.basecomponent.BaseInitData;
import com.duckchat.basecomponent.R;

public class HttpUrlConfig extends BaseInitData {
    //Tinker热修复补丁版本
    public static final int BuglyTinkerId = 0;

    //公司 | 官方网站
    public static final String www = "http://mallapp.liangshiba.com";
    //公司 | 后台地址
    public static final String http_client_url_back = "http://mallapp.liangshiba.com";
    //公司 | 猷客巴巴商城官网 pc版
    public static final String shopPc = "http://mallapp.liangshiba.com/index.htm";
    //公司 | 猷客巴巴商城官网 wap版
    public static final String shopWap = "http://mallapp.liangshiba.com/wap/index.htm";
    //公司 | 公司客服电话
    public static final String phone = "02362658096";
    //分享 | QQAppKey
    public static final String qqKey = "1105542643";
    //分享 | 新浪微博AppKey
    public static final String wbKey = "2951486102";
    public static final String wbRUrl = "http://www.zihang740.com";//回调url
    public static final String wbScope = "email,direct_messages_read,direct_messages_write,friendships_groups_read,friendships_groups_write,statuses_to_me_read,follow_app_official_microblog,invitation_write";
    //分享 | APK下载链接
    public static final String shareDownLoadUrl = www + "/inviter.htm?user_id=";
    public static final String shareDownLoadUrlNoLogin = www + "/inviter.htm";

    //支付宝 | 合作者身份ID
    public static final String ALIPAY_PARTNER = "2088522040796128";
    //支付宝 | 卖家支付宝账号
    public static final String ALIPAY_SELLER = "13996278777@139.com";
    //支付宝 | 服务器异步通知页面路径 | 广告费充值
    public static final String ALIPAY_CALLBACK_URL_AD_MONEY = http_client_url_back + "/alipay/pay_notify.do";
    //支付宝 | 服务器异步通知页面路径 | 成为广告商服务费
    public static final String ALIPAY_CALLBACK_URL_AD_SERVICE_MONEY = http_client_url_back + "/alipay/adServiceMoney.do";
    //支付宝 | 服务器异步通知页面路径 | 邀请码付费
    public static final String ALIPAY_CALLBACK_URL_USER_YQ_CODE = http_client_url_back + "/alipay/inviteCode.do";

    //公告连接
    public static final String NOTICE = http_client_url_back + "/notice/index.do";
    //二微码下载链接
    public static final String CODE2DOWNLOAD = http_client_url_back + "/notice/invitation.do?inviter=";
    //个人代理收益连接
    public static final String ADER = http_client_url_back + "/static/phoneweb/ader.html";
    //广告金额标准
    public static final String ADMONEY = http_client_url_back + "/static/phoneweb/admoney.html";
    //广告金额标准
    public static final String COPRIGHT = http_client_url_back + "/static/phoneweb/copyright.html";
    //用户提升收益
    public static final String USERADDMONEY = http_client_url_back + "/static/phoneweb/tssy/tgsy.html";
    //广告商特权
    public static final String ADPRIVILEGE = http_client_url_back + "/static/phoneweb/ggstq.html";
    //用户邀请排行规则
    public static final String USERRANKRULE = http_client_url_back + "/static/phoneweb/phb.html";
    //帮助
    public static final String HELP = www + "/help";
    //广告商报销
    public static final String ADERTIXIAN = www + "/phoneweb/42.html";
    //D币报销
    public static final String DBTIXIAN = www + "/phoneweb/43.html";
    //喵小店平台服务协议(入住协议)
    public static final String CHECKAGE = www + "/doc_store.htm";


    //初始化
    public static void init() {
//        http_client_url = "http://10.1.41.174:8080/SHOPAPP2.0/appShop7/";  //新//
        http_client_url = "http://10.1.41.174:8080/SHOPAPP2.0/appShop7/";  //新最新W11/22
////        http_client_url="http://c1.hsl8899.com/APP/appShop7/";        //原始地址
//        //http_client_url="http://mallapp.liangshiba.com/appShop7/";
////        http_client_url="http://192.168.199.5:8080/appShop7/";//老周
////        http_client_url="http://192.168.199.122:8080/appShop7/";//乔峰`
////        http_client_url="http://116.62.46.26/APP/appShop7/";  //新
//        //http_client_url="http://10.1.41.158:8080/buyer/Catfoodmanage.htm?user_id=1";  //新
//
////
//        http_mio_client_url = "http://47.52.190.51:8080/MFW/";  //*新服务器地址*
//        http_mio_client_url = "http://www.miaoxiaodian.shop/";  //*新Y域名服务器地址*
//        http_mio_client_url = "http://10.1.41.174:8888/";  //*新测试站地址*.0
//        http_mio_client_url = "http://10.1.41.198:8080/MFW/";  //新阿水11/13
//        http_mio_client_url = "http://10.1.41.158:8080/";  //新agoni
//        http_mio_client_url = "http://10.1.41.3:8080/MFW/";
//        http_mio_client_url = "http://10.10.37.34:8080/";  //新agoni临时IP
//        http_mio_client_url = "http://10.10.37.35:8080/MFW/";  //新Daniel临时IP
//        http_mio_client_url = "http://10.1.41.174:8888/";  //新W
//        http_mio_client_url = "http://10.1.41.174:8888/MFW/";  //最新新W
        http_client_key = "2200820a3e35ed74648e775cf3164e9d";
        http_client_version = 102;
        ImageFrameBgImage = new int[]{R.drawable.base_image_default, R.drawable.base_image_default, R.drawable.base_image_default};
        ImageFrameCacheDir = "Jackey";
        SharedPreferencesFileName = "jackey_share_data";
        WX_KEY = "wx7d314006a5998a80";
    }
}
