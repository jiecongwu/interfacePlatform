package io.renren.modules.iface.dao;

import io.renren.modules.iface.entity.InterfaceProjectMemuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 接口菜单路径表
 * 
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-10-19 16:16:46
 */
@Mapper
public interface InterfaceProjectMemuDao extends BaseMapper<InterfaceProjectMemuEntity> {
	
}
