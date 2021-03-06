package com.ruoyi.service.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.service.domain.*;
import com.ruoyi.service.mapper.*;
import com.ruoyi.service.service.ISysConfigService;
import com.ruoyi.service.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(StuServiceImpl.class);
    @Autowired
    private StuMapper stuMapper;
    @Autowired
    private ISysConfigService configService;
    @Autowired
    private ISysUserService iSysUserService;
    @Autowired
    private UniversityMapper universityMapper;
    @Autowired
    private CollegeMapper collegeMapper;

    @Autowired
    private MajorMapper majorMapper;
    @Autowired
    private myClassMapper classMapper;

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
        //查看学生表是否有数据
        Stu u = stuMapper.selectStuByNum(stu.getStuNumber());
        //查看用户表是否有当前用户
        SysUser suser=iSysUserService.selectUserByUserName(stu.getStuNumber());
        //插入成功
        if(StringUtils.isNull(u)&&StringUtils.isNull(suser)){
            SysUser user=new SysUser();
            user.setUserName(stu.getStuNumber());
            user.setNickName(stu.getStuName());
            user.setRoleIds(new Long[]{3l});
            user.setEmail(stu.getStuEmail());
            user.setPhonenumber(stu.getStuPhone());
            String password = String.valueOf(stu.getStuPhone()).substring(5);
            user.setPassword(SecurityUtils.encryptPassword(password));
            int rows=stuMapper.insertStu(stu);
            //学生表插入失败
            if(rows==0){
                return -1;
            }
            int row=iSysUserService.insertUser(user);
            //用户表插入失败
            if(row==0){
                return 0;
            }
            return 1;
        }
        //插入失败
        return 0;
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

    @Override
    public String importUser(List<Stu> userList, boolean updateSupport, String operName) {
        if (StringUtils.isNull(userList) || userList.size() == 0)
        {
            throw new CustomException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (Stu stu : userList)
        {
            String password = String.valueOf(stu.getStuPhone()).substring(5);
            try
            {
                // 验证是否存在这个用户
                Stu u = stuMapper.selectStuByNum(stu.getStuNumber());
                if (StringUtils.isNull(u))
                {
                    SysUser user  = new SysUser();
                    University university = new University();
                    university.setUniversityName(stu.getUniversityName());
                    College college = new College();
                    college.setCollegeName(stu.getCollegeName());
                    Major major = new Major();
                    major.setMajorName(stu.getMajorName());
                    myClass c = new myClass();
                    c.setClassName(stu.getClassName());
                    user.setPassword(SecurityUtils.encryptPassword(password));
                    user.setUserName(stu.getStuNumber());
                    user.setNickName(stu.getStuName());
                    user.setEmail(stu.getStuEmail());
                    user.setPhonenumber(stu.getStuPhone());
                    long uid = universityMapper.selectUniversityList(university).get(0).getUniversityId();
                    college.setUniversityId(uid);
                    long cid = collegeMapper.selectCollegeList(college).get(0).getCollegeId();
                    major.setCollegeId(cid);
                    long mid = majorMapper.selectMajorList(major).get(0).getMajorId();
                    c.setMajorId(mid);
                    long id = classMapper.selectmyClassList(c).get(0).getClassId();
                    stu.setUniversityId(uid);
                    stu.setCollegeId(cid);
                    stu.setMajorId(mid);
                    stu.setClassId(id);
                    stuMapper.insertStu(stu);
                    //为学生用户分配角色
                    user.setRoleIds(new Long[]{3l});
                    iSysUserService.insertUser(user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、姓名 " + stu.getStuName() + " 导入成功");
                }
                else if (updateSupport)
                {
                    stu.setStuId(u.getStuId());
                    SysUser user  = new SysUser();
                    University university = new University();
                    university.setUniversityName(stu.getUniversityName());
                    College college = new College();
                    college.setCollegeName(stu.getCollegeName());
                    Major major = new Major();
                    major.setMajorName(stu.getMajorName());
                    myClass c = new myClass();
                    c.setClassName(stu.getClassName());
                    user.setPassword(SecurityUtils.encryptPassword(password));
                    user.setUserName(stu.getStuName());
                    user.setNickName(stu.getStuName());
                    iSysUserService.insertUser(user);
                    long uid = universityMapper.selectUniversityList(university).get(0).getUniversityId();
                    college.setUniversityId(uid);
                    long cid = collegeMapper.selectCollegeList(college).get(0).getCollegeId();
                    major.setCollegeId(cid);
                    long mid = majorMapper.selectMajorList(major).get(0).getMajorId();
                    c.setMajorId(mid);
                    long id = classMapper.selectmyClassList(c).get(0).getClassId();
                    stu.setUniversityId(uid);
                    stu.setCollegeId(cid);
                    stu.setMajorId(mid);
                    stu.setClassId(id);
                    stu.setUpdateBy(operName);
                    stuMapper.updateStu(stu);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、学号 " + stu.getStuNumber() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、姓名 " + stu.getStuName() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、姓名 " + stu.getStuName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new CustomException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
