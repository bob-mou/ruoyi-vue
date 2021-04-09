package com.ruoyi.service.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.service.domain.Major;
import com.ruoyi.service.mapper.CollegeMapper;
import com.ruoyi.service.domain.College;
import com.ruoyi.service.service.ICollegeService;

/**
 * 学院管理Service业务层处理
 * 
 * @author 牟连波
 * @date 2021-04-09
 */
@Service
public class CollegeServiceImpl implements ICollegeService 
{
    @Autowired
    private CollegeMapper collegeMapper;

    /**
     * 查询学院管理
     * 
     * @param collegeId 学院管理ID
     * @return 学院管理
     */
    @Override
    public College selectCollegeById(Long collegeId)
    {
        return collegeMapper.selectCollegeById(collegeId);
    }

    /**
     * 查询学院管理列表
     * 
     * @param college 学院管理
     * @return 学院管理
     */
    @Override
    public List<College> selectCollegeList(College college)
    {
        return collegeMapper.selectCollegeList(college);
    }

    /**
     * 新增学院管理
     * 
     * @param college 学院管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertCollege(College college)
    {
        college.setCreateTime(DateUtils.getNowDate());
        int rows = collegeMapper.insertCollege(college);
        insertMajor(college);
        return rows;
    }

    /**
     * 修改学院管理
     * 
     * @param college 学院管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateCollege(College college)
    {
        collegeMapper.deleteMajorByMajorId(college.getCollegeId());
        insertMajor(college);
        return collegeMapper.updateCollege(college);
    }

    /**
     * 批量删除学院管理
     * 
     * @param collegeIds 需要删除的学院管理ID
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteCollegeByIds(Long[] collegeIds)
    {
        collegeMapper.deleteMajorByMajorIds(collegeIds);
        return collegeMapper.deleteCollegeByIds(collegeIds);
    }

    /**
     * 删除学院管理信息
     * 
     * @param collegeId 学院管理ID
     * @return 结果
     */
    @Override
    public int deleteCollegeById(Long collegeId)
    {
        collegeMapper.deleteMajorByMajorId(collegeId);
        return collegeMapper.deleteCollegeById(collegeId);
    }

    /**
     * 新增专业管理信息
     * 
     * @param college 学院管理对象
     */
    public void insertMajor(College college)
    {
        List<Major> majorList = college.getMajorList();
        Long collegeId = college.getCollegeId();
        if (StringUtils.isNotNull(majorList))
        {
            List<Major> list = new ArrayList<Major>();
            for (Major major : majorList)
            {
                major.setMajorId(collegeId);
                list.add(major);
            }
            if (list.size() > 0)
            {
                collegeMapper.batchMajor(list);
            }
        }
    }
}
