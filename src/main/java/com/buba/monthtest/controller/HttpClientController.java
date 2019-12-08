package com.buba.monthtest.controller;

import com.alibaba.fastjson.JSONObject;
import com.buba.monthtest.pojo.Weather;
import com.buba.monthtest.service.WeatherService;
import com.buba.monthtest.util.JSONUtils;
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

/*
 * @Author Chang
 * @Description //TODO
 * @Date 20:46 2019/12/8
 * @Param 
 * @return 
 **/
@Controller
@RequestMapping("/http")

public class HttpClientController {


    @Autowired
    WeatherService weatherService;


    //请求 聚合数据的key
    public static final String AGGREGATE_DATA_KEY_OF_Weather = "73a2b5b190a967a638ade0090dff057c";//天气预报(免费)
    public static final String AGGREGATE_DATA_KEY_OF_TheNationalWeather = "08bdb39ca01c375f3c76d12ed22b57e6";//全国天气预报(收费)
    //HttpClient client = new DefaultHttpClient();

    @RequestMapping("/getHttpClientOfWeather")
    @ResponseBody
    public void getHttpClientOfWeather(String cityName)throws Exception{
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
            //获取result的value
            String result = obj.getString("result");
            //转化为JSONObject
            JSONObject realtime = JSONObject.parseObject(result);

            //获取result中的realtime的value
            String real = realtime.getString("realtime");

            real="["+real+"]";
            //json转化为对象
            System.out.println(real);
            Weather weather1 = JSONUtils.json2Object(real, Weather.class);
            //存到数据库
            b=weatherService.addWeather(weather1);
        }
    }
}
