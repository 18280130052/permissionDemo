package com.synjones.cloudcard.permission.provider.models;

import java.io.Serializable;
import java.util.Date;

public class MngUserRo implements Serializable {
    private static final long serialVersionUID = -164644987923154L;

    private String userName;
    private String password;
    private String roleType;
    private String partyGroupId;
    private String operCode;
    private String realName;
    private String mobile;
    private String email;
    private String status;
    private String comments;
    private Integer lastFailCount;
    private Date lastFailDt;
    private String lastFailIp;
    private Date lastSuccDt;
    private String lastSuccIp;
    private String lastUpdatedOperCode;
    private String createdOperCode;
    private Date lastUpdatedStamp;
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
    public String toString() {
        return "MngUserRo{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", roleType='" + roleType + '\'' +
                ", partyGroupId='" + partyGroupId + '\'' +
                ", operCode='" + operCode + '\'' +
                ", realName='" + realName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", comments='" + comments + '\'' +
                ", lastFailCount=" + lastFailCount +
                ", lastFailDt=" + lastFailDt +
                ", lastFailIp='" + lastFailIp + '\'' +
                ", lastSuccDt=" + lastSuccDt +
                ", lastSuccIp='" + lastSuccIp + '\'' +
                ", lastUpdatedOperCode='" + lastUpdatedOperCode + '\'' +
                ", createdOperCode='" + createdOperCode + '\'' +
                ", lastUpdatedStamp=" + lastUpdatedStamp +
                ", createdStamp=" + createdStamp +
                '}';
    }
}
