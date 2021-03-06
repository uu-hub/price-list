package com.bytecheng.mall.dao;

import com.bytecheng.mall.model.UmsMenu;
import com.bytecheng.mall.model.UmsResource;
import feign.Param;

import java.util.List;

/**
 * @auther zmsoft
 * @Created 2021/3/4 17:45
 */
public interface UmsRoleDao {
    /**
     * 根据后台用户ID获取菜单
     */
    List<UmsMenu> getMenuList(@Param("adminId") Long adminId);
    /**
     * 根据角色ID获取菜单
     */
    List<UmsMenu> getMenuListByRoleId(@Param("roleId") Long roleId);
    /**
     * 根据角色ID获取资源
     */
    List<UmsResource> getResourceListByRoleId(@Param("roleId") Long roleId);
}
