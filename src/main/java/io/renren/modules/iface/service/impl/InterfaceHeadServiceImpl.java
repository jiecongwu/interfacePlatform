package io.renren.modules.iface.service.impl;

import io.renren.common.utils.MapUtils;
import io.renren.modules.sys.entity.SysUserRoleEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.iface.dao.InterfaceHeadDao;
import io.renren.modules.iface.entity.InterfaceHeadEntity;
import io.renren.modules.iface.service.InterfaceHeadService;


@Service("interfaceHeadService")
public class InterfaceHeadServiceImpl extends ServiceImpl<InterfaceHeadDao, InterfaceHeadEntity> implements InterfaceHeadService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<InterfaceHeadEntity> page = this.selectPage(
                new Query<InterfaceHeadEntity>(params).getPage(),
                new EntityWrapper<InterfaceHeadEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveOrUpdate(Long InfId, List<InterfaceHeadEntity> headList) {
        //先删除旧数据head
        this.deleteByMap(new MapUtils().put("inf_id", InfId));

        if(headList == null || headList.size() == 0){
            return ;
        }

        //保存接口head
        for(InterfaceHeadEntity head : headList){
            head.setInfId(InfId);
        }
        this.insertBatch(headList);
    }

}
