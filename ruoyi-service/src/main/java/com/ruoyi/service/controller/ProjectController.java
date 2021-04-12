package com.ruoyi.service.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.service.domain.Project;
import com.ruoyi.service.service.IProjectService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 选题管理Controller
 * 
 * @author zhouq
 * @date 2021-04-12
 */
@RestController
@RequestMapping("/service/project")
public class ProjectController extends BaseController
{
    @Autowired
    private IProjectService projectService;

    /**
     * 查询选题管理列表
     */
    @PreAuthorize("@ss.hasPermi('service:project:list')")
    @GetMapping("/list")
    public TableDataInfo list(Project project)
    {
        startPage();
        List<Project> list = projectService.selectProjectList(project);
        return getDataTable(list);
    }

    /**
     * 导出选题管理列表
     */
    @PreAuthorize("@ss.hasPermi('service:project:export')")
    @Log(title = "选题管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Project project)
    {
        List<Project> list = projectService.selectProjectList(project);
        ExcelUtil<Project> util = new ExcelUtil<Project>(Project.class);
        return util.exportExcel(list, "project");
    }

    /**
     * 获取选题管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('service:project:query')")
    @GetMapping(value = "/{projectId}")
    public AjaxResult getInfo(@PathVariable("projectId") Long projectId)
    {
        return AjaxResult.success(projectService.selectProjectById(projectId));
    }

    /**
     * 新增选题管理
     */
    @PreAuthorize("@ss.hasPermi('service:project:add')")
    @Log(title = "选题管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Project project)
    {
        return toAjax(projectService.insertProject(project));
    }

    /**
     * 修改选题管理
     */
    @PreAuthorize("@ss.hasPermi('service:project:edit')")
    @Log(title = "选题管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Project project)
    {
        return toAjax(projectService.updateProject(project));
    }

    /**
     * 删除选题管理
     */
    @PreAuthorize("@ss.hasPermi('service:project:remove')")
    @Log(title = "选题管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{projectIds}")
    public AjaxResult remove(@PathVariable Long[] projectIds)
    {
        return toAjax(projectService.deleteProjectByIds(projectIds));
    }
}
