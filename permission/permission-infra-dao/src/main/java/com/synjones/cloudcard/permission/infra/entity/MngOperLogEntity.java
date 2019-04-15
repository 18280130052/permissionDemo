package com.synjones.cloudcard.permission.infra.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 操作员日志
 * </p>
 *
 * @author Old rookie
 * @since 2019-04-14
 */
@TableName("mng_oper_log")
public class MngOperLogEntity extends Model<MngOperLogEntity> {

    private static final long serialVersionUID = 1L;

    /**
     * 日志id
     */
    @TableId("log_id")
    private Long logId;
    /**
     * 模块标题
     */
    private String title;
    /**
     * 业务类型（0其它 1新增 2修改 3删除）
     */
    @TableField("biz_type")
    private Integer bizType;
    private String method;
    /**
     * 操作类别（0其它 1后台用户 2手机端用户）
     */
    @TableField("oper_type")
    private Integer operType;
    @TableField("user_name")
    private String userName;
    /**
     * 请求URL
     */
    @TableField("oper_url")
    private String operUrl;
    /**
     * 主机地址
     */
    @TableField("oper_ip")
    private String operIp;
    /**
     * 操作地点
     */
    @TableField("oper_location")
    private String operLocation;
    /**
     * 请求参数
     */
    @TableField("oper_param")
    private String operParam;
    /**
     * 操作状态（0正常 1失败）
     */
    private Integer status;
    /**
     * 提示信息
     */
    @TableField("msg_info")
    private String msgInfo;
    /**
     * 操作时间
     */
    @TableField("created_stamp")
    private Date createdStamp;


    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getBizType() {
        return bizType;
    }

    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer getOperType() {
        return operType;
    }

    public void setOperType(Integer operType) {
        this.operType = operType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOperUrl() {
        return operUrl;
    }

    public void setOperUrl(String operUrl) {
        this.operUrl = operUrl;
    }

    public String getOperIp() {
        return operIp;
    }

    public void setOperIp(String operIp) {
        this.operIp = operIp;
    }

    public String getOperLocation() {
        return operLocation;
    }

    public void setOperLocation(String operLocation) {
        this.operLocation = operLocation;
    }

    public String getOperParam() {
        return operParam;
    }

    public void setOperParam(String operParam) {
        this.operParam = operParam;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(String msgInfo) {
        this.msgInfo = msgInfo;
    }

    public Date getCreatedStamp() {
        return createdStamp;
    }

    public void setCreatedStamp(Date createdStamp) {
        this.createdStamp = createdStamp;
    }

    @Override
    protected Serializable pkVal() {
        return this.logId;
    }

    @Override
    public String toString() {
        return "MngOperLog{" +
        ", logId=" + logId +
        ", title=" + title +
        ", bizType=" + bizType +
        ", method=" + method +
        ", operType=" + operType +
        ", userName=" + userName +
        ", operUrl=" + operUrl +
        ", operIp=" + operIp +
        ", operLocation=" + operLocation +
        ", operParam=" + operParam +
        ", status=" + status +
        ", msgInfo=" + msgInfo +
        ", createdStamp=" + createdStamp +
        "}";
    }
}
