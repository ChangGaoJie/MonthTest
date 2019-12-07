package com.buba.monthtest;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;

/**
 * @ClassName HdfsTest
 * @Description TODO
 * @Author Chang
 * @Date 2019/9/2 14:49
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
public class HdfsTest {
    FileSystem fs = null;

    @Before
    public void init() throws Exception {


        Configuration conf = new Configuration();
        /**
         * 参数优先级： 1、客户端代码中设置的值 2、classpath下的用户自定义配置文件 3、然后是jar中默认配置
         */
        // 获取一个hdfs的访问客户端

        fs = FileSystem.get(new URI("hdfs://node1:8020"), conf, "root");

    }

    @Test
    public void testMkdirAndDeleteAndRename() throws IllegalArgumentException, IOException {

        // 创建目录
        fs.mkdirs(new Path("/a1/b1/c1"));

        // 删除文件夹 ，如果是非空文件夹，参数2必须给值true ，删除所有子文件夹
       /* fs.delete(new Path("/aaa"), true);*/

        // 重命名文件或文件夹
        /*fs.rename(new Path("/a1"), new Path("/a2"));*/
        //创建文件
       /*fs.create(new Path("/aa/ss.txt"));*/

       //查看文件及文件夹信息
        /*FileStatus[] listStatus = fs.listStatus(new Path("/aa/ss.txt"));
        String flag = "";
        for (FileStatus fstatus : listStatus) {

            if (fstatus.isFile()) {
                flag = "f-- ";
            } else {
                flag = "d-- ";
            }
            System.out.println(flag + fstatus.getPath().getName());
            System.out.println(fstatus.getPermission());

        }*/

        //读取hdfs文件到控制台
       /* FSDataOutputStream output = fs.create(new Path("/aa/vv.txt"));
        output.write("测试".getBytes());
        output.flush();
        output.close();
        FSDataInputStream input = fs.open(new Path("/aa/vv.txt"));
        IOUtils.copyBytes(input,System.out,1024);*/

        //一、上传本地文件到hdfs
        /*fs.copyFromLocalFile(new Path("H:\\redis.txt"),new Path("/aa"));*/

        //二、
         /*//1.获取输入流
        FileInputStream fis = new FileInputStream(new File("H:\\redis.txt"));
        // 2.获取输出流
        FSDataOutputStream fos = fs.create(new Path("/aa/redis.txt"));
        // 3.流的拷贝
        IOUtils.copyBytes(fis, fos, new Configuration());
        // 4.关闭资源
        IOUtils.closeStream(fis);
        IOUtils.closeStream(fos);*/

        //从hdfs下载文件到本地
        /*fs.copyToLocalFile(new Path("/aa/redis.txt"),new Path("H:\\ss"));*/


    }



}
