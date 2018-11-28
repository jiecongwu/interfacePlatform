package io.renren.modules.iface.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 接口菜单路径表
 * 
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-10-19 16:16:46
 */
@TableName("interface_project_memu")
public class InterfaceProjectMemuEntity implements Serializable {
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
	 * 1系统 2模块 
	 */
	private String type;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	@TableField(exist=false)
	private String  method;
	@TableField(exist=false)
    private List  interfaceList;

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
	 * 设置：1系统 2模块 
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：1系统 2模块 
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置：名称
	 */
	public void setMethod(String method) {
		this.method = method;
	}
	/**
	 * 获取：名称
	 */
	public String getMethod() {
		return method;
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
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：接口列表
	 */
	public void setInterfaceList(List interfaceList) {
		this.interfaceList = interfaceList;
	}
	/**
	 * 获取：修改时间
	 */
	public List getInterfaceList() {
		return interfaceList;
	}
}
