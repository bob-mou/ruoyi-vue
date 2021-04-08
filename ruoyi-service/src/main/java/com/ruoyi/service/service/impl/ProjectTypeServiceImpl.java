package com.ruoyi.service.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.service.mapper.ProjectTypeMapper;
import com.ruoyi.service.domain.ProjectType;
import com.ruoyi.service.service.IProjectTypeService;

/**
 * 选题类别管理Service业务层处理
 *
 * @author zhouq
 * @date 2021-04-08
 */
@Service
public class ProjectTypeServiceImpl implements IProjectTypeService
{
    @Autowired
    private ProjectTypeMapper projectTypeMapper;

    /**
     * 查询选题类别管理
     *
     * @param projectTypeId 选题类别管理ID
     * @return 选题类别管理
     */
    @Override
    public ProjectType selectProjectTypeById(Long projectTypeId)
    {
        return projectTypeMapper.selectProjectTypeById(projectTypeId);
    }

    /**
     * 查询选题类别管理列表
     *
     * @param projectType 选题类别管理
     * @return 选题类别管理
     */
    @Override
    public List<ProjectType> selectProjectTypeList(ProjectType projectType)
    {
        return projectTypeMapper.selectProjectTypeList(projectType);
    }

    /**
     * 新增选题类别管理
     *
     * @param projectType 选题类别管理
     * @return 结果
     */
    @Override
    public int insertProjectType(ProjectType projectType)
    {
        return projectTypeMapper.insertProjectType(projectType);
    }

    /**
     * 修改选题类别管理
     *
     * @param projectType 选题类别管理
     * @return 结果
     */
    @Override
    public int updateProjectType(ProjectType projectType)
    {
        return projectTypeMapper.updateProjectType(projectType);
    }

    /**
     * 批量删除选题类别管理
     *
     * @param projectTypeIds 需要删除的选题类别管理ID
     * @return 结果
     */
    @Override
    public int deleteProjectTypeByIds(Long[] projectTypeIds)
    {
        return projectTypeMapper.deleteProjectTypeByIds(projectTypeIds);
    }

    /**
     * 删除选题类别管理信息
     *
     * @param projectTypeId 选题类别管理ID
     * @return 结果
     */
    @Override
    public int deleteProjectTypeById(Long projectTypeId)
    {
        return projectTypeMapper.deleteProjectTypeById(projectTypeId);
    }
}
