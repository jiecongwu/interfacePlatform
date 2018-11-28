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

import io.renren.modules.iface.entity.InterfaceParamEntity;
import io.renren.modules.iface.service.InterfaceParamService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 接口实体参数表
 *
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-08-24 16:42:37
 */
@RestController
@RequestMapping("iface/interfaceparam")
public class InterfaceParamController {
    @Autowired
    private InterfaceParamService interfaceParamService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("iface:interfaceparam:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = interfaceParamService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{paramId}")
    @RequiresPermissions("iface:interfaceparam:info")
    public R info(@PathVariable("paramId") Long paramId){
			InterfaceParamEntity interfaceParam = interfaceParamService.selectById(paramId);

        return R.ok().put("interfaceParam", interfaceParam);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("iface:interfaceparam:save")
    public R save(@RequestBody InterfaceParamEntity interfaceParam){
			interfaceParamService.insert(interfaceParam);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("iface:interfaceparam:update")
    public R update(@RequestBody InterfaceParamEntity interfaceParam){
			interfaceParamService.updateById(interfaceParam);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("iface:interfaceparam:delete")
    public R delete(@RequestBody Long[] paramIds){
			interfaceParamService.deleteBatchIds(Arrays.asList(paramIds));

        return R.ok();
    }

}
