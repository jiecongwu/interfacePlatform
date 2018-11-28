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

import io.renren.modules.iface.entity.InterfaceHeadEntity;
import io.renren.modules.iface.service.InterfaceHeadService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 接口请求头信息表
 *
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-08-24 16:42:36
 */
@RestController
@RequestMapping("iface/interfacehead")
public class InterfaceHeadController {
    @Autowired
    private InterfaceHeadService interfaceHeadService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("iface:interfacehead:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = interfaceHeadService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{headId}")
    @RequiresPermissions("iface:interfacehead:info")
    public R info(@PathVariable("headId") Long headId){
			InterfaceHeadEntity interfaceHead = interfaceHeadService.selectById(headId);

        return R.ok().put("interfaceHead", interfaceHead);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("iface:interfacehead:save")
    public R save(@RequestBody InterfaceHeadEntity interfaceHead){
			interfaceHeadService.insert(interfaceHead);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("iface:interfacehead:update")
    public R update(@RequestBody InterfaceHeadEntity interfaceHead){
			interfaceHeadService.updateById(interfaceHead);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("iface:interfacehead:delete")
    public R delete(@RequestBody Long[] headIds){
			interfaceHeadService.deleteBatchIds(Arrays.asList(headIds));

        return R.ok();
    }

}
