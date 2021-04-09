package com.ruoyi.service.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.service.domain.College;
import com.ruoyi.service.mapper.UniversityMapper;
import com.ruoyi.service.domain.University;
import com.ruoyi.service.service.IUniversityService;

/**
 * 学校管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-09
 */
@Service
public class UniversityServiceImpl implements IUniversityService 
{
    @Autowired
    private UniversityMapper universityMapper;

    /**
     * 查询学校管理
     * 
     * @param universityId 学校管理ID
     * @return 学校管理
     */
    @Override
    public University selectUniversityById(Long universityId)
    {
        return universityMapper.selectUniversityById(universityId);
    }

    /**
     * 查询学校管理列表
     * 
     * @param university 学校管理
     * @return 学校管理
     */
    @Override
    public List<University> selectUniversityList(University university)
    {
        return universityMapper.selectUniversityList(university);
    }

    /**
     * 新增学校管理
     * 
     * @param university 学校管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertUniversity(University university)
    {
        university.setCreateTime(DateUtils.getNowDate());
        int rows = universityMapper.insertUniversity(university);
        insertCollege(university);
        return rows;
    }

    /**
     * 修改学校管理
     * 
     * @param university 学校管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateUniversity(University university)
    {
        universityMapper.deleteCollegeByUniversityId(university.getUniversityId());
        insertCollege(university);
        return universityMapper.updateUniversity(university);
    }

    /**
     * 批量删除学校管理
     * 
     * @param universityIds 需要删除的学校管理ID
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteUniversityByIds(Long[] universityIds)
    {
        universityMapper.deleteCollegeByUniversityIds(universityIds);
        return universityMapper.deleteUniversityByIds(universityIds);
    }

    /**
     * 删除学校管理信息
     * 
     * @param universityId 学校管理ID
     * @return 结果
     */
    @Override
    public int deleteUniversityById(Long universityId)
    {
        universityMapper.deleteCollegeByUniversityId(universityId);
        return universityMapper.deleteUniversityById(universityId);
    }

    /**
     * 新增学院管理信息
     * 
     * @param university 学校管理对象
     */
    public void insertCollege(University university)
    {
        List<College> collegeList = university.getCollegeList();
        Long universityId = university.getUniversityId();
        if (StringUtils.isNotNull(collegeList))
        {
            List<College> list = new ArrayList<College>();
            for (College college : collegeList)
            {
                college.setUniversityId(universityId);
                list.add(college);
            }
            if (list.size() > 0)
            {
                universityMapper.batchCollege(list);
            }
        }
    }
}
