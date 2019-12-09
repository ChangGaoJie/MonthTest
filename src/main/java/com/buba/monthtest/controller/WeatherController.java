package com.buba.monthtest.controller;


import com.alibaba.fastjson.JSONObject;
import com.buba.monthtest.pojo.Book;
import com.buba.monthtest.pojo.Weather;
import com.buba.monthtest.service.BookService;
import com.buba.monthtest.service.WeatherService;
import com.buba.monthtest.util.JSONUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.buba.monthtest.util.JSONUtils.json2Object;

/**
     * <p>
     *  前端控制器
     * </p>
     *
     * @author chang
     * @since 2019-08-26
     */
    @Controller
    @RequestMapping("/weather")
    public class WeatherController {
        @Autowired
        WeatherService weatherService;

        @ResponseBody
        @RequestMapping("/getWeather")
        @Scheduled(cron = "2 */5 * * * ?")
       public void getWeather() throws IOException {

            //获取文件夹名称
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            // 创建Date对象，表示当前时间
            Date now = new Date();
            String dirName = sdf.format(now);


            //拼接文件名称
            Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);
            String name=null;
            if(minute==0){
                name = hour + "" + minute + "0.txt";
            }else{
                name = hour + "" + minute + ".txt";
            }
            boolean b = false;
            //File file = new File("D:\\kaoshi\\bj\\2019-12-04\\0845.txt");
            File file = new File("D:\\kaoshi\\bj\\"+dirName+"\\"+name);
            String encoding = "GBK";
            //读取数据
            FileInputStream fin = null;
            StringBuilder str = new StringBuilder();
                fin = new FileInputStream(file);
                //获取通道
                FileChannel channel = fin.getChannel();
                //分配指定大小的缓冲区
                ByteBuffer bf = ByteBuffer.allocate(1024);
                //读取本地文件，并发送到客户端
                int bytesRead = channel.read(bf);
                while (bytesRead != -1) {
                    bf.flip();
                    //把缓冲区内容存入到StringBuilder
                    str.append(Charset.forName("GBK").decode(bf));
                    // 清空,position位置为0，limit=capacity
                    bf.clear();
                    //  继续往buffer中写
                    bytesRead = channel.read(bf);
                }
                fin.close();

                JSONObject weatherStr = JSONObject.parseObject(str.toString());
                if(weatherStr!=null){
                    //获取result的value
                    String result = weatherStr.getString("result");
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












          /* if (file.isFile() && file.exists()) { //判断文件是否存在
               InputStreamReader read = new InputStreamReader(
                       new FileInputStream(file), encoding);//考虑到编码格式

               BufferedReader bufferedReader = new BufferedReader(read);
               StringBuilder str=new StringBuilder();

               String lineTxt = null;
               while ((lineTxt = bufferedReader.readLine()) != null) {
                   str.append(lineTxt);
               }
               //截取字符串获取当前天气
               int realtime = str.indexOf("realtime");
               int future = str.indexOf("future");
               String weather = str.substring(realtime + 11, future - 5);
              weather="[{"+weather+"}]";
              //json转化为对象
               Weather weather1 = JSONUtils.json2Object(weather, Weather.class);
               //存到数据库
               b=weatherService.addWeather(weather1);



           }*/


        }
    }
