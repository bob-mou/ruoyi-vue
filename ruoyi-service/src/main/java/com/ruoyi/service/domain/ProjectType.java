package com.ruoyi.service.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 选题类别管理对象 project_type
 *
 * @author zhouq
 * @date 2021-04-08
 */
public class ProjectType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 选题类型ID */
    private Long projectTypeId;

    /** 选题类型名称 */
    @Excel(name = "选题类型名称")
    private String projectTypeName;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 选题类型状态 */
    @Excel(name = "选题类型状态")
    private Long state;

    /** 备注 */
    private String remarks;

    public void setProjectTypeId(Long projectTypeId)
    {
        this.projectTypeId = projectTypeId;
    }

    public Long getProjectTypeId()
    {
        return projectTypeId;
    }
    public void setProjectTypeName(String projectTypeName)
    {
        this.projectTypeName = projectTypeName;
    }

    public String getProjectTypeName()
    {
        return projectTypeName;
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
            .append("projectTypeId", getProjectTypeId())
            .append("projectTypeName", getProjectTypeName())
            .append("createDate", getCreateDate())
            .append("state", getState())
            .append("remarks", getRemarks())
            .toString();
    }
}
