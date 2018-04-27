package edu.gzmu.model;

import com.baomidou.mybatisplus.annotations.TableField;
import edu.gzmu.model.base.SLPlatBaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 学校
 * </p>
 *
 * @author JiaYinWei
 * @since 2018-04-08
 */
@ApiModel("学校")
@SuppressWarnings("serial")
public class School extends SLPlatBaseModel {
    @ApiModelProperty(value = "学校概况")
	@TableField("school_profiles")
	private String schoolProfiles;

	public String getSchoolProfiles() {
		return schoolProfiles;
	}

	public void setSchoolProfiles(String schoolProfiles) {
		this.schoolProfiles = schoolProfiles;
	}

    /**
     * 返回当前对象信息的字符串表示，该信息能够直接转换成JSON数据
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(super.getSubToString());
        sb.append(", schoolProfiles=").append(schoolProfiles);
        sb.append("]");
        return sb.toString();
    }

    /**
     * 判断两个对象是否相等
     */
    @Override
    public boolean equals(Object that) {
        if (!super.equals(that)) {
            return false;
        }
        else {
            School other = (School) that;
            return (this.getSchoolProfiles() == null ? other.getSchoolProfiles() == null : this.getSchoolProfiles().equals(other.getSchoolProfiles()));
        }
    }

    /**
     * 获取当前对象的hashCode编码值
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((getSchoolProfiles() == null) ? 0 : getSchoolProfiles().hashCode());
        return result;
    }
}