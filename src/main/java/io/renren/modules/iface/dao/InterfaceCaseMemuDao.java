package io.renren.modules.iface.dao;

import io.renren.modules.iface.entity.InterfaceCaseMemuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用例菜单路径表
 * 
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-11-13 11:47:48
 */
@Mapper
public interface InterfaceCaseMemuDao extends BaseMapper<InterfaceCaseMemuEntity> {
	
}
