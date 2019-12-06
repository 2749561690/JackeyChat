package com.duckchat.basecomponent.util;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

import com.duckchat.basecomponent.core.BaseSP;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetWorkUtil {

    private static String[] platforms = {
            "http://pv.sohu.com/cityjson",
            "http://pv.sohu.com/cityjson?ie=utf-8",
            "http://ip.chinaz.com/getip.aspx"
    };

    public static void getOutNetIP(Context context, final int index) {
        if (index < platforms.length) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    BufferedReader buff = null;
                    HttpURLConnection urlConnection = null;
                    try {
                        URL url = new URL(platforms[index]);
                        urlConnection = (HttpURLConnection) url.openConnection();
                        urlConnection.setRequestMethod("GET");
                        urlConnection.setReadTimeout(5000);//读取超时
                        urlConnection.setConnectTimeout(5000);//连接超时
                        urlConnection.setDoInput(true);
                        urlConnection.setUseCaches(false);

                        int responseCode = urlConnection.getResponseCode();
                        if (responseCode == HttpURLConnection.HTTP_OK) {//找到服务器的情况下,可能还会找到别的网站返回html格式的数据
                            InputStream is = urlConnection.getInputStream();
                            buff = new BufferedReader(new InputStreamReader(is, "UTF-8"));//注意编码，会出现乱码
                            StringBuilder builder = new StringBuilder();
                            String line = null;
                            while ((line = buff.readLine()) != null) {
                                builder.append(line);
                            }

                            buff.close();//内部会关闭 InputStream
                            urlConnection.disconnect();

                            Log.e("xiaoman", builder.toString());
                            if (index == 0 || index == 1) {
                                //截取字符串
                                int satrtIndex = builder.indexOf("{");//包含[
                                int endIndex = builder.indexOf("}");//包含]
                                String json = builder.substring(satrtIndex, endIndex + 1);//包含[satrtIndex,endIndex)
                                JSONObject jo = new JSONObject(json);
                                String ip = jo.getString("cip");
                                BaseSP.getInstance().put("OUT_IP", ip);
//                                return ip;
                            } else if (index == 2) {
                                JSONObject jo = new JSONObject(builder.toString());
                                BaseSP.getInstance().put("OUT_IP", jo.getString("ip"));
//                                return jo.getString("ip");
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } else {
            BaseSP.getInstance().put("OUT_IP", getInNetIp(context));
//            return getInNetIp(context);
        }
//        return getOutNetIP(context, ++index);
    }

    public static String getInNetIp(Context context) {
        //获取wifi服务
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        //判断wifi是否开启
        if (!wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
        }

        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        int ipAddress = wifiInfo.getIpAddress();
        String ip = intToIp(ipAddress);

        return ip;
    }

    //这段是转换成点分式IP的码
    private static String intToIp(int ip) {
        return (ip & 0xFF) + "." + ((ip >> 8) & 0xFF) + "." + ((ip >> 16) & 0xFF) + "." + (ip >> 24 & 0xFF);
    }

}
