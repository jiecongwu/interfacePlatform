package io.renren.modules.autotest.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 测试案例步骤表
 * 
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2020-01-09 22:42:21
 */
@TableName("auto_step")
public class AutoStepEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long stepId;
	/**
	 * 父案例id,关联auto_project
	 */
	private Long projectId;
	/**
	 * 识别方法/接口名称
	 */
	private String findBy;
	/**
	 * 识别内容/接口实例
	 */
	private String findContent;
	/**
	 * 操作类型id
	 */
	private Long opId;
	/**
	 * 操作目标或预期结果
	 */
	private String opTarget;
	/**
	 * 0默认 start开始 end 结束
	 */
	private String circulation;
	/**
	 * 
	 */
	private Long createUser;
	/**
	 * 状态：1 有效；0 失效
	 */
	private String status;
	/**
	 * 类型   1：web   2：接口  
	 */
	private String type;
	/**
	 * 
	 */
	private Integer orderNum;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 描述
	 */
	private String remark;

	/**
	 * 设置：
	 */
	public void setStepId(Long stepId) {
		this.stepId = stepId;
	}
	/**
	 * 获取：
	 */
	public Long getStepId() {
		return stepId;
	}
	/**
	 * 设置：父案例id,关联auto_project
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	/**
	 * 获取：父案例id,关联auto_project
	 */
	public Long getProjectId() {
		return projectId;
	}
	/**
	 * 设置：识别方法/接口名称
	 */
	public void setFindBy(String findBy) {
		this.findBy = findBy;
	}
	/**
	 * 获取：识别方法/接口名称
	 */
	public String getFindBy() {
		return findBy;
	}
	/**
	 * 设置：识别内容/接口实例
	 */
	public void setFindContent(String findContent) {
		this.findContent = findContent;
	}
	/**
	 * 获取：识别内容/接口实例
	 */
	public String getFindContent() {
		return findContent;
	}
	/**
	 * 设置：操作类型id
	 */
	public void setOpId(Long opId) {
		this.opId = opId;
	}
	/**
	 * 获取：操作类型id
	 */
	public Long getOpId() {
		return opId;
	}
	/**
	 * 设置：操作目标或预期结果
	 */
	public void setOpTarget(String opTarget) {
		this.opTarget = opTarget;
	}
	/**
	 * 获取：操作目标或预期结果
	 */
	public String getOpTarget() {
		return opTarget;
	}
	/**
	 * 设置：0默认 start开始 end 结束
	 */
	public void setCirculation(String circulation) {
		this.circulation = circulation;
	}
	/**
	 * 获取：0默认 start开始 end 结束
	 */
	public String getCirculation() {
		return circulation;
	}
	/**
	 * 设置：
	 */
	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：
	 */
	public Long getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：状态：1 有效；0 失效
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态：1 有效；0 失效
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：类型   1：web   2：接口  
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型   1：web   2：接口  
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	/**
	 * 获取：
	 */
	public Integer getOrderNum() {
		return orderNum;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：描述
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：描述
	 */
	public String getRemark() {
		return remark;
	}
}
