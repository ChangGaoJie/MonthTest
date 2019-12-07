package com.buba.monthtest.controller;


import com.buba.monthtest.pojo.Book;
import com.buba.monthtest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chang
 * @since 2019-08-26
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping("getAllBook")
    public List<Book> getAllStudent (String orderBy){

        List<Book>  list=bookService.getList(orderBy);

        return list;
    }

}
