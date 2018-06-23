package com.gacia.joelie.mapper;

import com.gacia.joelie.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * RoleAnnotationMapper
 *
 * @author lyq
 * @create 2018-06-22 20:14
 */
@Mapper
public interface RoleAnnotationMapper {

    @Select("select id,role_name as roleName,note from t_role where id=#{id}")
    Role getRole(Long id);

}
