package io.renren.modules.iface.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 接口信息表
 * 
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-10-19 16:16:47
 */
@TableName("interface_project_user")
public class InterfaceProjectUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 无意义主键
	 */
	@TableId
	private Long infProId;
	/**
	 * 系统模块id
	 */
	private Long projectId;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 *  1：管理员 ，0：查看级别用户
	 */
	private String roleType;
	/**
	 * 创建人id
	 */
	private Date createUserId;

	/**
	 * 设置：无意义主键
	 */
	public void setInfProId(Long infProId) {
		this.infProId = infProId;
	}
	/**
	 * 获取：无意义主键
	 */
	public Long getInfProId() {
		return infProId;
	}
	/**
	 * 设置：系统模块id
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	/**
	 * 获取：系统模块id
	 */
	public Long getProjectId() {
		return projectId;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置： 1：管理员 ，0：查看级别用户
	 */
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	/**
	 * 获取： 1：管理员 ，0：查看级别用户
	 */
	public String getRoleType() {
		return roleType;
	}
	/**
	 * 设置：创建人id
	 */
	public void setCreateUserId(Date createUserId) {
		this.createUserId = createUserId;
	}
	/**
	 * 获取：创建人id
	 */
	public Date getCreateUserId() {
		return createUserId;
	}
}
