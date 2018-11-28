package io.renren.modules.iface.dao;

import io.renren.modules.iface.entity.InterfaceParamEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 接口实体参数表
 * 
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-08-24 16:42:37
 */
@Mapper
public interface InterfaceParamDao extends BaseMapper<InterfaceParamEntity> {
	
}
