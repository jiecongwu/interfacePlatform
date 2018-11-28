package io.renren.modules.iface.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.iface.entity.InterfaceProjectMemuEntity;

import java.util.List;
import java.util.Map;

/**
 * 接口菜单路径表
 *
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-10-19 16:16:46
 */
public interface InterfaceProjectMemuService extends IService<InterfaceProjectMemuEntity> {

    PageUtils queryPage(Map<String, Object> params);


    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     */
    List<InterfaceProjectMemuEntity> queryListParentId(Long parentId);
    /**
     * 获取用户菜单列表
     */
    List<InterfaceProjectMemuEntity> getProjectMenuList(Long ProjectId);
    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     */

}

