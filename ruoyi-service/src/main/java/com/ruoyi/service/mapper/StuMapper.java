package com.ruoyi.service.mapper;

import java.util.List;
import com.ruoyi.service.domain.Stu;

/**
 * 学生表Mapper接口
 *
 * @author 牟连波
 * @date 2021-04-09
 */
public interface StuMapper
{
    /**
     * 查询学生表
     *
     * @param stuId 学生表ID
     * @return 学生表
     */
    public Stu selectStuById(Long stuId);

    /**
     * 查询学生表列表
     *
     * @param stu 学生表
     * @return 学生表集合
     */
    public List<Stu> selectStuList(Stu stu);

    /**
     * 新增学生表
     *
     * @param stu 学生表
     * @return 结果
     */
    public int insertStu(Stu stu);

    /**
     * 修改学生表
     *
     * @param stu 学生表
     * @return 结果
     */
    public int updateStu(Stu stu);

    /**
     * 删除学生表
     *
     * @param stuId 学生表ID
     * @return 结果
     */
    public int deleteStuById(Long stuId);

    /**
     * 批量删除学生表
     *
     * @param stuIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteStuByIds(Long[] stuIds);

    public Stu selectStuByName(String stuName);

    public Stu selectStuByNum(String stuNumber);
}
