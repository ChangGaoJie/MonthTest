package com.buba.monthtest.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.mapred.lib.db.DBWritable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName Book
 * @Description TODO
 * @Author Chang
 * @Date 2019/9/19 19:22
 * @Version 1.0
 **/
@TableName("book")
public class Book implements WritableComparable<Book>,DBWritable {
    @TableId("id")
    private Integer id;
    private String author;
    private String name;
    private String type;
    private Integer num;
    private Integer countTui;
    private Integer countClick;
    private Integer weekTui;

    public Book(String author, String name, String type, Integer num, Integer countTui, Integer countClick, Integer weekTui) {

        this.author = author;
        this.name = name;
        this.type = type;
        this.num = num;
        this.countTui = countTui;
        this.countClick = countClick;
        this.weekTui = weekTui;
    }

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getCountTui() {
        return countTui;
    }

    public void setCountTui(Integer countTui) {
        this.countTui = countTui;
    }

    public Integer getCountClick() {
        return countClick;
    }

    public void setCountClick(Integer countClick) {
        this.countClick = countClick;
    }

    public Integer getWeekTui() {
        return weekTui;
    }

    public void setWeekTui(Integer weekTui) {
        this.weekTui = weekTui;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(author);
        dataOutput.writeUTF(name);
        dataOutput.writeUTF(type);
        dataOutput.writeInt(num);
        dataOutput.writeInt(countTui);
        dataOutput.writeInt(countClick);
        dataOutput.writeInt(weekTui);

    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        author=dataInput.readUTF();
        name=dataInput.readUTF();
        type=dataInput.readUTF();
        num=dataInput.readInt();
        countTui=dataInput.readInt();
        countClick=dataInput.readInt();
        weekTui=dataInput.readInt();
    }
/* this.id = id;
        this.author = author;
        this.name = name;
        this.type = type;
        this.num = num;
        this.countTui = countTui;
        this.countClick = countClick;
        this.weekTui = weekTui;*/
    @Override
    public void write(PreparedStatement preparedStatement) throws SQLException {
      //  preparedStatement.setInt(1,this.id);
        preparedStatement.setString(1,this.author);
        preparedStatement.setString(2,this.name);
        preparedStatement.setString(3,this.type);
        preparedStatement.setInt(4,this.num);
        preparedStatement.setInt(5,this.countTui);
        preparedStatement.setInt(6,this.countClick);
        preparedStatement.setInt(7,this.weekTui);

    }

    @Override
    public void readFields(ResultSet resultSet) throws SQLException {
        this.author = resultSet.getString(1);
        this.name = resultSet.getString(2);
        this.type = resultSet.getString(3);
        this.num = resultSet.getInt(4);
        this.countTui = resultSet.getInt(5);
        this.countClick = resultSet.getInt(6);
        this.weekTui = resultSet.getInt(7);
    }
    @Override
    public int compareTo(Book o) {
        return this.countClick>o.countClick?-1:1;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", num=" + num +
                ", countTui=" + countTui +
                ", countClick=" + countClick +
                ", weekTui=" + weekTui +
                '}';
    }
}
