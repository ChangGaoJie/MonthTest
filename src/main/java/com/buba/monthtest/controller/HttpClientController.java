package com.buba.monthtest.controller;

import com.alibaba.fastjson.JSONObject;
import com.buba.monthtest.pojo.Weather;
import com.buba.monthtest.service.WeatherService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yan
 * @ClassName HttpClientController
 * @Description TODO 测试httpclient
 * @Version 1.0.0
 * @Modify By:
 * @createTime 2019/12/5 19:33
 */
@Controller
@RequestMapping("/http")
public class HttpClientController {


    @Autowired
    WeatherService weatherService;

    //请求 聚合数据的key
    public static final String AGGREGATE_DATA_KEY_OF_Weather = "1755a69dc31e74b2e5a547fdb2633eb5";//天气预报(免费)
    public static final String AGGREGATE_DATA_KEY_OF_TheNationalWeather = "08bdb39ca01c375f3c76d12ed22b57e6";//全国天气预报(收费)
    //HttpClient client = new DefaultHttpClient();
    @RequestMapping("/getHttpClientOfWeather")
    @Async
    public boolean getHttpClientOfWeather(String cityName)throws Exception{
        boolean b=false;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //天气预报(免费)
        HttpPost httpPost = new HttpPost("http://apis.juhe.cn/simpleWeather/query");
        //设置http请求参数
        List<NameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("city", "北京"));
        list.add(new BasicNameValuePair("key", AGGREGATE_DATA_KEY_OF_Weather));
        //设置请求体，并指定请求体中内容的编码格式
        httpPost.setEntity(new UrlEncodedFormEntity(list, Charset.forName("UTF-8")));
        HttpResponse response = httpclient.execute(httpPost);
        //获取响应实体
        HttpEntity httpEntity=response.getEntity();
        String weatherStr=EntityUtils.toString(httpEntity);
        //System.out.println("EntityUtils.toString(httpEntity):   "+weatherStr);
        System.out.println("weatherStr接收到:   "+weatherStr);
        JSONObject obj = JSONObject.parseObject(weatherStr);
        /*获取返回状态码*/
        weatherStr=obj.getString("error_code");
        Weather weather=new Weather();

        /*如果状态码是0说明返回数据成功*/
        if(weatherStr!=null&&weatherStr.equals("0")){
            weatherStr=obj.getString("result");
            obj=JSONObject.parseObject(weatherStr);
            String realtimeWeatherStr=obj.getString("realtime");
            obj=JSONObject.parseObject(realtimeWeatherStr);
            weather.setTemperature(obj.getString("temperature"));//湿度
            weather.setHumidity(obj.getString("humidity"));//温度
            weather.setInfo(obj.getString("info"));//天气情况描述
            weather.setWid(obj.getString("wid"));//天气情况描述
            weather.setDirect(obj.getString("direct"));//天气情况描述
            weather.setPower(obj.getString("power"));//风力等级
            weather.setAqi(obj.getString("aqi"));//空气质量指数
            b=weatherService.addWeather(weather);
            /**
             * "temperature":"-6",
             * 			"humidity":"53",
             * 			"info":"晴",
             * 			"wid":"00",
             * 			"direct":"东北风",
             * 			"power":"1级",
             * 			"aqi":"36"
             * 		 private Integer id;
             *     private Date time;
             *     private String temperature;
             *     private String humidity;
             *     private String info;
             *     private String wid;
             *     private String direct;
             *     private String power;
             *     private String aqi;
             */
        }else{
            System.out.println("获取天气数据响应出现异常:   "+weatherStr);
        }
       return b;
    }
    /**
     * 使用httpClient获取全国天气数据 The national weather
     * @param cityName
     * @throws Exception
     */
    /*@RequestMapping("/getHttpClientOfTheNationalWeather")
    @ResponseBody
    public Weather getHttpClientOfTheNationalWeather(String cityName)throws Exception{
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://v.juhe.cn/weather/index?cityname="+cityName+"&key="+AGGREGATE_DATA_KEY_OF_TheNationalWeather);
        HttpResponse response = httpclient.execute(get);
        //打印响应状态
        System.out.println(response.getStatusLine());
        //获取响应实体
        HttpEntity httpEntity=response.getEntity();
        String weatherStr=EntityUtils.toString(httpEntity);
        //System.out.println("EntityUtils.toString(httpEntity):   "+weatherStr);
        System.out.println("weatherStr:   "+weatherStr);
        JSONObject obj = JSONObject.parseObject(weatherStr);

        *//*获取返回状态码*//*
        weatherStr=obj.getString("resultcode");
        Weather weather=new Weather();
        *//*如果状态码是200说明返回数据成功*//*
        if(weatherStr!=null&&weatherStr.equals("200")){
            weatherStr=obj.getString("result");
            //result中数据有多个key,可以对其key进行遍历,得到对个属性
            obj=JSONObject.parseObject(weatherStr);
            String skWeatherStr=obj.getString("sk");
            String todayWeatherStr=obj.getString("today");
            //
            obj=JSONObject.fromObject(skWeatherStr);
            weather.setWindDirection(obj.getString("wind_direction"));
            weather.setHumidity(obj.getString("humidity"));
            weather.setWindPower(obj.getString("wind_strength"));
            obj=JSONObject.fromObject(todayWeatherStr);
            weather.setTemperature(obj.getString("temperature"));
            weather.setWeatherDescription(obj.getString("weather"));
            weather.setCity(obj.getString("city"));
            weather.setWind(obj.getString("week"));
            weather.setDateY(obj.getString("date_y"));
        }else{
            System.out.println("获取全国天气数据响应出现异常:   "+weatherStr);
        }
        System.out.println("weather:   "+weather);
        return weather;
    }*/

}
