package io.renren.modules.iface.dao;

import io.renren.modules.iface.entity.InterfaceHeadEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 接口请求头信息表
 * 
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-08-24 16:42:36
 */
@Mapper
public interface InterfaceHeadDao extends BaseMapper<InterfaceHeadEntity> {
	
}
