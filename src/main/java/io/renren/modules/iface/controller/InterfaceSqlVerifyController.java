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

import io.renren.modules.iface.entity.InterfaceSqlVerifyEntity;
import io.renren.modules.iface.service.InterfaceSqlVerifyService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 案例sql验证结果表
 *
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-08-24 16:42:37
 */
@RestController
@RequestMapping("iface/interfacesqlverify")
public class InterfaceSqlVerifyController {
    @Autowired
    private InterfaceSqlVerifyService interfaceSqlVerifyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("iface:interfacesqlverify:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = interfaceSqlVerifyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{sId}")
    @RequiresPermissions("iface:interfacesqlverify:info")
    public R info(@PathVariable("sId") Long sId){
			InterfaceSqlVerifyEntity interfaceSqlVerify = interfaceSqlVerifyService.selectById(sId);

        return R.ok().put("interfaceSqlVerify", interfaceSqlVerify);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("iface:interfacesqlverify:save")
    public R save(@RequestBody InterfaceSqlVerifyEntity interfaceSqlVerify){
			interfaceSqlVerifyService.insert(interfaceSqlVerify);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("iface:interfacesqlverify:update")
    public R update(@RequestBody InterfaceSqlVerifyEntity interfaceSqlVerify){
			interfaceSqlVerifyService.updateById(interfaceSqlVerify);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("iface:interfacesqlverify:delete")
    public R delete(@RequestBody Long[] sIds){
			interfaceSqlVerifyService.deleteBatchIds(Arrays.asList(sIds));

        return R.ok();
    }

}
