package io.renren.modules.iface.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.iface.dao.InterfaceSqlVerifyDao;
import io.renren.modules.iface.entity.InterfaceSqlVerifyEntity;
import io.renren.modules.iface.service.InterfaceSqlVerifyService;


@Service("interfaceSqlVerifyService")
public class InterfaceSqlVerifyServiceImpl extends ServiceImpl<InterfaceSqlVerifyDao, InterfaceSqlVerifyEntity> implements InterfaceSqlVerifyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<InterfaceSqlVerifyEntity> page = this.selectPage(
                new Query<InterfaceSqlVerifyEntity>(params).getPage(),
                new EntityWrapper<InterfaceSqlVerifyEntity>()
        );

        return new PageUtils(page);
    }

}
