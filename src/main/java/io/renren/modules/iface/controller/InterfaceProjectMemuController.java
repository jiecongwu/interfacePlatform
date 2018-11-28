package io.renren.modules.iface.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.modules.iface.entity.InterfaceInfoEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.iface.entity.InterfaceProjectMemuEntity;
import io.renren.modules.iface.service.InterfaceProjectMemuService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import io.renren.modules.iface.service.InterfaceInfoService;


/**
 * 接口菜单路径表
 *
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-10-19 16:16:46
 */
@RestController
@RequestMapping("iface/interface")
public class InterfaceProjectMemuController {
    @Autowired
    private InterfaceProjectMemuService interfaceProjectMemuService;
    @Autowired
    private InterfaceInfoService interfaceInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("iface:interfaceprojectmemu:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = interfaceProjectMemuService.queryPage(params);

        return R.ok().put("page", page);
    }



    /**
     * 项目列表
     */
    @RequestMapping("/menu/{projectId}")
    public R project_inter_list(@PathVariable("projectId") Long projectId){

        List<InterfaceProjectMemuEntity> menuList = interfaceProjectMemuService.getProjectMenuList(projectId);


       return R.ok().put("interfaceProjectMemu", menuList);
    }

    private void getmemu(InterfaceProjectMemuEntity menu){
     /*   List<InterfaceInfoEntity> interfaceInfo = interfaceInfoService.selectList(new EntityWrapper<InterfaceInfoEntity>().eq("project_id",menu.getProjectId()));
        if (interfaceInfo.size()>0){
            menu.setInterfaceList(interfaceInfo);
            getmemu(menu.);
        }*/
        List<InterfaceProjectMemuEntity> interfaceProjectMemu =interfaceProjectMemuService.selectList(new EntityWrapper<InterfaceProjectMemuEntity>().eq("" +
                "",menu.getProjectId()));

    }

    /**
     * 信息
     */
    @RequestMapping("/info/{projectId}")
    @RequiresPermissions("iface:interfaceprojectmemu:info")
    public R info(@PathVariable("projectId") Long projectId){
			InterfaceProjectMemuEntity interfaceProjectMemu = interfaceProjectMemuService.selectById(projectId);

        return R.ok().put("interfaceProjectMemu", interfaceProjectMemu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
   // @RequiresPermissions("iface:interfaceprojectmemu:save")
    public R save(@RequestBody InterfaceProjectMemuEntity interfaceProjectMemu){
			interfaceProjectMemuService.insert(interfaceProjectMemu);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("iface:interfaceprojectmemu:update")
    public R update(@RequestBody InterfaceProjectMemuEntity interfaceProjectMemu){
			interfaceProjectMemuService.updateById(interfaceProjectMemu);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("iface:interfaceprojectmemu:delete")
    public R delete(@RequestBody Long[] projectIds){
			interfaceProjectMemuService.deleteBatchIds(Arrays.asList(projectIds));

        return R.ok();
    }

}
