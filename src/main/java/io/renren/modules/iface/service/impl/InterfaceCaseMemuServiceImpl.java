package io.renren.modules.iface.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.iface.dao.InterfaceCaseMemuDao;
import io.renren.modules.iface.entity.InterfaceCaseMemuEntity;
import io.renren.modules.iface.service.InterfaceCaseMemuService;
import io.renren.modules.iface.entity.InterfaceCaseEntity;
import io.renren.modules.iface.service.InterfaceCaseService;



@Service("interfaceCaseMemuService")
public class InterfaceCaseMemuServiceImpl extends ServiceImpl<InterfaceCaseMemuDao, InterfaceCaseMemuEntity> implements InterfaceCaseMemuService {
    @Autowired
    private InterfaceCaseService interfaceCaseService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<InterfaceCaseMemuEntity> page = this.selectPage(
                new Query<InterfaceCaseMemuEntity>(params).getPage(),
                new EntityWrapper<InterfaceCaseMemuEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<InterfaceCaseMemuEntity> queryListParentId(Long parentId) {
        List<InterfaceCaseMemuEntity> menuList =this.selectList(new EntityWrapper<InterfaceCaseMemuEntity>().eq("parent_id",parentId));
        List<InterfaceCaseEntity> caseList=interfaceCaseService.selectList(new EntityWrapper<InterfaceCaseEntity>().eq("parent_id",parentId));
        for(InterfaceCaseEntity e:caseList)
        {
            InterfaceCaseMemuEntity w= new InterfaceCaseMemuEntity();
            w.setMenuId(e.getCaseId());
            w.setType("2");
            w.setParentId(e.getParentId());
            w.setName(e.getCaseName());
            menuList.add(w);

        }
        return menuList;
    }

    @Override
    public List<InterfaceCaseMemuEntity> queryListinfId(Long infId) {
       // InterfaceCaseMemuEntity menu=this.selectOne(new EntityWrapper<InterfaceCaseMemuEntity>().eq("inf_id",infId));
        List<InterfaceCaseMemuEntity> menuList =this.selectList(new EntityWrapper<InterfaceCaseMemuEntity>().eq("inf_id",infId));
        /*List<InterfaceCaseEntity> caseList=interfaceCaseService.selectList(new EntityWrapper<InterfaceCaseEntity>().eq("parent_id",menu.getMenuId()));
        for(InterfaceCaseEntity e:caseList)
        {
            InterfaceCaseMemuEntity w= new InterfaceCaseMemuEntity();
            w.setMenuId(e.getCaseId());
            w.setType("2");
            w.setParentId(e.getParentId());
            w.setName(e.getCaseName());
            menuList.add(w);

        }*/
        return menuList;
    }

    @Override
    public List<InterfaceCaseMemuEntity> getCaseMenuList(Long infId) {
        List<InterfaceCaseMemuEntity> menuList =queryListinfId(infId);
        //递归获取子菜单

        return      getMenuTreeList(menuList);
    }





    /**
     * 递归
     */
    private List<InterfaceCaseMemuEntity> getMenuTreeList(List<InterfaceCaseMemuEntity> menuList){
        List<InterfaceCaseMemuEntity> subMenuList = new ArrayList<InterfaceCaseMemuEntity>();

        for(InterfaceCaseMemuEntity entity : menuList){
            //目录
            if(entity.getType()!="2"){
                System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
                entity.setInterfaceList(getMenuTreeList(queryListParentId(entity.getMenuId())));

            }
            subMenuList.add(entity);
        }

        return subMenuList;
    }

}
