package com.gacia.joelie.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;


/**
 * SqlSessionFactoryUtil
 *
 * @author lyq
 * @create 2018-06-22 20:40
 */
public class SqlSessionFactoryUtil {

    private static final Logger log = LoggerFactory.getLogger(SqlSessionFactoryUtil.class);

    private static SqlSessionFactory sqlSessionFactory = null;

    private static final Class CLASS_LOCK = SqlSessionFactoryUtil.class;

    private SqlSessionFactoryUtil(){}

    public static SqlSessionFactory initSqlSessionFactory() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            log.error("null", e);
        }

        synchronized (CLASS_LOCK){
            if(sqlSessionFactory == null){
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
        }
        return sqlSessionFactory;
    }


    public static SqlSession openSqlSession(){
        if(sqlSessionFactory == null){
            initSqlSessionFactory();
        }

        return sqlSessionFactory.openSession();
    }
}
