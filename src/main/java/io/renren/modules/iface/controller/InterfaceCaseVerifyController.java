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

import io.renren.modules.iface.entity.InterfaceCaseVerifyEntity;
import io.renren.modules.iface.service.InterfaceCaseVerifyService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 接口案例验证实例表
 *
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-08-24 16:42:37
 */
@RestController
@RequestMapping("iface/interfacecaseverify")
public class InterfaceCaseVerifyController {
    @Autowired
    private InterfaceCaseVerifyService interfaceCaseVerifyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("iface:interfacecaseverify:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = interfaceCaseVerifyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{verifyId}")
    @RequiresPermissions("iface:interfacecaseverify:info")
    public R info(@PathVariable("verifyId") Long verifyId){
			InterfaceCaseVerifyEntity interfaceCaseVerify = interfaceCaseVerifyService.selectById(verifyId);

        return R.ok().put("interfaceCaseVerify", interfaceCaseVerify);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("iface:interfacecaseverify:save")
    public R save(@RequestBody InterfaceCaseVerifyEntity interfaceCaseVerify){
			interfaceCaseVerifyService.insert(interfaceCaseVerify);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("iface:interfacecaseverify:update")
    public R update(@RequestBody InterfaceCaseVerifyEntity interfaceCaseVerify){
			interfaceCaseVerifyService.updateById(interfaceCaseVerify);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("iface:interfacecaseverify:delete")
    public R delete(@RequestBody Long[] verifyIds){
			interfaceCaseVerifyService.deleteBatchIds(Arrays.asList(verifyIds));

        return R.ok();
    }

}
