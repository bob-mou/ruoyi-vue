package com.ruoyi.service.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
d * 学生表对象 stu
 *
 * @author 牟连波
 * @date 2021-04-09
 */
public class Stu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自然主键，学生id */
    private Long stuId;

    /** 学生学号 */
    @Excel(name = "学号")
    private String stuNumber;

    /** 所属班级ID */
    @Excel(name = "班级")
    private String className;

    private Long classId;

    /** 所属专业ID */
    @Excel(name = "专业")
    private String majorName;

    private Long majorId;

    /** 所属学院ID */
    @Excel(name = "学院")
    private String collegeName;

    private Long collegeId;

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    /** 所属学校ID */
    @Excel(name = "学校")
    private String universityName;

    private Long universityId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    /** 学校类型 */
    @Excel(name = "学校类型")
    private String schoolType;

    /** 毕设名称 */
    @Excel(name = "毕设名称")
    private String projectName;

    /** 毕设描述 */
    @Excel(name = "毕设描述")
    private String projectDetail;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String stuName;

    /** 学生手机号 */
    @Excel(name = "学生手机号")
    private String stuPhone;

    /** 学生QQ号 */
    @Excel(name = "学生QQ号")
    private String stuQq;

    /** 学生邮箱 */
    @Excel(name = "学生邮箱")
    private String stuEmail;

    /** 学历 */
    @Excel(name = "学历")
    private Integer stuEducation;

    /** 学生状态 */
    @Excel(name = "学生状态")
    private Integer state;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    public void setStuId(Long stuId)
    {
        this.stuId = stuId;
    }

    public Long getStuId()
    {
        return stuId;
    }
    public void setStuNumber(String stuNumber)
    {
        this.stuNumber = stuNumber;
    }

    public String getStuNumber()
    {
        return stuNumber;
    }
    public void setClassId(Long classId)
    {
        this.classId = classId;
    }

    public Long getClassId()
    {
        return classId;
    }
    public void setMajorId(Long majorId)
    {
        this.majorId = majorId;
    }

    public Long getMajorId()
    {
        return majorId;
    }
    public void setCollegeId(Long collegeId)
    {
        this.collegeId = collegeId;
    }

    public Long getCollegeId()
    {
        return collegeId;
    }
    public void setUniversityId(Long universityId)
    {
        this.universityId = universityId;
    }

    public Long getUniversityId()
    {
        return universityId;
    }
    public void setSchoolType(String schoolType)
    {
        this.schoolType = schoolType;
    }

    public String getSchoolType()
    {
        return schoolType;
    }
    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String getProjectName()
    {
        return projectName;
    }
    public void setProjectDetail(String projectDetail)
    {
        this.projectDetail = projectDetail;
    }

    public String getProjectDetail()
    {
        return projectDetail;
    }
    public void setStuName(String stuName)
    {
        this.stuName = stuName;
    }

    public String getStuName()
    {
        return stuName;
    }
    public void setStuPhone(String stuPhone)
    {
        this.stuPhone = stuPhone;
    }

    public String getStuPhone()
    {
        return stuPhone;
    }
    public void setStuQq(String stuQq)
    {
        this.stuQq = stuQq;
    }

    public String getStuQq()
    {
        return stuQq;
    }
    public void setStuEmail(String stuEmail)
    {
        this.stuEmail = stuEmail;
    }

    public String getStuEmail()
    {
        return stuEmail;
    }
    public void setStuEducation(Integer stuEducation)
    {
        this.stuEducation = stuEducation;
    }

    public Integer getStuEducation()
    {
        return stuEducation;
    }
    public void setState(Integer state)
    {
        this.state = state;
    }

    public Integer getState()
    {
        return state;
    }
    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    public String getRemarks()
    {
        return remarks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("stuId", getStuId())
            .append("stuNumber", getStuNumber())
            .append("classId", getClassId())
            .append("className",getClassName())
            .append("majorId", getMajorId())
            .append("majorName",getMajorName())
            .append("collegeId", getCollegeId())
            .append("collegeName",getCollegeName())
            .append("universityId", getUniversityId())
            .append("schoolType", getSchoolType())
            .append("projectName", getProjectName())
            .append("projectDetail", getProjectDetail())
            .append("universityName",getUniversityName())
            .append("stuName", getStuName())
            .append("stuPhone", getStuPhone())
            .append("stuQq", getStuQq())
            .append("stuEmail", getStuEmail())
            .append("stuEducation", getStuEducation())
            .append("createTime", getCreateTime())
            .append("state", getState())
            .append("remarks", getRemarks())
            .toString();
    }
}
