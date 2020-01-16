package io.renren.modules.autotest.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目用例总表
 * 
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2020-01-09 22:42:21
 */
@TableName("auto_project")
public class AutoProjectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long projectId;
	/**
	 * 父菜单ID，一级菜单为0
	 */
	private Long parentId;
	/**
	 * 
	 */
	private String name;
	/**
	 * 用列的方法名
	 */
	private String mname;
	/**
	 * 类型   0：系统   1：模块   2：用列集 3：接口
	 */
	private Integer type;
	/**
	 * 树路径，权限过滤使用，每节点3位
	 */
	private String pathCode;
	/**
	 * 状态：1 有效；0 失效
	 */
	private String status;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Long createUser;
	/**
	 * 
	 */
	private Integer orderNum;

	/**
	 * 设置：
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	/**
	 * 获取：
	 */
	public Long getProjectId() {
		return projectId;
	}
	/**
	 * 设置：父菜单ID，一级菜单为0
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父菜单ID，一级菜单为0
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：用列的方法名
	 */
	public void setMname(String mname) {
		this.mname = mname;
	}
	/**
	 * 获取：用列的方法名
	 */
	public String getMname() {
		return mname;
	}
	/**
	 * 设置：类型   0：系统   1：模块   2：用列集 3：接口
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型   0：系统   1：模块   2：用列集 3：接口
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：树路径，权限过滤使用，每节点3位
	 */
	public void setPathCode(String pathCode) {
		this.pathCode = pathCode;
	}
	/**
	 * 获取：树路径，权限过滤使用，每节点3位
	 */
	public String getPathCode() {
		return pathCode;
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
}
