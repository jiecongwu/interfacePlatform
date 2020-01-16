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

import io.renren.modules.autotest.entity.AutoUserProjectEntity;
import io.renren.modules.autotest.service.AutoUserProjectService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 用户与目标系统关系表
 *
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2020-01-09 22:42:21
 */
@RestController
@RequestMapping("autotest/autouserproject")
public class AutoUserProjectController {
    @Autowired
    private AutoUserProjectService autoUserProjectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("autotest:autouserproject:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = autoUserProjectService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("autotest:autouserproject:info")
    public R info(@PathVariable("id") Long id){
			AutoUserProjectEntity autoUserProject = autoUserProjectService.selectById(id);

        return R.ok().put("autoUserProject", autoUserProject);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("autotest:autouserproject:save")
    public R save(@RequestBody AutoUserProjectEntity autoUserProject){
			autoUserProjectService.insert(autoUserProject);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("autotest:autouserproject:update")
    public R update(@RequestBody AutoUserProjectEntity autoUserProject){
			autoUserProjectService.updateById(autoUserProject);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("autotest:autouserproject:delete")
    public R delete(@RequestBody Long[] ids){
			autoUserProjectService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
