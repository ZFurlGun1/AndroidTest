package com.example.startproject_121azp.iface;

import com.example.startproject_121azp.bean.WeatherInfo;

/**
 * Created by zmy on 2017/3/14.
 */
//统一网络数据获取结果（成功  失败），定义接口
public interface WeatherListener {
    void onResponse(WeatherInfo weatherInfo);//成功
    void onFail(String msg);//失败

}
