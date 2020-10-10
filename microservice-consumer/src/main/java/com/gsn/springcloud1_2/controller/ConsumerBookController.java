package com.gsn.springcloud1_2.controller;

import com.gsn.springcloud1_2.dormain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerBookController {
    private  final  static  String URL = "http://localhost:8888/book/";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("{id}")
    public Book getBook(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(URL+id,Book.class);
    }

    @GetMapping("/getAll")
    public List<Book> getAll(){
        return  restTemplate.getForObject(URL+"get" +
                "All",List.class);
    }

}
