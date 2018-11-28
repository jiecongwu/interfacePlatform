package io.renren.modules.iface.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.iface.entity.InterfaceSysHeadEntity;

import java.util.Map;

/**
 * 系统级接口请求头信息表
 *
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-08-24 16:42:37
 */
public interface InterfaceSysHeadService extends IService<InterfaceSysHeadEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

