package com.ruoyi.service.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.service.mapper.ProjectMapper;
import com.ruoyi.service.domain.Project;
import com.ruoyi.service.service.IProjectService;

/**
 * 选题管理Service业务层处理
 * 
 * @author zhouq
 * @date 2021-04-12
 */
@Service
public class ProjectServiceImpl implements IProjectService 
{
    @Autowired
    private ProjectMapper projectMapper;

    /**
     * 查询选题管理
     * 
     * @param projectId 选题管理ID
     * @return 选题管理
     */
    @Override
    public Project selectProjectById(Long projectId)
    {
        return projectMapper.selectProjectById(projectId);
    }

    /**
     * 查询选题管理列表
     * 
     * @param project 选题管理
     * @return 选题管理
     */
    @Override
    public List<Project> selectProjectList(Project project)
    {
        return projectMapper.selectProjectList(project);
    }

    /**
     * 新增选题管理
     * 
     * @param project 选题管理
     * @return 结果
     */
    @Override
    public int insertProject(Project project)
    {
        return projectMapper.insertProject(project);
    }

    /**
     * 修改选题管理
     * 
     * @param project 选题管理
     * @return 结果
     */
    @Override
    public int updateProject(Project project)
    {
        return projectMapper.updateProject(project);
    }

    /**
     * 批量删除选题管理
     * 
     * @param projectIds 需要删除的选题管理ID
     * @return 结果
     */
    @Override
    public int deleteProjectByIds(Long[] projectIds)
    {
        return projectMapper.deleteProjectByIds(projectIds);
    }

    /**
     * 删除选题管理信息
     * 
     * @param projectId 选题管理ID
     * @return 结果
     */
    @Override
    public int deleteProjectById(Long projectId)
    {
        return projectMapper.deleteProjectById(projectId);
    }
}
