package com.mtoliv.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Aaron
 * @since 2018-06-13
 */
@TableName("t_role_permission")
public class RolePermission extends Model<RolePermission> {

    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;
    @TableField("role_id")
    private Long roleId;
    @TableField("permission_id")
    private Long permissionId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
        ", id=" + id +
        ", roleId=" + roleId +
        ", permissionId=" + permissionId +
        "}";
    }
}
