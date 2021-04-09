package com.ruoyi.service.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学校管理对象 university
 * 
 * @author ruoyi
 * @date 2021-04-09
 */
public class University extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学校ID */
    private Long universityId;

    /** 学校名 */
    @Excel(name = "学校名")
    private String universityName;

    /** 学校logo */
    @Excel(name = "学校logo")
    private String logoPath;

    /** 学校地址 */
    @Excel(name = "学校地址")
    private String address;

    /** 学校状态 */
    @Excel(name = "学校状态")
    private Long state;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 学院管理信息 */
    private List<College> collegeList;

    public void setUniversityId(Long universityId) 
    {
        this.universityId = universityId;
    }

    public Long getUniversityId() 
    {
        return universityId;
    }
    public void setUniversityName(String universityName) 
    {
        this.universityName = universityName;
    }

    public String getUniversityName() 
    {
        return universityName;
    }
    public void setLogoPath(String logoPath) 
    {
        this.logoPath = logoPath;
    }

    public String getLogoPath() 
    {
        return logoPath;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
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

    public List<College> getCollegeList()
    {
        return collegeList;
    }

    public void setCollegeList(List<College> collegeList)
    {
        this.collegeList = collegeList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("universityId", getUniversityId())
            .append("universityName", getUniversityName())
            .append("logoPath", getLogoPath())
            .append("address", getAddress())
            .append("createTime", getCreateTime())
            .append("state", getState())
            .append("remarks", getRemarks())
            .append("collegeList", getCollegeList())
            .toString();
    }
}
