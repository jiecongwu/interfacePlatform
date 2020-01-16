package io.renren.modules.autotest.dao;

import io.renren.modules.autotest.entity.AutoUserProjectEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户与目标系统关系表
 * 
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2020-01-09 22:42:21
 */
@Mapper
public interface AutoUserProjectDao extends BaseMapper<AutoUserProjectEntity> {
	
}
