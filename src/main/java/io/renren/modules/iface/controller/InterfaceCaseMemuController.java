package io.renren.modules.iface.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.iface.entity.InterfaceCaseMemuEntity;
import io.renren.modules.iface.service.InterfaceCaseMemuService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 用例菜单路径表
 *
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-11-13 11:47:48
 */
@RestController
@RequestMapping("iface/casememu")
public class InterfaceCaseMemuController {
    @Autowired
    private InterfaceCaseMemuService interfaceCaseMemuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("iface:interfacecasememu:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = interfaceCaseMemuService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/menu/{interfaceId}")
    public R project_inter_list(@PathVariable("interfaceId") Long interfaceId){

        List<InterfaceCaseMemuEntity> menuList = interfaceCaseMemuService.getCaseMenuList(interfaceId);


        return R.ok().put("interfaceProjectMemu", menuList);
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{menuId}")
    @RequiresPermissions("iface:interfacecasememu:info")
    public R info(@PathVariable("menuId") Long menuId){
			InterfaceCaseMemuEntity interfaceCaseMemu = interfaceCaseMemuService.selectById(menuId);

        return R.ok().put("interfaceCaseMemu", interfaceCaseMemu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
   // @RequiresPermissions("iface:interfacecasememu:save")
    public R save(@RequestBody InterfaceCaseMemuEntity interfaceCaseMemu){
			interfaceCaseMemuService.insert(interfaceCaseMemu);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("iface:interfacecasememu:update")
    public R update(@RequestBody InterfaceCaseMemuEntity interfaceCaseMemu){
			interfaceCaseMemuService.updateById(interfaceCaseMemu);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("iface:interfacecasememu:delete")
    public R delete(@RequestBody Long[] menuIds){
			interfaceCaseMemuService.deleteBatchIds(Arrays.asList(menuIds));

        return R.ok();
    }

}
