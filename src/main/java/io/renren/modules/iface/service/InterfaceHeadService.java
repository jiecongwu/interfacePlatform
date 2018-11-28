package io.renren.modules.iface.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.iface.entity.InterfaceHeadEntity;

import java.util.List;
import java.util.Map;

/**
 * 接口请求头信息表
 *
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-08-24 16:42:36
 */
public interface InterfaceHeadService extends IService<InterfaceHeadEntity> {

    PageUtils queryPage(Map<String, Object> params);
    void saveOrUpdate(Long InfId, List<InterfaceHeadEntity> headList);

}

