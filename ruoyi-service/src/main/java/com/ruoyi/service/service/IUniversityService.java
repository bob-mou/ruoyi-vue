package com.ruoyi.service.service;

import java.util.List;
import com.ruoyi.service.domain.University;

/**
 * 学校管理Service接口
 * 
 * @author ruoyi
 * @date 2021-04-09
 */
public interface IUniversityService 
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
     * 批量删除学校管理
     * 
     * @param universityIds 需要删除的学校管理ID
     * @return 结果
     */
    public int deleteUniversityByIds(Long[] universityIds);

    /**
     * 删除学校管理信息
     * 
     * @param universityId 学校管理ID
     * @return 结果
     */
    public int deleteUniversityById(Long universityId);
}
