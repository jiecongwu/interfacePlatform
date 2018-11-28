package io.renren.modules.iface.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 接口请求头信息表
 * 
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-08-24 16:42:36
 */
@TableName("interface_head")
public class InterfaceHeadEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long headId;
	/**
	 * 接口id
	 */
	private Long infId;
	/**
	 * 请求头名称
	 */
	private String name;
	/**
	 * 请求头的具体值
	 */
	private String value;

	/**
	 * 设置：
	 */
	public void setHeadId(Long headId) {
		this.headId = headId;
	}
	/**
	 * 获取：
	 */
	public Long getHeadId() {
		return headId;
	}
	/**
	 * 设置：接口id
	 */
	public void setInfId(Long infId) {
		this.infId = infId;
	}
	/**
	 * 获取：接口id
	 */
	public Long getInfId() {
		return infId;
	}
	/**
	 * 设置：请求头名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：请求头名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：请求头的具体值
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * 获取：请求头的具体值
	 */
	public String getValue() {
		return value;
	}
}
