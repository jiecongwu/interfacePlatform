package io.renren.modules.autotest.service.impl;

import io.renren.modules.autotest.dao.AutoProjectDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.autotest.dao.AutoProjectDao;
import io.renren.modules.autotest.entity.AutoProjectEntity;
import io.renren.modules.autotest.entity.AutoUserProjectEntity;
import io.renren.modules.autotest.service.AutoProjectService;
import io.renren.modules.autotest.service.AutoUserProjectService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;


@Service("autoProjectService")
public class AutoProjectServiceImpl extends ServiceImpl<AutoProjectDao, AutoProjectEntity> implements AutoProjectService {
    @Autowired
    private AutoUserProjectService autoUserProjectService;
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AutoProjectEntity> page = this.selectPage(
                new Query<AutoProjectEntity>(params).getPage(),
                new EntityWrapper<AutoProjectEntity>()
        );

        return new PageUtils(page);
    }
    @Override
    @Transactional
    public void save(AutoProjectEntity project) {

        //保存项目
        this.insert(project);
        //如果是系统类型，添加系统权限
        if (project.getType().equals(0)) {
            AutoUserProjectEntity au = new AutoUserProjectEntity();
            au.setProjectId(project.getProjectId());
            au.setUserId(project.getCreateUser());
            au.setType("1");

            autoUserProjectService.insert(au);

        }
    }
    @Override
    public List<AutoProjectEntity> selectByUserId(Long userId) {
        return baseMapper.selectByUserId(userId);
    }


}
