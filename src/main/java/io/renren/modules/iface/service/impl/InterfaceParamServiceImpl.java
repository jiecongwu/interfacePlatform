package io.renren.modules.iface.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.iface.dao.InterfaceParamDao;
import io.renren.modules.iface.entity.InterfaceParamEntity;
import io.renren.modules.iface.service.InterfaceParamService;


@Service("interfaceParamService")
public class InterfaceParamServiceImpl extends ServiceImpl<InterfaceParamDao, InterfaceParamEntity> implements InterfaceParamService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<InterfaceParamEntity> page = this.selectPage(
                new Query<InterfaceParamEntity>(params).getPage(),
                new EntityWrapper<InterfaceParamEntity>()
        );

        return new PageUtils(page);
    }

}
