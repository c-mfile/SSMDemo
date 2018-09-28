package com.company.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_function")
public class TbFunction {
    @Id
    @Column(name = "function_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long functionId;

    @Column(name = "function_name")
    private String functionName;

    @Column(name = "function_url")
    private String functionUrl;

    private String description;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_user")
    private Long createUser;

    @Column(name = "modify_time")
    private Date modifyTime;

    @Column(name = "modify_user")
    private Long modifyUser;

    @Column(name = "valid_flag")
    private Integer validFlag;

    /**
     * @return function_id
     */
    public Long getFunctionId() {
        return functionId;
    }

    /**
     * @param functionId
     */
    public void setFunctionId(Long functionId) {
        this.functionId = functionId;
    }

    /**
     * @return function_name
     */
    public String getFunctionName() {
        return functionName;
    }

    /**
     * @param functionName
     */
    public void setFunctionName(String functionName) {
        this.functionName = functionName == null ? null : functionName.trim();
    }

    /**
     * @return function_url
     */
    public String getFunctionUrl() {
        return functionUrl;
    }

    /**
     * @param functionUrl
     */
    public void setFunctionUrl(String functionUrl) {
        this.functionUrl = functionUrl == null ? null : functionUrl.trim();
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return create_user
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * @return modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * @param modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * @return modify_user
     */
    public Long getModifyUser() {
        return modifyUser;
    }

    /**
     * @param modifyUser
     */
    public void setModifyUser(Long modifyUser) {
        this.modifyUser = modifyUser;
    }

    /**
     * @return valid_flag
     */
    public Integer getValidFlag() {
        return validFlag;
    }

    /**
     * @param validFlag
     */
    public void setValidFlag(Integer validFlag) {
        this.validFlag = validFlag;
    }
}