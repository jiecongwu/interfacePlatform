package io.renren.modules.iface.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.iface.entity.InterfaceInfoEntity;

import java.util.Map;

/**
 * 接口信息表
 *
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-10-22 17:41:27
 */
public interface InterfaceInfoService extends IService<InterfaceInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    /**
     * 保存用户
     */
    void save(InterfaceInfoEntity interfaceInfo);
}

