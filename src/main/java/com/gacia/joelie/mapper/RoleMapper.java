package com.gacia.joelie.mapper;

import com.gacia.joelie.pojo.Role;

import java.util.Map;

/**
 * RoleMapper
 *
 * @author lyq
 * @create 2018-06-22 19:53
 */
public interface RoleMapper {

    Role getRole(Long id);

    int deleteRole(Long id);

    int insertRole(Role role);

    Map getRoleMap(Long id);
}
