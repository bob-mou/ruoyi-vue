package com.ruoyi.service.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.service.mapper.GradMapper;
import com.ruoyi.service.domain.Grad;
import com.ruoyi.service.service.IGradService;

/**
 * 研究生管理Service业务层处理
 * 
 * @author 牟连波
 * @date 2021-04-09
 */
@Service
public class GradServiceImpl implements IGradService 
{
    @Autowired
    private GradMapper gradMapper;

    /**
     * 查询研究生管理
     * 
     * @param stuId 研究生管理ID
     * @return 研究生管理
     */
    @Override
    public Grad selectGradById(Long stuId)
    {
        return gradMapper.selectGradById(stuId);
    }

    /**
     * 查询研究生管理列表
     * 
     * @param grad 研究生管理
     * @return 研究生管理
     */
    @Override
    public List<Grad> selectGradList(Grad grad)
    {
        return gradMapper.selectGradList(grad);
    }

    /**
     * 新增研究生管理
     * 
     * @param grad 研究生管理
     * @return 结果
     */
    @Override
    public int insertGrad(Grad grad)
    {
        grad.setCreateTime(DateUtils.getNowDate());
        return gradMapper.insertGrad(grad);
    }

    /**
     * 修改研究生管理
     * 
     * @param grad 研究生管理
     * @return 结果
     */
    @Override
    public int updateGrad(Grad grad)
    {
        return gradMapper.updateGrad(grad);
    }

    /**
     * 批量删除研究生管理
     * 
     * @param stuIds 需要删除的研究生管理ID
     * @return 结果
     */
    @Override
    public int deleteGradByIds(Long[] stuIds)
    {
        return gradMapper.deleteGradByIds(stuIds);
    }

    /**
     * 删除研究生管理信息
     * 
     * @param stuId 研究生管理ID
     * @return 结果
     */
    @Override
    public int deleteGradById(Long stuId)
    {
        return gradMapper.deleteGradById(stuId);
    }
}
