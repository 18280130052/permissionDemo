package com.synjones.cloudcard.permission.infra.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Old rookie
 * @since 2019-04-14
 */
@TableName("mng_role")
public class MngRoleEntity extends Model<MngRoleEntity> {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    @TableField("role_type")
    private String roleType;
    private String comments;
    @TableField("last_updated_oper_code")
    private String lastUpdatedOperCode;
    @TableField("created_oper_code")
    private String createdOperCode;
    @TableField("last_updated_stamp")
    private Date lastUpdatedStamp;
    @TableField("created_stamp")
    private Date createdStamp;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getLastUpdatedOperCode() {
        return lastUpdatedOperCode;
    }

    public void setLastUpdatedOperCode(String lastUpdatedOperCode) {
        this.lastUpdatedOperCode = lastUpdatedOperCode;
    }

    public String getCreatedOperCode() {
        return createdOperCode;
    }

    public void setCreatedOperCode(String createdOperCode) {
        this.createdOperCode = createdOperCode;
    }

    public Date getLastUpdatedStamp() {
        return lastUpdatedStamp;
    }

    public void setLastUpdatedStamp(Date lastUpdatedStamp) {
        this.lastUpdatedStamp = lastUpdatedStamp;
    }

    public Date getCreatedStamp() {
        return createdStamp;
    }

    public void setCreatedStamp(Date createdStamp) {
        this.createdStamp = createdStamp;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "MngRole{" +
        ", id=" + id +
        ", name=" + name +
        ", roleType=" + roleType +
        ", comments=" + comments +
        ", lastUpdatedOperCode=" + lastUpdatedOperCode +
        ", createdOperCode=" + createdOperCode +
        ", lastUpdatedStamp=" + lastUpdatedStamp +
        ", createdStamp=" + createdStamp +
        "}";
    }
}
