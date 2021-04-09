package com.ruoyi.service.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 研究生管理对象 grad
 * 
 * @author 牟连波
 * @date 2021-04-09
 */
public class Grad extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自然主键，学生id */
    private Long stuId;

    /** 所属班级ID */
    @Excel(name = "所属班级ID")
    private Long classId;

    /** 所属专业ID */
    @Excel(name = "所属专业ID")
    private Long majorId;

    /** 所属学院ID */
    @Excel(name = "所属学院ID")
    private Long collegeId;

    /** 所属学校ID */
    @Excel(name = "所属学校ID")
    private Long universityId;

    /** 本科学校 */
    @Excel(name = "本科学校")
    private String undergraduateSchool;

    /** 本科学校类型（985/211） */
    @Excel(name = "本科学校类型", readConverterExp = "9=85/211")
    private String undergraduateSchoolType;

    /** 本科专业 */
    @Excel(name = "本科专业")
    private String undergraduateMajor;

    /** 本科毕业设计题目 */
    @Excel(name = "本科毕业设计题目")
    private String graduationProjectTitle;

    /** 本科毕业设计描述 */
    @Excel(name = "本科毕业设计描述")
    private String graduationProjectDetail;

    /** 学生状态 */
    @Excel(name = "学生状态")
    private Long state;

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
    public void setUndergraduateSchool(String undergraduateSchool) 
    {
        this.undergraduateSchool = undergraduateSchool;
    }

    public String getUndergraduateSchool() 
    {
        return undergraduateSchool;
    }
    public void setUndergraduateSchoolType(String undergraduateSchoolType) 
    {
        this.undergraduateSchoolType = undergraduateSchoolType;
    }

    public String getUndergraduateSchoolType() 
    {
        return undergraduateSchoolType;
    }
    public void setUndergraduateMajor(String undergraduateMajor) 
    {
        this.undergraduateMajor = undergraduateMajor;
    }

    public String getUndergraduateMajor() 
    {
        return undergraduateMajor;
    }
    public void setGraduationProjectTitle(String graduationProjectTitle) 
    {
        this.graduationProjectTitle = graduationProjectTitle;
    }

    public String getGraduationProjectTitle() 
    {
        return graduationProjectTitle;
    }
    public void setGraduationProjectDetail(String graduationProjectDetail) 
    {
        this.graduationProjectDetail = graduationProjectDetail;
    }

    public String getGraduationProjectDetail() 
    {
        return graduationProjectDetail;
    }
    public void setState(Long state) 
    {
        this.state = state;
    }

    public Long getState() 
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
            .append("classId", getClassId())
            .append("majorId", getMajorId())
            .append("collegeId", getCollegeId())
            .append("universityId", getUniversityId())
            .append("undergraduateSchool", getUndergraduateSchool())
            .append("undergraduateSchoolType", getUndergraduateSchoolType())
            .append("undergraduateMajor", getUndergraduateMajor())
            .append("graduationProjectTitle", getGraduationProjectTitle())
            .append("graduationProjectDetail", getGraduationProjectDetail())
            .append("createTime", getCreateTime())
            .append("state", getState())
            .append("remarks", getRemarks())
            .toString();
    }
}
