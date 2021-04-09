package com.ruoyi.service.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.service.domain.myClass;
import com.ruoyi.service.mapper.MajorMapper;
import com.ruoyi.service.domain.Major;
import com.ruoyi.service.service.IMajorService;

/**
 * 专业管理Service业务层处理
 * 
 * @author XD
 * @date 2021-04-09
 */
@Service
public class MajorServiceImpl implements IMajorService 
{
    @Autowired
    private MajorMapper majorMapper;

    /**
     * 查询专业管理
     * 
     * @param majorId 专业管理ID
     * @return 专业管理
     */
    @Override
    public Major selectMajorById(Long majorId)
    {
        return majorMapper.selectMajorById(majorId);
    }

    /**
     * 查询专业管理列表
     * 
     * @param major 专业管理
     * @return 专业管理
     */
    @Override
    public List<Major> selectMajorList(Major major)
    {
        return majorMapper.selectMajorList(major);
    }

    /**
     * 新增专业管理
     * 
     * @param major 专业管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertMajor(Major major)
    {
        int rows = majorMapper.insertMajor(major);
        insertmyClass(major);
        return rows;
    }

    /**
     * 修改专业管理
     * 
     * @param major 专业管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateMajor(Major major)
    {
        majorMapper.deletemyClassByMajorId(major.getMajorId());
        insertmyClass(major);
        return majorMapper.updateMajor(major);
    }

    /**
     * 批量删除专业管理
     * 
     * @param majorIds 需要删除的专业管理ID
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteMajorByIds(Long[] majorIds)
    {
        majorMapper.deletemyClassByMajorIds(majorIds);
        return majorMapper.deleteMajorByIds(majorIds);
    }

    /**
     * 删除专业管理信息
     * 
     * @param majorId 专业管理ID
     * @return 结果
     */
    @Override
    public int deleteMajorById(Long majorId)
    {
        majorMapper.deletemyClassByMajorId(majorId);
        return majorMapper.deleteMajorById(majorId);
    }

    /**
     * 新增班级管理信息
     * 
     * @param major 专业管理对象
     */
    public void insertmyClass(Major major)
    {
        List<myClass> myClassList = major.getmyClassList();
        Long majorId = major.getMajorId();
        if (StringUtils.isNotNull(myClassList))
        {
            List<myClass> list = new ArrayList<myClass>();
            for (myClass myClass : myClassList)
            {
                myClass.setMajorId(majorId);
                list.add(myClass);
            }
            if (list.size() > 0)
            {
                majorMapper.batchmyClass(list);
            }
        }
    }
}
