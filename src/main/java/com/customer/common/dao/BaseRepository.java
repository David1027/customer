package com.customer.common.dao;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import com.querydsl.jpa.impl.JPAQueryFactory;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description: 引入Querydsl的统一类
 * @author: lingjian
 * @create: 2019/7/30 15:02
 */
public abstract class BaseRepository {

  @Autowired protected EntityManager entityManager;
  protected JPAQueryFactory queryFactory;

  @PostConstruct
  public void init() {
    queryFactory = new JPAQueryFactory(entityManager);
  }
}
