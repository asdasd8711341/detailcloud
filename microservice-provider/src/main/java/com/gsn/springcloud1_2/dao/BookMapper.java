package com.gsn.springcloud1_2.dao;

import com.gsn.springcloud1_2.bean.Book;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BookMapper extends MisBaseMapper<Book>{
}
