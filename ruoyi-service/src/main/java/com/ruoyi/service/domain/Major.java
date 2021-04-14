package com.ruoyi.service.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 专业管理对象 major
 *
 * @author XD
 * @date 2021-04-09
 */
public class Major extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 专业id */
    private Long majorId;

    /** 专业名称 */
    @Excel(name = "专业名称")
    private String majorName;

    /** 外键学院ID */
    @Excel(name = "外键学校ID")
    private Long universityId;

    private String universityName;
    /** 外键学院ID */
    @Excel(name = "外键学院ID")
    private Long collegeId;

    private String collegeName;
    /** 创建时间 */
    private Date createDate;

    /** 专业状态 */
    @Excel(name = "专业状态")
    private Long state;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 班级管理信息 */
    private List<myClass> myClassList;

    public void setMajorId(Long majorId)
    {
        this.majorId = majorId;
    }

    public Long getMajorId()
    {
        return majorId;
    }
    public void setMajorName(String majorName)
    {
        this.majorName = majorName;
    }

    public String getMajorName()
    {
        return majorName;
    }
    public void setCollegeId(Long collegeId)
    {
        this.collegeId = collegeId;
    }

    public Long getCollegeId()
    {
        return collegeId;
    }
    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public Date getCreateDate()
    {
        return createDate;
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

    public List<myClass> getmyClassList()
    {
        return myClassList;
    }

    public void setmyClassList(List<myClass> myClassList)
    {
        this.myClassList = myClassList;
    }

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("majorId", getMajorId())
            .append("majorName", getMajorName())
            .append("universityId", getUniversityId())
            .append("universityName", getUniversityName())
            .append("collegeId", getCollegeId())
            .append("collegeName", getCollegeName())
            .append("createDate", getCreateDate())
            .append("state", getState())
            .append("remarks", getRemarks())
            .append("myClassList", getmyClassList())
            .toString();
    }
}
