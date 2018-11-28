package io.renren.common.utils.outter;
import java.io.Serializable;
import java.util.List;
public class Rewardentiny implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 菜单ID
	 */
	private String amount;

	private String userId;

	/**
	 * 父菜单ID，一级菜单为0
	 */
	
	

	
	
	/**
	 * 设置：父菜单ID，一级菜单为0
	 * @param parentId 父菜单ID，一级菜单为0
	 */
	public void setamount(String amount) {
		this.amount = amount;
	}
	
	public String getamount() {
		return this.amount ;
	}
	
	public void setuserId(String userId) {
		this.userId = userId;
	}

	public String getuserId() {
		return this.userId ;
	}
	
}




