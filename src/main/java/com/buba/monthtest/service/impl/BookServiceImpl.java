package com.buba.monthtest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.buba.monthtest.dao.BookMapper;
import com.buba.monthtest.pojo.Book;
import com.buba.monthtest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BookServiceImpl
 * @Description TODO
 * @Author Chang
 * @Date 2019/9/23 15:41
 * @Version 1.0
 **/
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;
    @Override
    public List<Book> getList(String orderBy) {
        List<Book> list= bookMapper.selectList(new QueryWrapper<Book>().orderBy(true,false,orderBy));

        return list;
    }
}
