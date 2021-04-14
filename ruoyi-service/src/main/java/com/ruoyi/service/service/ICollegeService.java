package com.ruoyi.service.service;

import java.util.List;
import com.ruoyi.service.domain.College;

/**
 * 学院管理Service接口
 *
 * @author 牟连波
 * @date 2021-04-09
 */
public interface ICollegeService
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
     * 批量删除学院管理
     *
     * @param collegeIds 需要删除的学院管理ID
     * @return 结果
     */
    public int deleteCollegeByIds(Long[] collegeIds);

    /**
     * 删除学院管理信息
     *
     * @param collegeId 学院管理ID
     * @return 结果
     */
    public int deleteCollegeById(Long collegeId);

}
