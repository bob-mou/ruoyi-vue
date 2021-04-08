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
import com.ruoyi.service.domain.ProjectType;
import com.ruoyi.service.service.IProjectTypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 选题类别管理Controller
 * 
 * @author zhouq
 * @date 2021-04-08
 */
@RestController
@RequestMapping("/service/type")
public class ProjectTypeController extends BaseController
{
    @Autowired
    private IProjectTypeService projectTypeService;

    /**
     * 查询选题类别管理列表
     */
    @PreAuthorize("@ss.hasPermi('service:type:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProjectType projectType)
    {
        startPage();
        List<ProjectType> list = projectTypeService.selectProjectTypeList(projectType);
        return getDataTable(list);
    }

    /**
     * 导出选题类别管理列表
     */
    @PreAuthorize("@ss.hasPermi('service:type:export')")
    @Log(title = "选题类别管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ProjectType projectType)
    {
        List<ProjectType> list = projectTypeService.selectProjectTypeList(projectType);
        ExcelUtil<ProjectType> util = new ExcelUtil<ProjectType>(ProjectType.class);
        return util.exportExcel(list, "type");
    }

    /**
     * 获取选题类别管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('service:type:query')")
    @GetMapping(value = "/{projectTypeId}")
    public AjaxResult getInfo(@PathVariable("projectTypeId") Long projectTypeId)
    {
        return AjaxResult.success(projectTypeService.selectProjectTypeById(projectTypeId));
    }

    /**
     * 新增选题类别管理
     */
    @PreAuthorize("@ss.hasPermi('service:type:add')")
    @Log(title = "选题类别管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProjectType projectType)
    {
        return toAjax(projectTypeService.insertProjectType(projectType));
    }

    /**
     * 修改选题类别管理
     */
    @PreAuthorize("@ss.hasPermi('service:type:edit')")
    @Log(title = "选题类别管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProjectType projectType)
    {
        return toAjax(projectTypeService.updateProjectType(projectType));
    }

    /**
     * 删除选题类别管理
     */
    @PreAuthorize("@ss.hasPermi('service:type:remove')")
    @Log(title = "选题类别管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{projectTypeIds}")
    public AjaxResult remove(@PathVariable Long[] projectTypeIds)
    {
        return toAjax(projectTypeService.deleteProjectTypeByIds(projectTypeIds));
    }
}
