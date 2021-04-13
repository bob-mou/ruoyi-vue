package com.ruoyi.service.mapper;

import java.util.List;
import com.ruoyi.service.domain.University;
import com.ruoyi.service.domain.College;

/**
 * 学校管理Mapper接口
 *
 * @author ruoyi
 * @date 2021-04-09
 */
public interface UniversityMapper
{
    /**
     * 查询学校管理
     *
     * @param universityId 学校管理ID
     * @return 学校管理
     */
    public University selectUniversityById(Long universityId);

    /**
     * 查询学校管理列表
     *
     * @param university 学校管理
     * @return 学校管理集合
     */
    public List<University> selectUniversityList(University university);

    /**
     * 新增学校管理
     *
     * @param university 学校管理
     * @return 结果
     */
    public int insertUniversity(University university);

    /**
     * 修改学校管理
     *
     * @param university 学校管理
     * @return 结果
     */
    public int updateUniversity(University university);

    /**
     * 删除学校管理
     *
     * @param universityId 学校管理ID
     * @return 结果
     */
    public int deleteUniversityById(Long universityId);

    /**
     * 批量删除学校管理
     *
     * @param universityIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteUniversityByIds(Long[] universityIds);

    /**
     * 批量删除学院管理
     *
     * @param universityIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCollegeByUniversityIds(Long[] universityIds);

    /**
     * 批量新增学院管理
     *
     * @param collegeList 学院管理列表
     * @return 结果
     */
    public int batchCollege(List<College> collegeList);


    /**
     * 通过学校管理ID删除学院管理信息
     *
     * @param universityId 角色ID
     * @return 结果
     */
    public int deleteCollegeByUniversityId(Long universityId);
}
