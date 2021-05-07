package com.RestApi.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RestApi.entity.Book;


@Repository
public interface BookDao extends JpaRepository<Book, Long>{

}
