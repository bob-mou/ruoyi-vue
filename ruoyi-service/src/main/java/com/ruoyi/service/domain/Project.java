package com.ruoyi.service.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 选题管理对象 project
 *
 * @author zhouq
 * @date 2021-04-08
 */
public class Project extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private String projectTypeName;

    public String getProjectTypeName() {
        return projectTypeName;
    }

    public void setProjectTypeName(String projectTypeName) {
        this.projectTypeName = projectTypeName;
    }

    /** 选题id */
    private Long projectId;

    /** 外键选题类型ID */
    @Excel(name = "外键选题类型ID")
    private Long projectTypeId;

    /** 选题名称 */
    @Excel(name = "选题名称")
    private String projectName;

    /** 选题简介 */
    @Excel(name = "选题简介")
    private String projectDetail;

    /** 涉及技术 */
    @Excel(name = "涉及技术")
    private String projectTech;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 选题状态 */
    @Excel(name = "选题状态")
    private Long state;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    public void setProjectId(Long projectId)
    {
        this.projectId = projectId;
    }

    public Long getProjectId()
    {
        return projectId;
    }
    public void setProjectTypeId(Long projectTypeId)
    {
        this.projectTypeId = projectTypeId;
    }

    public Long getProjectTypeId()
    {
        return projectTypeId;
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
    public void setProjectTech(String projectTech)
    {
        this.projectTech = projectTech;
    }

    public String getProjectTech()
    {
        return projectTech;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("projectId", getProjectId())
            .append("projectTypeId", getProjectTypeId())
            .append("projectName", getProjectName())
            .append("projectDetail", getProjectDetail())
            .append("projectTech", getProjectTech())
            .append("createDate", getCreateDate())
            .append("state", getState())
            .append("remarks", getRemarks())
            .toString();
    }
}
