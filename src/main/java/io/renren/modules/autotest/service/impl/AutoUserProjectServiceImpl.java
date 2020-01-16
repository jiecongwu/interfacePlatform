package io.renren.modules.autotest.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.autotest.dao.AutoUserProjectDao;
import io.renren.modules.autotest.entity.AutoUserProjectEntity;
import io.renren.modules.autotest.service.AutoUserProjectService;


@Service("autoUserProjectService")
public class AutoUserProjectServiceImpl extends ServiceImpl<AutoUserProjectDao, AutoUserProjectEntity> implements AutoUserProjectService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AutoUserProjectEntity> page = this.selectPage(
                new Query<AutoUserProjectEntity>(params).getPage(),
                new EntityWrapper<AutoUserProjectEntity>()
        );

        return new PageUtils(page);
    }

}
