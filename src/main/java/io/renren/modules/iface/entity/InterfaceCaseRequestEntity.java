package io.renren.modules.iface.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.List;

/**
 * 接口实例表
 * 
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-08-24 16:42:36
 */
@TableName("interface_case")
public class InterfaceCaseRequestEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long caseId;
	/**
	 * 案例名称
	 */
	private String caseName;

	/**
	 * 方法
	 */
	private String method;
	/**
	 * 接口id
	 */
	private String url;
	/**
	 * 接口id
	 */
	private Long parentId;
	/**
	 * 请求实体
	 */
	private String body;
	/**
	 * 前置请求，多个逗号分隔
	 */
	private String beforeCaseId;
	/**
	 * 后置请求，多个逗号分隔
	 */
	private String afterCaseId;

	/**
	 * 角色ID列表
	 */
	@TableField(exist=false)
	private List<InterfaceHeadEntity> head;

	/**
	 * 设置：
	 */
	public void setCaseId(Long caseId) {
		this.caseId = caseId;
	}
	/**
	 * 获取：
	 */
	public Long getCaseId() {
		return caseId;
	}
	/**
	 * 设置：案例名称
	 */
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	/**
	 * 获取：案例名称
	 */
	public String getCaseName() {
		return caseName;
	}
	/**
	 * 设置：方法
	 */
	public void setMethod(String method) {
		this.method = method;
	}
	/**
	 * 获取：方法
	 */
	public String getMethod() {
		return method;
	}
	/**
	 * 设置：案例名称
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：案例名称
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：接口id
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：接口id
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * 设置：请求实体
	 */
	public void setBody(String body) {
		this.body = body;
	}
	/**
	 * 获取：请求实体
	 */
	public String getBody() {
		return body;
	}
	/**
	 * 设置：前置请求，多个逗号分隔
	 */
	public void setBeforeCaseId(String beforeCaseId) {
		this.beforeCaseId = beforeCaseId;
	}
	/**
	 * 获取：前置请求，多个逗号分隔
	 */
	public String getBeforeCaseId() {
		return beforeCaseId;
	}
	/**
	 * 设置：后置请求，多个逗号分隔
	 */
	public void setAfterCaseId(String afterCaseId) {
		this.afterCaseId = afterCaseId;
	}
	/**
	 * 获取：后置请求，多个逗号分隔
	 */
	public String getAfterCaseId() {
		return afterCaseId;
	}

	public List<InterfaceHeadEntity> getHead(){
		return this.head;
	}
	public  void setHead(List<InterfaceHeadEntity> head){
		this.head = head;
	}
}
