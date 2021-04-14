package com.ruoyi.service.controller;

import java.io.IOException;
import java.util.List;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.web.service.TokenService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.service.domain.University;
import com.ruoyi.service.service.IUniversityService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

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

    @Autowired
    private TokenService tokenService;

    /**
     * 学校logo
     */
    @Log(title = "学校logo", businessType = BusinessType.UPDATE)
    @PostMapping("/logos")
    public AjaxResult avatar(@RequestParam("avatarfile") MultipartFile file) throws IOException
    {
        if (!file.isEmpty())
        {
            LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
            String avatar = FileUploadUtils.upload(RuoYiConfig.getAvatarPath(), file);
//            if (userService.updateUserAvatar(loginUser.getUsername(), avatar))
                AjaxResult ajax = AjaxResult.success();
                ajax.put("imgUrl", avatar);
                tokenService.setLoginUser(loginUser);
                return ajax;
        }
        return AjaxResult.error("上传图片异常，请联系管理员");
    }

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
        return AjaxResult.success(universityService.selectUniversityById(universityId));
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
