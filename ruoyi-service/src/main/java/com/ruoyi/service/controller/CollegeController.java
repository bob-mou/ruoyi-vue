package com.ruoyi.service.controller;

import java.util.List;

import com.ruoyi.service.service.IUniversityService;
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
import com.ruoyi.service.domain.College;
import com.ruoyi.service.service.ICollegeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学院管理Controller
 *
 * @author 牟连波
 * @date 2021-04-09
 */
@RestController
@RequestMapping("/service/collage")
public class CollegeController extends BaseController
{
    @Autowired
    private ICollegeService collegeService;
    @Autowired
    private IUniversityService universityService;

    /**
     * 查询学院管理列表
     */
    @PreAuthorize("@ss.hasPermi('service:collage:list')")
    @GetMapping("/list")
    public TableDataInfo list(College college)
    {
        startPage();
        List<College> list = collegeService.selectCollegeList(college);
        return getDataTable(list);
    }
    /**查询所有的学院
     *
     * */
    @PreAuthorize("@ss.hasPermi('service:collage:list')")
    @GetMapping("/collegelist")
    public List<College> collegeList(College college)
    {
        List<College> list = collegeService.selectCollegeList(college);
        return list;
    }

    /**
     * 导出学院管理列表
     */
    @PreAuthorize("@ss.hasPermi('service:collage:export')")
    @Log(title = "学院管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(College college)
    {
        List<College> list = collegeService.selectCollegeList(college);
        ExcelUtil<College> util = new ExcelUtil<College>(College.class);
        return util.exportExcel(list, "collage");
    }

    /**
     * 获取学院管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('service:collage:query')")
    @GetMapping(value = "/{collegeId}")
    public AjaxResult getInfo(@PathVariable("collegeId") Long collegeId)
    {
        return AjaxResult.success(collegeService.selectCollegeById(collegeId));
    }

    /**
     * 新增学院管理
     */
    @PreAuthorize("@ss.hasPermi('service:collage:add')")
    @Log(title = "学院管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody College college)
    {
        return toAjax(collegeService.insertCollege(college));
    }

    /**
     * 修改学院管理
     */
    @PreAuthorize("@ss.hasPermi('service:collage:edit')")
    @Log(title = "学院管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody College college)
    {
        return toAjax(collegeService.updateCollege(college));
    }

    /**
     * 删除学院管理
     */
    @PreAuthorize("@ss.hasPermi('service:collage:remove')")
    @Log(title = "学院管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{collegeIds}")
    public AjaxResult remove(@PathVariable Long[] collegeIds)
    {
        return toAjax(collegeService.deleteCollegeByIds(collegeIds));
    }
}
