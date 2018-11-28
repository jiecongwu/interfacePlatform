package io.renren.modules.iface.service.impl;

import io.renren.modules.iface.entity.InterfaceInfoEntity;
import io.renren.modules.iface.service.InterfaceInfoService;
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

import io.renren.modules.iface.dao.InterfaceProjectMemuDao;
import io.renren.modules.iface.entity.InterfaceProjectMemuEntity;
import io.renren.modules.iface.service.InterfaceProjectMemuService;


@Service("interfaceProjectMemuService")
public class InterfaceProjectMemuServiceImpl extends ServiceImpl<InterfaceProjectMemuDao, InterfaceProjectMemuEntity> implements InterfaceProjectMemuService {
    @Autowired
    private InterfaceInfoService interfaceInfoService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<InterfaceProjectMemuEntity> page = this.selectPage(
                new Query<InterfaceProjectMemuEntity>(params).getPage(),
                new EntityWrapper<InterfaceProjectMemuEntity>()
        );

        return new PageUtils(page);
    }
    @Override
    public List<InterfaceProjectMemuEntity> queryListParentId(Long parentId) {
           List<InterfaceProjectMemuEntity> menuList =this.selectList(new EntityWrapper<InterfaceProjectMemuEntity>().eq("parent_id",parentId));
           List<InterfaceInfoEntity> infoList=interfaceInfoService.selectList(new EntityWrapper<InterfaceInfoEntity>().eq("project_id",parentId));
           for(InterfaceInfoEntity e:infoList)
           {
               InterfaceProjectMemuEntity w= new InterfaceProjectMemuEntity();
               w.setProjectId(e.getInfId());
               w.setType("2");
               w.setParentId(e.getProjectId());
               w.setName(e.getInfName());
               w.setMethod(e.getInfMethod());

               menuList.add(w);

           }
           return menuList;
        }


 @Override
    public List<InterfaceProjectMemuEntity> getProjectMenuList(Long projectId) {
     List<InterfaceProjectMemuEntity> menuList =queryListParentId(projectId);
     //递归获取子菜单

     return      getMenuTreeList(menuList);
 }





    /**
     * 递归
     */
    private List<InterfaceProjectMemuEntity> getMenuTreeList(List<InterfaceProjectMemuEntity> menuList){
        List<InterfaceProjectMemuEntity> subMenuList = new ArrayList<InterfaceProjectMemuEntity>();

        for(InterfaceProjectMemuEntity entity : menuList){
            //目录
            if(entity.getType().equals("1")){
              System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
                entity.setInterfaceList(getMenuTreeList(queryListParentId(entity.getProjectId())));

            }
            subMenuList.add(entity);
        }

        return subMenuList;
    }
}
