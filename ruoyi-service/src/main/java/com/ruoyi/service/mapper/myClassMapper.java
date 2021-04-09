package com.ruoyi.service.mapper;

import java.util.List;
import com.ruoyi.service.domain.myClass;

/**
 * 班级管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-09
 */
public interface myClassMapper 
{
    /**
     * 查询班级管理
     * 
     * @param classId 班级管理ID
     * @return 班级管理
     */
    public myClass selectmyClassById(Long classId);

    /**
     * 查询班级管理列表
     * 
     * @param myClass 班级管理
     * @return 班级管理集合
     */
    public List<myClass> selectmyClassList(myClass myClass);

    /**
     * 新增班级管理
     * 
     * @param myClass 班级管理
     * @return 结果
     */
    public int insertmyClass(myClass myClass);

    /**
     * 修改班级管理
     * 
     * @param myClass 班级管理
     * @return 结果
     */
    public int updatemyClass(myClass myClass);

    /**
     * 删除班级管理
     * 
     * @param classId 班级管理ID
     * @return 结果
     */
    public int deletemyClassById(Long classId);

    /**
     * 批量删除班级管理
     * 
     * @param classIds 需要删除的数据ID
     * @return 结果
     */
    public int deletemyClassByIds(Long[] classIds);
}
