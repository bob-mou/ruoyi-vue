package com.ruoyi.service.controller;

import java.util.List;

import com.ruoyi.service.service.ICollegeService;
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
import com.ruoyi.service.domain.Major;
import com.ruoyi.service.service.IMajorService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 专业管理Controller
 *
 * @author XD
 * @date 2021-04-09
 */
@RestController
@RequestMapping("/service/major")
public class MajorController extends BaseController
{
    @Autowired
    private IMajorService majorService;

    @Autowired
    private ICollegeService collegeService;
    /**
     * 查询专业管理列表
     */
    @PreAuthorize("@ss.hasPermi('service:major:list')")
    @GetMapping("/list")
    public TableDataInfo list(Major major)
    {
        startPage();
        List<Major> list = majorService.selectMajorList(major);
        return getDataTable(list);
    }

    /**
     * 导出专业管理列表
     */
    @PreAuthorize("@ss.hasPermi('service:major:export')")
    @Log(title = "专业管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Major major)
    {
        List<Major> list = majorService.selectMajorList(major);
        ExcelUtil<Major> util = new ExcelUtil<Major>(Major.class);
        return util.exportExcel(list, "major");
    }

    /**
     * 获取专业管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('service:major:query')")
    @GetMapping(value = "/{majorId}")
    public AjaxResult getInfo(@PathVariable("majorId") Long majorId)
    {
        Major major=majorService.selectMajorById(majorId);
        Long universityId=collegeService.selectCollegeById(major.getCollegeId()).getUniversityId();
        major.setUniversityId(universityId);
        return AjaxResult.success(major);
    }

    /**
     * 新增专业管理
     */
    @PreAuthorize("@ss.hasPermi('service:major:add')")
    @Log(title = "专业管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Major major)
    {
        return toAjax(majorService.insertMajor(major));
    }

    /**
     * 修改专业管理
     */
    @PreAuthorize("@ss.hasPermi('service:major:edit')")
    @Log(title = "专业管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Major major)
    {
        return toAjax(majorService.updateMajor(major));
    }

    /**
     * 删除专业管理
     */
    @PreAuthorize("@ss.hasPermi('service:major:remove')")
    @Log(title = "专业管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{majorIds}")
    public AjaxResult remove(@PathVariable Long[] majorIds)
    {
        return toAjax(majorService.deleteMajorByIds(majorIds));
    }
}
