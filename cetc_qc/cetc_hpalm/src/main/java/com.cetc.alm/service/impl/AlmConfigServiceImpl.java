package com.cetc.alm.service.impl;

import com.cetc.alm.dao.AlmConfigDao;
import com.cetc.alm.service.AlmConfigService;
import com.cetc.common.core.entity.Result;
import com.cetc.common.core.entity.StatusCode;
import com.cetc.model.hpalm.AlmConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlmConfigServiceImpl implements AlmConfigService {

    @Autowired
    private AlmConfigDao almConfigDao;
    @Override
    public Result saveAlmConfig(AlmConfig almConfig) {
        if(almConfig.getId()!=null){
            almConfigDao.updateAlmConfig(almConfig);
        }else {
            almConfigDao.saveAlmConfig(almConfig);
        }
        return new Result(true, StatusCode.OK,"修改alm配置成功");
    }

    @Override
    public Result findAlmConfig() {
        AlmConfig almConfig = almConfigDao.findAlmConfig();
        return new Result(true,StatusCode.OK,"OK",almConfig);
    }
}
