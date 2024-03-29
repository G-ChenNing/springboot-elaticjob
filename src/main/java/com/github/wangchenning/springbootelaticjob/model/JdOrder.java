package com.github.wangchenning.springbootelaticjob.model;

import java.math.BigDecimal;
import java.util.Date;

public class JdOrder {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jd_order.id
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jd_order.status
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jd_order.amount
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    private BigDecimal amount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jd_order.create_user
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    private String createUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jd_order.create_time
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jd_order.update_user
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    private String updateUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jd_order.update_time
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jd_order.id
     *
     * @return the value of jd_order.id
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jd_order.id
     *
     * @param id the value for jd_order.id
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jd_order.status
     *
     * @return the value of jd_order.status
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jd_order.status
     *
     * @param status the value for jd_order.status
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jd_order.amount
     *
     * @return the value of jd_order.amount
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jd_order.amount
     *
     * @param amount the value for jd_order.amount
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jd_order.create_user
     *
     * @return the value of jd_order.create_user
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jd_order.create_user
     *
     * @param createUser the value for jd_order.create_user
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jd_order.create_time
     *
     * @return the value of jd_order.create_time
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jd_order.create_time
     *
     * @param createTime the value for jd_order.create_time
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jd_order.update_user
     *
     * @return the value of jd_order.update_user
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jd_order.update_user
     *
     * @param updateUser the value for jd_order.update_user
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jd_order.update_time
     *
     * @return the value of jd_order.update_time
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jd_order.update_time
     *
     * @param updateTime the value for jd_order.update_time
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}