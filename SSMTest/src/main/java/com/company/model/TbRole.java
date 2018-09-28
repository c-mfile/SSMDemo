package com.company.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_role")
public class TbRole {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(name = "role_name")
    private String roleName;

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

    private Long haveThisRoleUserId;
   	public Long getHaveThisRoleUserId() {
   		return haveThisRoleUserId;
   	}

   	public void setHaveThisRoleUserId(Long haveThisRoleUserId) {
   		this.haveThisRoleUserId = haveThisRoleUserId;
   	}
    
    
    /**
     * @return role_id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * @return role_name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
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