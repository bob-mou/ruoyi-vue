package com.ruoyi.service.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.service.mapper.StuMapper;
import com.ruoyi.service.domain.Stu;
import com.ruoyi.service.service.IStuService;

/**
 * 学生表Service业务层处理
 * 
 * @author 牟连波
 * @date 2021-04-09
 */
@Service
public class StuServiceImpl implements IStuService 
{
    @Autowired
    private StuMapper stuMapper;

    /**
     * 查询学生表
     * 
     * @param stuId 学生表ID
     * @return 学生表
     */
    @Override
    public Stu selectStuById(Long stuId)
    {
        return stuMapper.selectStuById(stuId);
    }

    /**
     * 查询学生表列表
     * 
     * @param stu 学生表
     * @return 学生表
     */
    @Override
    public List<Stu> selectStuList(Stu stu)
    {
        return stuMapper.selectStuList(stu);
    }

    /**
     * 新增学生表
     * 
     * @param stu 学生表
     * @return 结果
     */
    @Override
    public int insertStu(Stu stu)
    {
        stu.setCreateTime(DateUtils.getNowDate());
        return stuMapper.insertStu(stu);
    }

    /**
     * 修改学生表
     * 
     * @param stu 学生表
     * @return 结果
     */
    @Override
    public int updateStu(Stu stu)
    {
        return stuMapper.updateStu(stu);
    }

    /**
     * 批量删除学生表
     * 
     * @param stuIds 需要删除的学生表ID
     * @return 结果
     */
    @Override
    public int deleteStuByIds(Long[] stuIds)
    {
        return stuMapper.deleteStuByIds(stuIds);
    }

    /**
     * 删除学生表信息
     * 
     * @param stuId 学生表ID
     * @return 结果
     */
    @Override
    public int deleteStuById(Long stuId)
    {
        return stuMapper.deleteStuById(stuId);
    }
}
