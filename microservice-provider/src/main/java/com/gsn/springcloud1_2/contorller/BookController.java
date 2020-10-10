package com.gsn.springcloud1_2.contorller;


import com.gsn.springcloud1_2.bean.Book;
import com.gsn.springcloud1_2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("book")
public class BookController {


    @Autowired
    private BookService bookService;


    @GetMapping("{id}")
    public Book getBook(@PathVariable("id") Integer id) {
        return bookService.getBook(id);
    }

    @GetMapping("getAll")
    public List<Book> getAll(){
        return  bookService.getAll();
    }
}
