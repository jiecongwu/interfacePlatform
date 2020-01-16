package io.renren.modules.autotest.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.autotest.entity.AutoStepEntity;
import io.renren.modules.autotest.service.AutoStepService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 测试案例步骤表
 *
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2020-01-09 22:42:21
 */
@RestController
@RequestMapping("autotest/autostep")
public class AutoStepController {
    @Autowired
    private AutoStepService autoStepService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("autotest:autostep:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = autoStepService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{stepId}")
    @RequiresPermissions("autotest:autostep:info")
    public R info(@PathVariable("stepId") Long stepId){
			AutoStepEntity autoStep = autoStepService.selectById(stepId);

        return R.ok().put("autoStep", autoStep);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("autotest:autostep:save")
    public R save(@RequestBody AutoStepEntity autoStep){
			autoStepService.insert(autoStep);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("autotest:autostep:update")
    public R update(@RequestBody AutoStepEntity autoStep){
			autoStepService.updateById(autoStep);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("autotest:autostep:delete")
    public R delete(@RequestBody Long[] stepIds){
			autoStepService.deleteBatchIds(Arrays.asList(stepIds));

        return R.ok();
    }

}
