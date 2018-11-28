package io.renren.modules.iface.dao;

import io.renren.modules.iface.entity.InterfaceInfoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 接口信息表
 * 
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-10-22 17:41:27
 */
@Mapper
public interface InterfaceInfoDao extends BaseMapper<InterfaceInfoEntity> {
	
}
