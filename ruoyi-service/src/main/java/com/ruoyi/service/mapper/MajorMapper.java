package com.ruoyi.service.mapper;

import java.util.List;
import com.ruoyi.service.domain.Major;
import com.ruoyi.service.domain.myClass;

/**
 * 专业管理Mapper接口
 * 
 * @author XD
 * @date 2021-04-09
 */
public interface MajorMapper 
{
    /**
     * 查询专业管理
     * 
     * @param majorId 专业管理ID
     * @return 专业管理
     */
    public Major selectMajorById(Long majorId);

    /**
     * 查询专业管理列表
     * 
     * @param major 专业管理
     * @return 专业管理集合
     */
    public List<Major> selectMajorList(Major major);

    /**
     * 新增专业管理
     * 
     * @param major 专业管理
     * @return 结果
     */
    public int insertMajor(Major major);

    /**
     * 修改专业管理
     * 
     * @param major 专业管理
     * @return 结果
     */
    public int updateMajor(Major major);

    /**
     * 删除专业管理
     * 
     * @param majorId 专业管理ID
     * @return 结果
     */
    public int deleteMajorById(Long majorId);

    /**
     * 批量删除专业管理
     * 
     * @param majorIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteMajorByIds(Long[] majorIds);

    /**
     * 批量删除班级管理
     * 
     * @param customerIds 需要删除的数据ID
     * @return 结果
     */
    public int deletemyClassByMajorIds(Long[] majorIds);
    
    /**
     * 批量新增班级管理
     * 
     * @param myClassList 班级管理列表
     * @return 结果
     */
    public int batchmyClass(List<myClass> myClassList);
    

    /**
     * 通过专业管理ID删除班级管理信息
     * 
     * @param roleId 角色ID
     * @return 结果
     */
    public int deletemyClassByMajorId(Long majorId);
}
