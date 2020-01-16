package io.renren.modules.autotest.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.autotest.dao.AutoStepDao;
import io.renren.modules.autotest.entity.AutoStepEntity;
import io.renren.modules.autotest.service.AutoStepService;


@Service("autoStepService")
public class AutoStepServiceImpl extends ServiceImpl<AutoStepDao, AutoStepEntity> implements AutoStepService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AutoStepEntity> page = this.selectPage(
                new Query<AutoStepEntity>(params).getPage(),
                new EntityWrapper<AutoStepEntity>()
        );

        return new PageUtils(page);
    }

}
