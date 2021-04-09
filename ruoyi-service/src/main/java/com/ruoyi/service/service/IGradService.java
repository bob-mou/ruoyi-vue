package com.ruoyi.service.service;

import java.util.List;
import com.ruoyi.service.domain.Grad;

/**
 * 研究生管理Service接口
 * 
 * @author 牟连波
 * @date 2021-04-09
 */
public interface IGradService 
{
    /**
     * 查询研究生管理
     * 
     * @param stuId 研究生管理ID
     * @return 研究生管理
     */
    public Grad selectGradById(Long stuId);

    /**
     * 查询研究生管理列表
     * 
     * @param grad 研究生管理
     * @return 研究生管理集合
     */
    public List<Grad> selectGradList(Grad grad);

    /**
     * 新增研究生管理
     * 
     * @param grad 研究生管理
     * @return 结果
     */
    public int insertGrad(Grad grad);

    /**
     * 修改研究生管理
     * 
     * @param grad 研究生管理
     * @return 结果
     */
    public int updateGrad(Grad grad);

    /**
     * 批量删除研究生管理
     * 
     * @param stuIds 需要删除的研究生管理ID
     * @return 结果
     */
    public int deleteGradByIds(Long[] stuIds);

    /**
     * 删除研究生管理信息
     * 
     * @param stuId 研究生管理ID
     * @return 结果
     */
    public int deleteGradById(Long stuId);
}
