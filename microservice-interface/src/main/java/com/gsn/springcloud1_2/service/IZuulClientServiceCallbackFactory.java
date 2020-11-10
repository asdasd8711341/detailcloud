package com.gsn.springcloud1_2.service;


import com.gsn.springcloud1_2.bean.Book;
import com.gsn.springcloud1_2.bean.User1;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IZuulClientServiceCallbackFactory implements FallbackFactory<IZUUlClientService> {
    @Override
    public IZUUlClientService create(Throwable throwable) {
        return new IZUUlClientService(){


            @Override
            public Book getBook(long id) {
                Book b =new Book();
                b.setBookId(-1);
                b.setBookName("网络故障，请稍后尝试");
                return b;
            }

            @Override
            public List<Book> getAll() {
                return null;
            }

            @Override
            public User1 getUser(String name) {
                User1 u =new User1();
                u.setName("网络故障，请稍后尝试");
                return u;
            }

            @Override
            public User1 getUser2(String name) {
                User1 u =new User1();
                u.setName("网络故障，请稍后尝试");
                return u;
            }
        };
    }
}

