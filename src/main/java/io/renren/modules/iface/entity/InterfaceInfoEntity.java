package io.renren.modules.iface.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 接口信息表
 * 
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-10-22 17:41:27
 */
@TableName("interface_info")
public class InterfaceInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 接口id
	 */
	@TableId
	private Long infId;
	/**
	 * 接口名称
	 */
	private String infName;
	/**
	 * 接口归属模块
	 */
	private Long projectId;
	/**
	 * 请求方法
	 */
	private String infMethod;
	/**
	 * 接口url
	 */
	private String infUrl;
	/**
	 * 是否加密 1：加密 ，0非加密
	 */
	private String isEncode;
	/**
	 * 加密类型id
	 */
	private Long encodeId;
	/**
	 * 创建人id
	 */
	private Date userId;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 请求头列表
	 */
	/**
	 * 域名
	 */
	private String baseurl;
	/**
	 * url带的参数
	 */
	private String urlParma;
	/**
	 * 角色ID列表
	 */
	@TableField(exist=false)
	private List<InterfaceHeadEntity> head;

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
	 * 设置：接口名称
	 */
	public void setInfName(String infName) {
		this.infName = infName;
	}
	/**
	 * 获取：接口名称
	 */
	public String getInfName() {
		return infName;
	}
	/**
	 * 设置：接口归属模块
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	/**
	 * 获取：接口归属模块
	 */
	public Long getProjectId() {
		return projectId;
	}
	/**
	 * 设置：请求方法
	 */
	public void setInfMethod(String infMethod) {
		this.infMethod = infMethod;
	}
	/**
	 * 获取：请求方法
	 */
	public String getInfMethod() {
		return infMethod;
	}
	/**
	 * 设置：接口url
	 */
	public void setInfUrl(String infUrl) {
		this.infUrl = infUrl;
	}
	/**
	 * 获取：接口url
	 */
	public String getInfUrl() {
		return infUrl;
	}
	/**
	 * 设置：是否加密 1：加密 ，0非加密
	 */
	public void setIsEncode(String isEncode) {
		this.isEncode = isEncode;
	}
	/**
	 * 获取：是否加密 1：加密 ，0非加密
	 */
	public String getIsEncode() {
		return isEncode;
	}
	/**
	 * 设置：加密类型id
	 */
	public void setEncodeId(Long encodeId) {
		this.encodeId = encodeId;
	}
	/**
	 * 获取：加密类型id
	 */
	public Long getEncodeId() {
		return encodeId;
	}
	/**
	 * 设置：创建人id
	 */
	public void setUserId(Date userId) {
		this.userId = userId;
	}
	/**
	 * 获取：创建人id
	 */
	public Date getUserId() {
		return userId;
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
	 * 设置：域名
	 */
	public void setBaseurl(String baseurl) {
		this.baseurl = baseurl;
	}
	/**
	 * 获取：域名
	 */
	public String getBaseurl() {
		return baseurl;
	}

	/**
	 * 设置：域名
	 */
	public void setUrlParma(String urlParma) {
		this.urlParma = urlParma;
	}
	/**
	 * 获取：域名
	 */
	public String getUrlParma() {
		return urlParma;
	}
	public List<InterfaceHeadEntity> getHead(){
		return this.head;
	}
	public  void setHead(List<InterfaceHeadEntity> head){
		this.head = head;

}
}



