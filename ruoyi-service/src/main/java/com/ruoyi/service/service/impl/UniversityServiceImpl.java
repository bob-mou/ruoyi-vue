package com.ruoyi.service.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.service.mapper.CollegeMapper;
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
    @Autowired
    private CollegeMapper collegeMapper;

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
        College c = new College();
        c.setUniversityId(universityId);
        //数据库查询学校所有学院
        List<College> OcollegeList = collegeMapper.selectCollegeList(c);
        //存放数据库里的college_id
        List<Long> OcollegeId = new ArrayList<>();
        //存放前端传过来的college_id
        List<Long> collegeId = new ArrayList<>();
        for(College college : OcollegeList){
            OcollegeId.add(college.getCollegeId());
        }
        if (StringUtils.isNotNull(collegeList))
        {
            //list存放数据库中没有的college对象，用于添加
            List<College> list = new ArrayList<College>();
            for (College college : collegeList)
            {
                college.setUniversityId(universityId);
                if(college.getCollegeId()!=null){
                    collegeMapper.updateCollege(college);
                    collegeId.add(college.getCollegeId());
                    continue;
                }else{
                    list.add(college);
                }
            }
            if (list.size() > 0)
            {
                universityMapper.batchCollege(list);
            }
        }
        // 遍历b集合
        for (int i = 0; i < OcollegeId.size(); i++) {
            // 默认为true，如果有相等的就置为false，不移除
            for (int j = 0; j < collegeId.size(); j++) {
                if (OcollegeId.get(i).equals(collegeId.get(j))) {
                    OcollegeId.remove(i); // 相等则移除
                }
            }
        }
        if(OcollegeId.size() > 0){
            Long [] delcollegeId = new Long[OcollegeId.size()];
            for(int i=0;i<OcollegeId.size();i++){
                delcollegeId[i]=OcollegeId.get(i);
            }
            collegeMapper.deleteCollegeByIds(delcollegeId);
        }
    }
}
