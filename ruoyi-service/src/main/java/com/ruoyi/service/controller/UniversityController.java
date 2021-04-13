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
import com.ruoyi.service.domain.University;
import com.ruoyi.service.service.IUniversityService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学校管理Controller
 *
 * @author ruoyi
 * @date 2021-04-09
 */
@RestController
@RequestMapping("/service/university")
public class UniversityController extends BaseController
{
    @Autowired
    private IUniversityService universityService;

    /**
     * 查询学校管理列表
     */
    @PreAuthorize("@ss.hasPermi('service:university:list')")
    @GetMapping("/list")
    public TableDataInfo list(University university)
    {
        startPage();
        List<University> list = universityService.selectUniversityList(university);
        return getDataTable(list);
    }
    /**
     * 导出学校管理列表
     */
    @PreAuthorize("@ss.hasPermi('service:university:export')")
    @Log(title = "学校管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(University university)
    {
        List<University> list = universityService.selectUniversityList(university);
        ExcelUtil<University> util = new ExcelUtil<University>(University.class);
        return util.exportExcel(list, "university");
    }

    /**
     * 获取学校管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('service:university:query')")
    @GetMapping(value = "/{universityId}")
    public AjaxResult getInfo(@PathVariable("universityId") Long universityId)
    {
        University universities = universityService.selectUniversityById(universityId);
        return AjaxResult.success(universities);
    }

    /**
     * 新增学校管理
     */
    @PreAuthorize("@ss.hasPermi('service:university:add')")
    @Log(title = "学校管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody University university)
    {
        return toAjax(universityService.insertUniversity(university));
    }

    /**
     * 修改学校管理
     */
    @PreAuthorize("@ss.hasPermi('service:university:edit')")
    @Log(title = "学校管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody University university)
    {
        return toAjax(universityService.updateUniversity(university));
    }

    /**
     * 删除学校管理
     */
    @PreAuthorize("@ss.hasPermi('service:university:remove')")
    @Log(title = "学校管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{universityIds}")
    public AjaxResult remove(@PathVariable Long[] universityIds)
    {
        return toAjax(universityService.deleteUniversityByIds(universityIds));
    }
}
