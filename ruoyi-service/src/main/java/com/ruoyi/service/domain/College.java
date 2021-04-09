package com.ruoyi.service.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学院管理对象 college
 * 
 * @author 牟连波
 * @date 2021-04-09
 */
public class College extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学院ID */
    private Long collegeId;

    /** 学院名 */
    @Excel(name = "学院名")
    private String collegeName;

    /** 外键学校ID */
    @Excel(name = "外键学校ID")
    private Long universityId;

    /** 学校状态 */
    @Excel(name = "学校状态")
    private Long state;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 专业管理信息 */
    private List<Major> majorList;

    public void setCollegeId(Long collegeId) 
    {
        this.collegeId = collegeId;
    }

    public Long getCollegeId() 
    {
        return collegeId;
    }
    public void setCollegeName(String collegeName) 
    {
        this.collegeName = collegeName;
    }

    public String getCollegeName() 
    {
        return collegeName;
    }
    public void setUniversityId(Long universityId) 
    {
        this.universityId = universityId;
    }

    public Long getUniversityId() 
    {
        return universityId;
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

    public List<Major> getMajorList()
    {
        return majorList;
    }

    public void setMajorList(List<Major> majorList)
    {
        this.majorList = majorList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("collegeId", getCollegeId())
            .append("collegeName", getCollegeName())
            .append("universityId", getUniversityId())
            .append("createTime", getCreateTime())
            .append("state", getState())
            .append("remarks", getRemarks())
            .append("majorList", getMajorList())
            .toString();
    }
}
