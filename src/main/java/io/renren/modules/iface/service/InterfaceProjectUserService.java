package io.renren.modules.iface.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.iface.entity.InterfaceProjectUserEntity;

import java.util.Map;

/**
 * 接口信息表
 *
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-10-19 16:16:47
 */
public interface InterfaceProjectUserService extends IService<InterfaceProjectUserEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

