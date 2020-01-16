package io.renren.modules.iface.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.utils.outter.FtcspRestClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.iface.entity.InterfaceCaseEntity;
import io.renren.modules.iface.service.InterfaceCaseService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 接口实例表
 *
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-08-24 16:42:36
 */
@RestController
@RequestMapping("iface/case")
public class InterfaceCaseController {
    @Autowired
    private InterfaceCaseService interfaceCaseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("iface:interfacecase:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = interfaceCaseService.queryPage(params);

        return R.ok().put("page", page);
    }




    /**
     * 信息
     */
    @RequestMapping("/info/{caseId}")
    @RequiresPermissions("iface:interfacecase:info")
    public R info(@PathVariable("caseId") Long caseId){
			InterfaceCaseEntity interfaceCase = interfaceCaseService.selectById(caseId);

        return R.ok().put("interfaceCase", interfaceCase);
    }




    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("iface:interfacecase:save")
    public R save(@RequestBody InterfaceCaseEntity interfaceCase){
			interfaceCaseService.insert(interfaceCase);

        return R.ok().put("interfaceCase", interfaceCase);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("iface:interfacecase:update")
    public R update(@RequestBody InterfaceCaseEntity interfaceCase){
			interfaceCaseService.updateById(interfaceCase);

        return R.ok().put("interfaceCase", interfaceCase);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("iface:interfacecase:delete")
    public R delete(@RequestBody Long[] caseIds){
			interfaceCaseService.deleteBatchIds(Arrays.asList(caseIds));

        return R.ok();
    }

}
