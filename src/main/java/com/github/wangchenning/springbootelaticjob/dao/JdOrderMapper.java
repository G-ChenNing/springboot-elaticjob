package com.github.wangchenning.springbootelaticjob.dao;

import com.github.wangchenning.springbootelaticjob.model.JdOrder;
import com.github.wangchenning.springbootelaticjob.model.JdOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JdOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_order
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    long countByExample(JdOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_order
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    int deleteByExample(JdOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_order
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_order
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    int insert(JdOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_order
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    int insertSelective(JdOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_order
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    List<JdOrder> selectByExample(JdOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_order
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    JdOrder selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_order
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    int updateByExampleSelective(@Param("record") JdOrder record, @Param("example") JdOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_order
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    int updateByExample(@Param("record") JdOrder record, @Param("example") JdOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_order
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    int updateByPrimaryKeySelective(JdOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_order
     *
     * @mbg.generated Tue Jun 18 17:45:45 CST 2019
     */
    int updateByPrimaryKey(JdOrder record);
}