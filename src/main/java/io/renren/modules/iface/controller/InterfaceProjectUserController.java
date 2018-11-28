package io.renren.modules.iface.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.iface.entity.InterfaceProjectUserEntity;
import io.renren.modules.iface.service.InterfaceProjectUserService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 接口信息表
 *
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-10-19 16:16:47
 */
@RestController
@RequestMapping("iface/interfaceprojectuser")
public class InterfaceProjectUserController {
    @Autowired
    private InterfaceProjectUserService interfaceProjectUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("iface:interfaceprojectuser:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = interfaceProjectUserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{infProId}")
    @RequiresPermissions("iface:interfaceprojectuser:info")
    public R info(@PathVariable("infProId") Long infProId){
			InterfaceProjectUserEntity interfaceProjectUser = interfaceProjectUserService.selectById(infProId);

        return R.ok().put("interfaceProjectUser", interfaceProjectUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("iface:interfaceprojectuser:save")
    public R save(@RequestBody InterfaceProjectUserEntity interfaceProjectUser){
			interfaceProjectUserService.insert(interfaceProjectUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("iface:interfaceprojectuser:update")
    public R update(@RequestBody InterfaceProjectUserEntity interfaceProjectUser){
			interfaceProjectUserService.updateById(interfaceProjectUser);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("iface:interfaceprojectuser:delete")
    public R delete(@RequestBody Long[] infProIds){
			interfaceProjectUserService.deleteBatchIds(Arrays.asList(infProIds));

        return R.ok();
    }

}
