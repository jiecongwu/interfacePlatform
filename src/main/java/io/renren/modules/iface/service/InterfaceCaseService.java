package io.renren.modules.iface.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.iface.entity.InterfaceCaseEntity;

import java.util.Map;

/**
 * 接口实例表
 *
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-08-24 16:42:36
 */
public interface InterfaceCaseService extends IService<InterfaceCaseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

