package io.renren.modules.iface.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.iface.dao.InterfaceProjectUserDao;
import io.renren.modules.iface.entity.InterfaceProjectUserEntity;
import io.renren.modules.iface.service.InterfaceProjectUserService;


@Service("interfaceProjectUserService")
public class InterfaceProjectUserServiceImpl extends ServiceImpl<InterfaceProjectUserDao, InterfaceProjectUserEntity> implements InterfaceProjectUserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<InterfaceProjectUserEntity> page = this.selectPage(
                new Query<InterfaceProjectUserEntity>(params).getPage(),
                new EntityWrapper<InterfaceProjectUserEntity>()
        );

        return new PageUtils(page);
    }

}
