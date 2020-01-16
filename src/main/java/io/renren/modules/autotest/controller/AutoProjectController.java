package io.renren.modules.autotest.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;
import io.renren.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.autotest.entity.AutoProjectEntity;
import io.renren.modules.autotest.service.AutoProjectService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 项目用例总表
 *
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2020-01-09 22:42:21
 */
@RestController
@RequestMapping("autotest/autoproject")
public class AutoProjectController  extends AbstractController {
    @Autowired
    private AutoProjectService autoProjectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("autotest:autoproject:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = autoProjectService.queryPage(params);

        return R.ok().put("page", page);
    }
    /**
     * 有权限的系统
     */
    @RequestMapping("/projectList")
    public R project_inter_list(){

        List<AutoProjectEntity> projectList = autoProjectService.selectByUserId(getUserId());


        return R.ok().put("projectList", projectList);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{projectId}")
    @RequiresPermissions("autotest:autoproject:info")
    public R info(@PathVariable("projectId") Long projectId){
			AutoProjectEntity autoProject = autoProjectService.selectById(projectId);

        return R.ok().put("autoProject", autoProject);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("autotest:autoproject:save")
    public R save(@RequestBody AutoProjectEntity autoProject){
            autoProject.setCreateUser(getUserId());
			autoProjectService.save(autoProject);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("autotest:autoproject:update")
    public R update(@RequestBody AutoProjectEntity autoProject){
			autoProjectService.updateById(autoProject);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("autotest:autoproject:delete")
    public R delete(@RequestBody Long[] projectIds){
			autoProjectService.deleteBatchIds(Arrays.asList(projectIds));

        return R.ok();
    }

}
