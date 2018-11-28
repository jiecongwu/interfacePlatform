package io.renren.modules.iface.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 案例sql验证结果表
 * 
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-08-24 16:42:37
 */
@TableName("interface_sql_verify")
public class InterfaceSqlVerifyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long sId;
	/**
	 * 
	 */
	private Long verifyId;
	/**
	 * 数据库值
	 */
	private Long verifyBody;

	/**
	 * 设置：
	 */
	public void setSId(Long sId) {
		this.sId = sId;
	}
	/**
	 * 获取：
	 */
	public Long getSId() {
		return sId;
	}
	/**
	 * 设置：
	 */
	public void setVerifyId(Long verifyId) {
		this.verifyId = verifyId;
	}
	/**
	 * 获取：
	 */
	public Long getVerifyId() {
		return verifyId;
	}
	/**
	 * 设置：数据库值
	 */
	public void setVerifyBody(Long verifyBody) {
		this.verifyBody = verifyBody;
	}
	/**
	 * 获取：数据库值
	 */
	public Long getVerifyBody() {
		return verifyBody;
	}
}
