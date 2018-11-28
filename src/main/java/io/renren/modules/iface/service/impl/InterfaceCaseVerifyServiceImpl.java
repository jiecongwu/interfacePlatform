package io.renren.modules.iface.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.iface.dao.InterfaceCaseVerifyDao;
import io.renren.modules.iface.entity.InterfaceCaseVerifyEntity;
import io.renren.modules.iface.service.InterfaceCaseVerifyService;


@Service("interfaceCaseVerifyService")
public class InterfaceCaseVerifyServiceImpl extends ServiceImpl<InterfaceCaseVerifyDao, InterfaceCaseVerifyEntity> implements InterfaceCaseVerifyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<InterfaceCaseVerifyEntity> page = this.selectPage(
                new Query<InterfaceCaseVerifyEntity>(params).getPage(),
                new EntityWrapper<InterfaceCaseVerifyEntity>()
        );

        return new PageUtils(page);
    }

}
