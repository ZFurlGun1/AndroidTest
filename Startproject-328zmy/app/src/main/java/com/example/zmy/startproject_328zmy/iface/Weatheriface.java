package com.example.zmy.startproject_328zmy.iface;

/**
 * Created by zmy on 2017/3/14.
 */
//不同方式获取天气，定义接口
public interface Weatheriface {
    void getWeather(String cityno,WeatherListener listener);

}
