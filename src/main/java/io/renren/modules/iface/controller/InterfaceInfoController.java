package io.renren.modules.iface.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import io.renren.modules.iface.entity.InterfaceHeadEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.iface.entity.InterfaceInfoEntity;
import io.renren.modules.iface.service.InterfaceInfoService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;

import io.renren.modules.iface.service.InterfaceHeadService;

/**
 * 接口信息表
 *
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-10-22 17:41:27
 */
@RestController
@RequestMapping("iface/interfaceinfo")
public class InterfaceInfoController {
    @Autowired
    private InterfaceInfoService interfaceInfoService;
    @Autowired
    private InterfaceHeadService interfaceHeadService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("iface:interfaceinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = interfaceInfoService.queryPage(params);

        return R.ok().put("page", page);
    }
    @RequestMapping("/list1")
    public R list1(){
// EntityWrapper<InterfaceInfoEntity> ew1 = new EntityWrapper<InterfaceInfoEntity>();
        // ew1.eq("project_id",e.getProjectId());
         InterfaceInfoEntity interfaceInfo = interfaceInfoService.selectById("1");
        return R.ok().put("interfaceInfo", interfaceInfo);


    }

/*    *//**
     * 信息
     *//*
    @RequestMapping("/info/{infId}")
    @RequiresPermissions("iface:interfaceinfo:info")
    public R info(@PathVariable("infId") Long infId){
			InterfaceInfoEntity interfaceInfo = interfaceInfoService.selectById(infId);

        return R.ok().put("interfaceInfo", interfaceInfo);
    }*/
    /**
     * 信息
     */
    @RequestMapping("/info/{infId}")
    public R info(@PathVariable("infId") Long infId){
        InterfaceInfoEntity interfaceInfo = interfaceInfoService.selectById(infId);

        //获取接口head列表
        List<InterfaceHeadEntity> head =interfaceHeadService.selectList(new EntityWrapper<InterfaceHeadEntity>().eq("inf_id",infId));
        interfaceInfo.setHead(head);
        return R.ok().put("data", interfaceInfo);
    }
/*    *//**
     * 保存
     *//*
    @RequestMapping("/save")
    @RequiresPermissions("iface:interfaceinfo:save")
    public R save(@RequestBody InterfaceInfoEntity interfaceInfo){
			interfaceInfoService.insert(interfaceInfo);

        return R.ok();
    }*/
    /**
     * 保存
     */
    @RequestMapping("/save")
  //  @RequiresPermissions("iface:interfaceinfo:save")
    public R save(@RequestBody InterfaceInfoEntity interfaceInfo){
        System.out.println("进来了");
        interfaceInfoService.save(interfaceInfo);
       return R.ok().put("data", interfaceInfo);

    }
    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("iface:interfaceinfo:update")
    public R update(@RequestBody InterfaceInfoEntity interfaceInfo){
			interfaceInfoService.updateById(interfaceInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("iface:interfaceinfo:delete")
    public R delete(@RequestBody Long[] infIds){
			interfaceInfoService.deleteBatchIds(Arrays.asList(infIds));

        return R.ok();
    }

}
