package io.renren.modules.autotest.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.autotest.entity.AutoProjectEntity;

import java.util.List;
import java.util.Map;

/**
 * 项目用例总表
 *
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2020-01-09 22:42:21
 */
public interface AutoProjectService extends IService<AutoProjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
     void save(AutoProjectEntity project);
    List<AutoProjectEntity> selectByUserId(Long userId);

}

