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
import com.ruoyi.service.domain.Grad;
import com.ruoyi.service.service.IGradService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 研究生管理Controller
 * 
 * @author 牟连波
 * @date 2021-04-09
 */
@RestController
@RequestMapping("/service/grad")
public class GradController extends BaseController
{
    @Autowired
    private IGradService gradService;

    /**
     * 查询研究生管理列表
     */
    @PreAuthorize("@ss.hasPermi('service:grad:list')")
    @GetMapping("/list")
    public TableDataInfo list(Grad grad)
    {
        startPage();
        List<Grad> list = gradService.selectGradList(grad);
        return getDataTable(list);
    }

    /**
     * 导出研究生管理列表
     */
    @PreAuthorize("@ss.hasPermi('service:grad:export')")
    @Log(title = "研究生管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Grad grad)
    {
        List<Grad> list = gradService.selectGradList(grad);
        ExcelUtil<Grad> util = new ExcelUtil<Grad>(Grad.class);
        return util.exportExcel(list, "grad");
    }

    /**
     * 获取研究生管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('service:grad:query')")
    @GetMapping(value = "/{stuId}")
    public AjaxResult getInfo(@PathVariable("stuId") Long stuId)
    {
        return AjaxResult.success(gradService.selectGradById(stuId));
    }

    /**
     * 新增研究生管理
     */
    @PreAuthorize("@ss.hasPermi('service:grad:add')")
    @Log(title = "研究生管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Grad grad)
    {
        return toAjax(gradService.insertGrad(grad));
    }

    /**
     * 修改研究生管理
     */
    @PreAuthorize("@ss.hasPermi('service:grad:edit')")
    @Log(title = "研究生管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Grad grad)
    {
        return toAjax(gradService.updateGrad(grad));
    }

    /**
     * 删除研究生管理
     */
    @PreAuthorize("@ss.hasPermi('service:grad:remove')")
    @Log(title = "研究生管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{stuIds}")
    public AjaxResult remove(@PathVariable Long[] stuIds)
    {
        return toAjax(gradService.deleteGradByIds(stuIds));
    }
}
