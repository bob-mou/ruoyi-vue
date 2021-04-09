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
import com.ruoyi.service.domain.myClass;
import com.ruoyi.service.service.ImyClassService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 班级管理Controller
 * 
 * @author ruoyi
 * @date 2021-04-09
 */
@RestController
@RequestMapping("/service/myclass")
public class myClassController extends BaseController
{
    @Autowired
    private ImyClassService myClassService;

    /**
     * 查询班级管理列表
     */
    @PreAuthorize("@ss.hasPermi('service:myclass:list')")
    @GetMapping("/list")
    public TableDataInfo list(myClass myClass)
    {
        startPage();
        List<myClass> list = myClassService.selectmyClassList(myClass);
        return getDataTable(list);
    }

    /**
     * 导出班级管理列表
     */
    @PreAuthorize("@ss.hasPermi('service:myclass:export')")
    @Log(title = "班级管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(myClass myClass)
    {
        List<myClass> list = myClassService.selectmyClassList(myClass);
        ExcelUtil<myClass> util = new ExcelUtil<myClass>(myClass.class);
        return util.exportExcel(list, "myclass");
    }

    /**
     * 获取班级管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('service:myclass:query')")
    @GetMapping(value = "/{classId}")
    public AjaxResult getInfo(@PathVariable("classId") Long classId)
    {
        return AjaxResult.success(myClassService.selectmyClassById(classId));
    }

    /**
     * 新增班级管理
     */
    @PreAuthorize("@ss.hasPermi('service:myclass:add')")
    @Log(title = "班级管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody myClass myClass)
    {
        return toAjax(myClassService.insertmyClass(myClass));
    }

    /**
     * 修改班级管理
     */
    @PreAuthorize("@ss.hasPermi('service:myclass:edit')")
    @Log(title = "班级管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody myClass myClass)
    {
        return toAjax(myClassService.updatemyClass(myClass));
    }

    /**
     * 删除班级管理
     */
    @PreAuthorize("@ss.hasPermi('service:myclass:remove')")
    @Log(title = "班级管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{classIds}")
    public AjaxResult remove(@PathVariable Long[] classIds)
    {
        return toAjax(myClassService.deletemyClassByIds(classIds));
    }
}
