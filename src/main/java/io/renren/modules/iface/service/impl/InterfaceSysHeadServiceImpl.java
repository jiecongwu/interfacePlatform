package io.renren.modules.iface.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.iface.dao.InterfaceSysHeadDao;
import io.renren.modules.iface.entity.InterfaceSysHeadEntity;
import io.renren.modules.iface.service.InterfaceSysHeadService;


@Service("interfaceSysHeadService")
public class InterfaceSysHeadServiceImpl extends ServiceImpl<InterfaceSysHeadDao, InterfaceSysHeadEntity> implements InterfaceSysHeadService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<InterfaceSysHeadEntity> page = this.selectPage(
                new Query<InterfaceSysHeadEntity>(params).getPage(),
                new EntityWrapper<InterfaceSysHeadEntity>()
        );

        return new PageUtils(page);
    }

}
