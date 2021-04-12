package com.ruoyi.service.service;

import java.util.List;
import com.ruoyi.service.domain.Project;

/**
 * 选题管理Service接口
 * 
 * @author zhouq
 * @date 2021-04-12
 */
public interface IProjectService 
{
    /**
     * 查询选题管理
     * 
     * @param projectId 选题管理ID
     * @return 选题管理
     */
    public Project selectProjectById(Long projectId);

    /**
     * 查询选题管理列表
     * 
     * @param project 选题管理
     * @return 选题管理集合
     */
    public List<Project> selectProjectList(Project project);

    /**
     * 新增选题管理
     * 
     * @param project 选题管理
     * @return 结果
     */
    public int insertProject(Project project);

    /**
     * 修改选题管理
     * 
     * @param project 选题管理
     * @return 结果
     */
    public int updateProject(Project project);

    /**
     * 批量删除选题管理
     * 
     * @param projectIds 需要删除的选题管理ID
     * @return 结果
     */
    public int deleteProjectByIds(Long[] projectIds);

    /**
     * 删除选题管理信息
     * 
     * @param projectId 选题管理ID
     * @return 结果
     */
    public int deleteProjectById(Long projectId);
}
