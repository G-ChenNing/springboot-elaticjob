package com.github.wangchenning.springbootelaticjob.dao;

import com.github.wangchenning.springbootelaticjob.model.TmailOrder;
import com.github.wangchenning.springbootelaticjob.model.TmailOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmailOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tmail_order
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    long countByExample(TmailOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tmail_order
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    int deleteByExample(TmailOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tmail_order
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tmail_order
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    int insert(TmailOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tmail_order
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    int insertSelective(TmailOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tmail_order
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    List<TmailOrder> selectByExample(TmailOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tmail_order
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    TmailOrder selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tmail_order
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    int updateByExampleSelective(@Param("record") TmailOrder record, @Param("example") TmailOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tmail_order
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    int updateByExample(@Param("record") TmailOrder record, @Param("example") TmailOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tmail_order
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    int updateByPrimaryKeySelective(TmailOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tmail_order
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    int updateByPrimaryKey(TmailOrder record);

    List<TmailOrder> getNotFetchOrder(int i);

}