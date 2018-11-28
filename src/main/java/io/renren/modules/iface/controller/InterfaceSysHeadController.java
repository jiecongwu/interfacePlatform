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

import io.renren.modules.iface.entity.InterfaceSysHeadEntity;
import io.renren.modules.iface.service.InterfaceSysHeadService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 系统级接口请求头信息表
 *
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-08-24 16:42:37
 */
@RestController
@RequestMapping("iface/interfacesyshead")
public class InterfaceSysHeadController {
    @Autowired
    private InterfaceSysHeadService interfaceSysHeadService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("iface:interfacesyshead:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = interfaceSysHeadService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{sysHeadId}")
    @RequiresPermissions("iface:interfacesyshead:info")
    public R info(@PathVariable("sysHeadId") Long sysHeadId){
			InterfaceSysHeadEntity interfaceSysHead = interfaceSysHeadService.selectById(sysHeadId);

        return R.ok().put("interfaceSysHead", interfaceSysHead);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("iface:interfacesyshead:save")
    public R save(@RequestBody InterfaceSysHeadEntity interfaceSysHead){
			interfaceSysHeadService.insert(interfaceSysHead);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("iface:interfacesyshead:update")
    public R update(@RequestBody InterfaceSysHeadEntity interfaceSysHead){
			interfaceSysHeadService.updateById(interfaceSysHead);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("iface:interfacesyshead:delete")
    public R delete(@RequestBody Long[] sysHeadIds){
			interfaceSysHeadService.deleteBatchIds(Arrays.asList(sysHeadIds));

        return R.ok();
    }

}
