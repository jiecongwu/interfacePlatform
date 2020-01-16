package io.renren.modules.autotest.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.autotest.entity.AutoStepEntity;

import java.util.Map;

/**
 * 测试案例步骤表
 *
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2020-01-09 22:42:21
 */
public interface AutoStepService extends IService<AutoStepEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

