package io.renren.modules.iface.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 接口实体参数表
 * 
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-08-24 16:42:37
 */
@TableName("interface_param")
public class InterfaceParamEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long paramId;
	/**
	 * 接口id
	 */
	private Long infId;
	/**
	 * 是否必填，1：是，0：否
	 */
	private String isRequired;
	/**
	 * 依赖其他字段必填，字段名多个用逗号分隔
	 */
	private String requiredByParam;
	/**
	 * 父节点
	 */
	private String paramParent;
	/**
	 * 树结构路径
	 */
	private String paramPath;
	/**
	 * 参数的加密方式
	 */
	private String ecodeType;
	/**
	 * 加密盐
	 */
	private String ecodeSalt;
	/**
	 * 加密需要传入的参数（一般支付类使用）
	 */
	private String ecodeParam;

	/**
	 * 设置：
	 */
	public void setParamId(Long paramId) {
		this.paramId = paramId;
	}
	/**
	 * 获取：
	 */
	public Long getParamId() {
		return paramId;
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
	 * 设置：是否必填，1：是，0：否
	 */
	public void setIsRequired(String isRequired) {
		this.isRequired = isRequired;
	}
	/**
	 * 获取：是否必填，1：是，0：否
	 */
	public String getIsRequired() {
		return isRequired;
	}
	/**
	 * 设置：依赖其他字段必填，字段名多个用逗号分隔
	 */
	public void setRequiredByParam(String requiredByParam) {
		this.requiredByParam = requiredByParam;
	}
	/**
	 * 获取：依赖其他字段必填，字段名多个用逗号分隔
	 */
	public String getRequiredByParam() {
		return requiredByParam;
	}
	/**
	 * 设置：父节点
	 */
	public void setParamParent(String paramParent) {
		this.paramParent = paramParent;
	}
	/**
	 * 获取：父节点
	 */
	public String getParamParent() {
		return paramParent;
	}
	/**
	 * 设置：树结构路径
	 */
	public void setParamPath(String paramPath) {
		this.paramPath = paramPath;
	}
	/**
	 * 获取：树结构路径
	 */
	public String getParamPath() {
		return paramPath;
	}
	/**
	 * 设置：参数的加密方式
	 */
	public void setEcodeType(String ecodeType) {
		this.ecodeType = ecodeType;
	}
	/**
	 * 获取：参数的加密方式
	 */
	public String getEcodeType() {
		return ecodeType;
	}
	/**
	 * 设置：加密盐
	 */
	public void setEcodeSalt(String ecodeSalt) {
		this.ecodeSalt = ecodeSalt;
	}
	/**
	 * 获取：加密盐
	 */
	public String getEcodeSalt() {
		return ecodeSalt;
	}
	/**
	 * 设置：加密需要传入的参数（一般支付类使用）
	 */
	public void setEcodeParam(String ecodeParam) {
		this.ecodeParam = ecodeParam;
	}
	/**
	 * 获取：加密需要传入的参数（一般支付类使用）
	 */
	public String getEcodeParam() {
		return ecodeParam;
	}
}
