package com.gsn.springcloud1_2.service;

import com.gsn.springcloud1_2.bean.Book;

import java.util.List;

public interface BookService {
    public Book getBook(Integer id);
    public List<Book>  getAll();
}
