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
import com.ruoyi.service.domain.Stu;
import com.ruoyi.service.service.IStuService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生管理Controller
 * 
 * @author 牟连波
 * @date 2021-04-09
 */
@RestController
@RequestMapping("/service/stu")
public class StuController extends BaseController
{
    @Autowired
    private IStuService stuService;

    /**
     * 查询学生管理列表
     */
    @PreAuthorize("@ss.hasPermi('service:stu:list')")
    @GetMapping("/list")
    public TableDataInfo list(Stu stu)
    {
        startPage();
        List<Stu> list = stuService.selectStuList(stu);
        return getDataTable(list);
    }

    /**
     * 导出学生管理列表
     */
    @PreAuthorize("@ss.hasPermi('service:stu:export')")
    @Log(title = "学生管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Stu stu)
    {
        List<Stu> list = stuService.selectStuList(stu);
        ExcelUtil<Stu> util = new ExcelUtil<Stu>(Stu.class);
        return util.exportExcel(list, "stu");
    }

    /**
     * 获取学生管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('service:stu:query')")
    @GetMapping(value = "/{stuId}")
    public AjaxResult getInfo(@PathVariable("stuId") Long stuId)
    {
        return AjaxResult.success(stuService.selectStuById(stuId));
    }

    /**
     * 新增学生管理
     */
    @PreAuthorize("@ss.hasPermi('service:stu:add')")
    @Log(title = "学生管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Stu stu)
    {
        return toAjax(stuService.insertStu(stu));
    }

    /**
     * 修改学生管理
     */
    @PreAuthorize("@ss.hasPermi('service:stu:edit')")
    @Log(title = "学生管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Stu stu)
    {
        return toAjax(stuService.updateStu(stu));
    }

    /**
     * 删除学生管理
     */
    @PreAuthorize("@ss.hasPermi('service:stu:remove')")
    @Log(title = "学生管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{stuIds}")
    public AjaxResult remove(@PathVariable Long[] stuIds)
    {
        return toAjax(stuService.deleteStuByIds(stuIds));
    }
}
