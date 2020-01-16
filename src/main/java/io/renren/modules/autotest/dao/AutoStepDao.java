package io.renren.modules.autotest.dao;

import io.renren.modules.autotest.entity.AutoStepEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 测试案例步骤表
 * 
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2020-01-09 22:42:21
 */
@Mapper
public interface AutoStepDao extends BaseMapper<AutoStepEntity> {
	
}
