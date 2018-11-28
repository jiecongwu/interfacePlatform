package io.renren.modules.iface.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.iface.entity.InterfaceParamEntity;

import java.util.Map;

/**
 * 接口实体参数表
 *
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-08-24 16:42:37
 */
public interface InterfaceParamService extends IService<InterfaceParamEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

