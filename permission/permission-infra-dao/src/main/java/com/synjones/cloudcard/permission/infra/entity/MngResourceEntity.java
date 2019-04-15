package com.synjones.cloudcard.permission.infra.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 资源
 * </p>
 *
 * @author Old rookie
 * @since 2019-04-14
 */
@TableName("mng_resource")
public class MngResourceEntity extends Model<MngResourceEntity> {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String url;
    private String type;
    @TableField("parent_id")
    private Integer parentId;
    private Integer level;
    private String ico;
    private String description;
    private String permission;
    /**
     * 排序序号
     */
    @TableField("seq_no")
    private Integer seqNo;
    @TableField("role_types")
    private String roleTypes;
    @TableField("last_updated_stamp")
    private Date lastUpdatedStamp;
    @TableField("created_stamp")
    private Date createdStamp;
    /**
     * 是否为第三方菜单  0:是  1:不是
     */
    @TableField("third_mune")
    private String thirdMune;


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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public String getRoleTypes() {
        return roleTypes;
    }

    public void setRoleTypes(String roleTypes) {
        this.roleTypes = roleTypes;
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

    public String getThirdMune() {
        return thirdMune;
    }

    public void setThirdMune(String thirdMune) {
        this.thirdMune = thirdMune;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "MngResource{" +
        ", id=" + id +
        ", name=" + name +
        ", url=" + url +
        ", type=" + type +
        ", parentId=" + parentId +
        ", level=" + level +
        ", ico=" + ico +
        ", description=" + description +
        ", permission=" + permission +
        ", seqNo=" + seqNo +
        ", roleTypes=" + roleTypes +
        ", lastUpdatedStamp=" + lastUpdatedStamp +
        ", createdStamp=" + createdStamp +
        ", thirdMune=" + thirdMune +
        "}";
    }
}
