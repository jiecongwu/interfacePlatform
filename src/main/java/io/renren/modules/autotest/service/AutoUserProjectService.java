package io.renren.modules.autotest.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.autotest.entity.AutoUserProjectEntity;

import java.util.Map;

/**
 * 用户与目标系统关系表
 *
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2020-01-09 22:42:21
 */
public interface AutoUserProjectService extends IService<AutoUserProjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

