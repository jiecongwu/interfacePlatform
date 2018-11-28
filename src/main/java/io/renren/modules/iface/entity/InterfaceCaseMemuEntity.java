package io.renren.modules.iface.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用例菜单路径表
 * 
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-11-13 11:47:48
 */
@TableName("interface_case_memu")
public class InterfaceCaseMemuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long menuId;
	/**
	 * 父菜单ID
	 */
	private Long parentId;
	/**
	 * 接口ID
	 */
	private Long infId;
	/**
	 * 1模块 2 实例
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
	private List interfaceList;
	/**
	 * 设置：
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	/**
	 * 获取：
	 */
	public Long getMenuId() {
		return menuId;
	}
	/**
	 * 设置：父菜单ID
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父菜单ID
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * 设置：父菜单ID
	 */
	public void setInfId(Long infId) {
		this.infId = infId;
	}
	/**
	 * 获取：父菜单ID
	 */
	public Long getInfId() {
		return infId;
	}
	/**
	 * 设置：1模块 2 实例
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：1模块 2 实例
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

	public void setInterfaceList(List interfaceList) {
		this.interfaceList = interfaceList;
	}

	public List getInterfaceList() {
		return interfaceList;
	}
}
