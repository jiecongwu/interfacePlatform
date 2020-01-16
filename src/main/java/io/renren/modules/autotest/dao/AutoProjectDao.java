package io.renren.modules.autotest.dao;

import io.renren.modules.autotest.entity.AutoProjectEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 项目用例总表
 * 
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2020-01-09 22:42:21
 */
@Mapper
public interface AutoProjectDao extends BaseMapper<AutoProjectEntity> {

    List<AutoProjectEntity> selectByUserId(Long userId);
}
