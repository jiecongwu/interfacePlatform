package io.renren.modules.iface.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.iface.dao.InterfaceCaseDao;
import io.renren.modules.iface.entity.InterfaceCaseEntity;
import io.renren.modules.iface.service.InterfaceCaseService;


@Service("interfaceCaseService")
public class InterfaceCaseServiceImpl extends ServiceImpl<InterfaceCaseDao, InterfaceCaseEntity> implements InterfaceCaseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<InterfaceCaseEntity> page = this.selectPage(
                new Query<InterfaceCaseEntity>(params).getPage(),
                new EntityWrapper<InterfaceCaseEntity>()
        );

        return new PageUtils(page);
    }

}
