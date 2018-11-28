package io.renren.modules.iface.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.iface.service.InterfaceHeadService;
import io.renren.modules.iface.dao.InterfaceInfoDao;
import io.renren.modules.iface.entity.InterfaceInfoEntity;
import io.renren.modules.iface.service.InterfaceInfoService;
import org.springframework.transaction.annotation.Transactional;


@Service("interfaceInfoService")
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoDao, InterfaceInfoEntity> implements InterfaceInfoService {
    @Autowired
    private InterfaceHeadService interfaceHeadService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<InterfaceInfoEntity> page = this.selectPage(
                new Query<InterfaceInfoEntity>(params).getPage(),
                new EntityWrapper<InterfaceInfoEntity>()
        );

        return new PageUtils(page);
    }
    @Override
    @Transactional
    public void save(InterfaceInfoEntity interfaceInfo) {
        interfaceInfo.getHead().remove(interfaceInfo.getHead().size()-1);
        if (interfaceInfo.getInfId().equals("")){

        interfaceInfo.setCreateTime(new Date());
       //insert 接口表
        this.insert(interfaceInfo);
         } else  this.updateById(interfaceInfo);

        //insert head表
        interfaceHeadService.saveOrUpdate(interfaceInfo.getInfId(),interfaceInfo.getHead());
     //     interfaceHeadService.insert();

    }
}
