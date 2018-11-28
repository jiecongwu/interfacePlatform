package io.renren.modules.iface.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.iface.entity.InterfaceCaseMemuEntity;

import java.util.List;
import java.util.Map;

/**
 * 用例菜单路径表
 *
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-11-13 11:47:48
 */
public interface InterfaceCaseMemuService extends IService<InterfaceCaseMemuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<InterfaceCaseMemuEntity> queryListParentId(Long parentId);

    List<InterfaceCaseMemuEntity> getCaseMenuList(Long infId);
    List<InterfaceCaseMemuEntity> queryListinfId(Long infId);


}

