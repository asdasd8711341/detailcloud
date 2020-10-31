package com.gsn.springcloud1_2.service;

import com.gsn.springcloud1_2.bean.Book;
import com.gsn.springcloud1_2.dao.BookMapper;
import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl  implements  BookService {

    @Autowired(required =  false)
    private BookMapper bookMapper;


    @Override
    public Book getBook(Integer id) {
        return  bookMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Book> getAll() {
        return bookMapper.selectAll();
    }


}
