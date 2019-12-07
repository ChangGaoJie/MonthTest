package com.buba.monthtest.service;

import com.buba.monthtest.pojo.Book;

import java.util.List;

public interface BookService{

    List<Book> getList(String orderBy);
}
