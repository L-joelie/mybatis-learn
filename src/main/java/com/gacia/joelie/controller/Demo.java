package com.gacia.joelie.controller;

import com.gacia.joelie.mapper.RoleAnnotationMapper;
import com.gacia.joelie.mapper.RoleMapper;
import com.gacia.joelie.pojo.Role;
import com.gacia.joelie.util.SqlSessionFactoryUtil;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.Map;

/**
 * Demo
 *
 * @author lyq
 * @create 2018-06-22 19:24
 */
public class Demo {

    public static void main(String[] args) throws Exception{
        SqlSession sqlSession = null;

        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
//            Role role = new Role();
//            role.setRoleName("testName");
//            role.setNote("testNote");
//            roleMapper.insertRole(role);
//            roleMapper.deleteRole(1L);
            Map map = roleMapper.getRoleMap(3L);
            System.out.println(map);
            sqlSession.commit();
        } catch (Exception e){
            System.err.println(e.getMessage());
            sqlSession.rollback();
        } finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }
}
