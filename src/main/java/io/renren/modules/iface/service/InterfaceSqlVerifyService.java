package io.renren.modules.iface.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.iface.entity.InterfaceSqlVerifyEntity;

import java.util.Map;

/**
 * 案例sql验证结果表
 *
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-08-24 16:42:37
 */
public interface InterfaceSqlVerifyService extends IService<InterfaceSqlVerifyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

