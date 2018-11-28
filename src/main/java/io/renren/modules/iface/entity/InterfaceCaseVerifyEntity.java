package io.renren.modules.iface.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 接口案例验证实例表
 * 
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-08-24 16:42:37
 */
@TableName("interface_case_verify")
public class InterfaceCaseVerifyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long verifyId;
	/**
	 * 案例id
	 */
	private Long caseId;
	/**
	 * 0：http状态码，1：包含，2：等于，3：数据库验证
	 */
	private String verifyType;
	/**
	 * 需要数据库验证的数据库id
	 */
	private Long databaseId;
	/**
	 * 验证体
	 */
	private String verifyBody;
	/**
	 * 验证排序
	 */
	private Integer sortNum;
	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 设置：
	 */
	public void setVerifyId(Long verifyId) {
		this.verifyId = verifyId;
	}
	/**
	 * 获取：
	 */
	public Long getVerifyId() {
		return verifyId;
	}
	/**
	 * 设置：案例id
	 */
	public void setCaseId(Long caseId) {
		this.caseId = caseId;
	}
	/**
	 * 获取：案例id
	 */
	public Long getCaseId() {
		return caseId;
	}
	/**
	 * 设置：0：http状态码，1：包含，2：等于，3：数据库验证
	 */
	public void setVerifyType(String verifyType) {
		this.verifyType = verifyType;
	}
	/**
	 * 获取：0：http状态码，1：包含，2：等于，3：数据库验证
	 */
	public String getVerifyType() {
		return verifyType;
	}
	/**
	 * 设置：需要数据库验证的数据库id
	 */
	public void setDatabaseId(Long databaseId) {
		this.databaseId = databaseId;
	}
	/**
	 * 获取：需要数据库验证的数据库id
	 */
	public Long getDatabaseId() {
		return databaseId;
	}
	/**
	 * 设置：验证体
	 */
	public void setVerifyBody(String verifyBody) {
		this.verifyBody = verifyBody;
	}
	/**
	 * 获取：验证体
	 */
	public String getVerifyBody() {
		return verifyBody;
	}
	/**
	 * 设置：验证排序
	 */
	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}
	/**
	 * 获取：验证排序
	 */
	public Integer getSortNum() {
		return sortNum;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
}
