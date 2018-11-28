package io.renren.modules.iface.dao;

import io.renren.modules.iface.entity.InterfaceCaseEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 接口实例表
 * 
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-08-24 16:42:36
 */
@Mapper
public interface InterfaceCaseDao extends BaseMapper<InterfaceCaseEntity> {
	
}
