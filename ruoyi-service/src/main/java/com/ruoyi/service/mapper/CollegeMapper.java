package com.ruoyi.service.mapper;

import java.util.List;
import com.ruoyi.service.domain.College;
import com.ruoyi.service.domain.Major;

/**
 * 学院管理Mapper接口
 * 
 * @author 牟连波
 * @date 2021-04-09
 */
public interface CollegeMapper 
{
    /**
     * 查询学院管理
     * 
     * @param collegeId 学院管理ID
     * @return 学院管理
     */
    public College selectCollegeById(Long collegeId);

    /**
     * 查询学院管理列表
     * 
     * @param college 学院管理
     * @return 学院管理集合
     */
    public List<College> selectCollegeList(College college);

    /**
     * 新增学院管理
     * 
     * @param college 学院管理
     * @return 结果
     */
    public int insertCollege(College college);

    /**
     * 修改学院管理
     * 
     * @param college 学院管理
     * @return 结果
     */
    public int updateCollege(College college);

    /**
     * 删除学院管理
     * 
     * @param collegeId 学院管理ID
     * @return 结果
     */
    public int deleteCollegeById(Long collegeId);

    /**
     * 批量删除学院管理
     * 
     * @param collegeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCollegeByIds(Long[] collegeIds);

    /**
     * 批量删除专业管理
     * 
     * @param customerIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteMajorByMajorIds(Long[] collegeIds);
    
    /**
     * 批量新增专业管理
     * 
     * @param majorList 专业管理列表
     * @return 结果
     */
    public int batchMajor(List<Major> majorList);
    

    /**
     * 通过学院管理ID删除专业管理信息
     * 
     * @param roleId 角色ID
     * @return 结果
     */
    public int deleteMajorByMajorId(Long collegeId);
}
