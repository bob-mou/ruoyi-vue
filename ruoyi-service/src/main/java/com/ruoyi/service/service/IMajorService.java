package com.ruoyi.service.service;

import java.util.List;
import com.ruoyi.service.domain.Major;

/**
 * 专业管理Service接口
 * 
 * @author XD
 * @date 2021-04-09
 */
public interface IMajorService 
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
     * 批量删除专业管理
     * 
     * @param majorIds 需要删除的专业管理ID
     * @return 结果
     */
    public int deleteMajorByIds(Long[] majorIds);

    /**
     * 删除专业管理信息
     * 
     * @param majorId 专业管理ID
     * @return 结果
     */
    public int deleteMajorById(Long majorId);
}
