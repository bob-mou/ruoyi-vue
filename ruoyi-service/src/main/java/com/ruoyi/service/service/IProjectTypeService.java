package com.ruoyi.service.service;

import java.util.List;
import com.ruoyi.service.domain.ProjectType;

/**
 * 选题类别管理Service接口
 * 
 * @author zhouq
 * @date 2021-04-08
 */
public interface IProjectTypeService 
{
    /**
     * 查询选题类别管理
     * 
     * @param projectTypeId 选题类别管理ID
     * @return 选题类别管理
     */
    public ProjectType selectProjectTypeById(Long projectTypeId);

    /**
     * 查询选题类别管理列表
     * 
     * @param projectType 选题类别管理
     * @return 选题类别管理集合
     */
    public List<ProjectType> selectProjectTypeList(ProjectType projectType);

    /**
     * 新增选题类别管理
     * 
     * @param projectType 选题类别管理
     * @return 结果
     */
    public int insertProjectType(ProjectType projectType);

    /**
     * 修改选题类别管理
     * 
     * @param projectType 选题类别管理
     * @return 结果
     */
    public int updateProjectType(ProjectType projectType);

    /**
     * 批量删除选题类别管理
     * 
     * @param projectTypeIds 需要删除的选题类别管理ID
     * @return 结果
     */
    public int deleteProjectTypeByIds(Long[] projectTypeIds);

    /**
     * 删除选题类别管理信息
     * 
     * @param projectTypeId 选题类别管理ID
     * @return 结果
     */
    public int deleteProjectTypeById(Long projectTypeId);
}
