package com.company.project.service.impl;

import com.company.project.core.AbstractService;
import com.company.project.dao.SuccessKilledMapper;
import com.company.project.entity.SuccessKilled;
import com.company.project.service.SuccessKilledService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/10/05.
 */
@Service
public class SuccessKilledServiceImpl extends AbstractService<SuccessKilled> implements SuccessKilledService {
    @Resource
    private SuccessKilledMapper successKilledMapper;

}
