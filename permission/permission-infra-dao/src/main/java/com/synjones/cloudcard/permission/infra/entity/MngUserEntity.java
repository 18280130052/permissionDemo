package com.synjones.cloudcard.permission.infra.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
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
@TableName("mng_user")
public class MngUserEntity extends Model<MngUserEntity> {

    private static final long serialVersionUID = 1L;

    @TableId("user_name")
    private String userName;
    private String password;
    @TableField("role_type")
    private String roleType;
    @TableField("party_group_id")
    private String partyGroupId;
    @TableField("oper_code")
    private String operCode;
    @TableField("real_name")
    private String realName;
    private String mobile;
    private String email;
    private String status;
    private String comments;
    @TableField("last_fail_count")
    private Integer lastFailCount;
    @TableField("last_fail_dt")
    private Date lastFailDt;
    @TableField("last_fail_ip")
    private String lastFailIp;
    @TableField("last_succ_dt")
    private Date lastSuccDt;
    @TableField("last_succ_ip")
    private String lastSuccIp;
    @TableField("last_updated_oper_code")
    private String lastUpdatedOperCode;
    @TableField("created_oper_code")
    private String createdOperCode;
    @TableField("last_updated_stamp")
    private Date lastUpdatedStamp;
    @TableField("created_stamp")
    private Date createdStamp;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getPartyGroupId() {
        return partyGroupId;
    }

    public void setPartyGroupId(String partyGroupId) {
        this.partyGroupId = partyGroupId;
    }

    public String getOperCode() {
        return operCode;
    }

    public void setOperCode(String operCode) {
        this.operCode = operCode;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getLastFailCount() {
        return lastFailCount;
    }

    public void setLastFailCount(Integer lastFailCount) {
        this.lastFailCount = lastFailCount;
    }

    public Date getLastFailDt() {
        return lastFailDt;
    }

    public void setLastFailDt(Date lastFailDt) {
        this.lastFailDt = lastFailDt;
    }

    public String getLastFailIp() {
        return lastFailIp;
    }

    public void setLastFailIp(String lastFailIp) {
        this.lastFailIp = lastFailIp;
    }

    public Date getLastSuccDt() {
        return lastSuccDt;
    }

    public void setLastSuccDt(Date lastSuccDt) {
        this.lastSuccDt = lastSuccDt;
    }

    public String getLastSuccIp() {
        return lastSuccIp;
    }

    public void setLastSuccIp(String lastSuccIp) {
        this.lastSuccIp = lastSuccIp;
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
        return this.userName;
    }

    @Override
    public String toString() {
        return "MngUser{" +
        ", userName=" + userName +
        ", password=" + password +
        ", roleType=" + roleType +
        ", partyGroupId=" + partyGroupId +
        ", operCode=" + operCode +
        ", realName=" + realName +
        ", mobile=" + mobile +
        ", email=" + email +
        ", status=" + status +
        ", comments=" + comments +
        ", lastFailCount=" + lastFailCount +
        ", lastFailDt=" + lastFailDt +
        ", lastFailIp=" + lastFailIp +
        ", lastSuccDt=" + lastSuccDt +
        ", lastSuccIp=" + lastSuccIp +
        ", lastUpdatedOperCode=" + lastUpdatedOperCode +
        ", createdOperCode=" + createdOperCode +
        ", lastUpdatedStamp=" + lastUpdatedStamp +
        ", createdStamp=" + createdStamp +
        "}";
    }
}
