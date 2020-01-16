package io.renren.modules.autotest.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户与目标系统关系表
 * 
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2020-01-09 22:42:21
 */
@TableName("auto_user_project")
public class AutoUserProjectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 角色ID
	 */
	private Long projectId;
	/**
	 * 1:修改，2：查看（备用字段，现默认全修改）
	 */
	private String type;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：用户ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：角色ID
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	/**
	 * 获取：角色ID
	 */
	public Long getProjectId() {
		return projectId;
	}
	/**
	 * 设置：1:修改，2：查看（备用字段，现默认全修改）
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：1:修改，2：查看（备用字段，现默认全修改）
	 */
	public String getType() {
		return type;
	}
}
