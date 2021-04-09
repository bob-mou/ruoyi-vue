package com.ruoyi.service.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.service.mapper.myClassMapper;
import com.ruoyi.service.domain.myClass;
import com.ruoyi.service.service.ImyClassService;

/**
 * 班级管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-09
 */
@Service
public class myClassServiceImpl implements ImyClassService 
{
    @Autowired
    private myClassMapper myClassMapper;

    /**
     * 查询班级管理
     * 
     * @param classId 班级管理ID
     * @return 班级管理
     */
    @Override
    public myClass selectmyClassById(Long classId)
    {
        return myClassMapper.selectmyClassById(classId);
    }

    /**
     * 查询班级管理列表
     * 
     * @param myClass 班级管理
     * @return 班级管理
     */
    @Override
    public List<myClass> selectmyClassList(myClass myClass)
    {
        return myClassMapper.selectmyClassList(myClass);
    }

    /**
     * 新增班级管理
     * 
     * @param myClass 班级管理
     * @return 结果
     */
    @Override
    public int insertmyClass(myClass myClass)
    {
        return myClassMapper.insertmyClass(myClass);
    }

    /**
     * 修改班级管理
     * 
     * @param myClass 班级管理
     * @return 结果
     */
    @Override
    public int updatemyClass(myClass myClass)
    {
        return myClassMapper.updatemyClass(myClass);
    }

    /**
     * 批量删除班级管理
     * 
     * @param classIds 需要删除的班级管理ID
     * @return 结果
     */
    @Override
    public int deletemyClassByIds(Long[] classIds)
    {
        return myClassMapper.deletemyClassByIds(classIds);
    }

    /**
     * 删除班级管理信息
     * 
     * @param classId 班级管理ID
     * @return 结果
     */
    @Override
    public int deletemyClassById(Long classId)
    {
        return myClassMapper.deletemyClassById(classId);
    }
}
