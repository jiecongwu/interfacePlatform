package io.renren.modules.iface.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统级接口请求头信息表
 * 
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-08-24 16:42:37
 */
@TableName("interface_sys_head")
public class InterfaceSysHeadEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long sysHeadId;
	/**
	 * 0:系统级别,1:模块级别
	 */
	private String type;
	/**
	 * 
	 */
	private Long sysId;
	/**
	 * 请求头名称
	 */
	private String paramName;
	/**
	 * 请求头的具体值
	 */
	private String paramValue;

	/**
	 * 设置：
	 */
	public void setSysHeadId(Long sysHeadId) {
		this.sysHeadId = sysHeadId;
	}
	/**
	 * 获取：
	 */
	public Long getSysHeadId() {
		return sysHeadId;
	}
	/**
	 * 设置：0:系统级别,1:模块级别
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：0:系统级别,1:模块级别
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：
	 */
	public void setSysId(Long sysId) {
		this.sysId = sysId;
	}
	/**
	 * 获取：
	 */
	public Long getSysId() {
		return sysId;
	}
	/**
	 * 设置：请求头名称
	 */
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	/**
	 * 获取：请求头名称
	 */
	public String getParamName() {
		return paramName;
	}
	/**
	 * 设置：请求头的具体值
	 */
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	/**
	 * 获取：请求头的具体值
	 */
	public String getParamValue() {
		return paramValue;
	}
}
