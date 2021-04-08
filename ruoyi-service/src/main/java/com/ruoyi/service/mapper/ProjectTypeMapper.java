package com.ruoyi.service.mapper;

import java.util.List;
import com.ruoyi.service.domain.ProjectType;
import com.ruoyi.service.domain.Project;
/**
 * 选题类别管理Mapper接口
 *
 * @author zhouq
 * @date 2021-04-08
 */
public interface ProjectTypeMapper
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
     * 删除选题类别管理
     *
     * @param projectTypeId 选题类别管理ID
     * @return 结果
     */
    public int deleteProjectTypeById(Long projectTypeId);

    /**
     * 批量删除选题类别管理
     *
     * @param projectTypeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProjectTypeByIds(Long[] projectTypeIds);

    /**
     * 批量删除选题管理
     *
     * @param projectTypeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProjectByProjectTypeIds(Long[] projectTypeIds);

    /**
     * 批量新增选题管理
     *
     * @param projectList 选题管理列表
     * @return 结果
     */
    public int batchProject(List<Project> projectList);


    /**
     * 通过选题类别管理ID删除选题管理信息
     *
     * @param projectTypeId 角色ID
     * @return 结果
     */
    public int deleteProjectByProjectTypeId(Long projectTypeId);
}
