package io.renren.modules.iface.dao;

import io.renren.modules.iface.entity.InterfaceProjectUserEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 接口信息表
 * 
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-10-19 16:16:47
 */
@Mapper
public interface InterfaceProjectUserDao extends BaseMapper<InterfaceProjectUserEntity> {
	
}
