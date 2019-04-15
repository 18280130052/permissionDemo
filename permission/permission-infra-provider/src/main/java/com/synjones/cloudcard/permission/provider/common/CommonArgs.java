package com.synjones.cloudcard.permission.provider.common;

import java.io.Serializable;

public class CommonArgs implements Serializable {
    private String manualRegionId; // 分区
    private String custId; // 客户
    private String mchId; // 商户
    private String areaId; // 内区
    private String[] deptIds; // 部门
    private String[] workAroundIds; //工作区域
    private String token;

    public String getManualRegionId() {
        return manualRegionId;
    }

    public void setManualRegionId(String manualRegionId) {
        this.manualRegionId = manualRegionId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String[] getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(String[] deptIds) {
        this.deptIds = deptIds;
    }

    public String[] getWorkAroundIds() {
        return workAroundIds;
    }

    public void setWorkAroundIds(String[] workAroundIds) {
        this.workAroundIds = workAroundIds;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
