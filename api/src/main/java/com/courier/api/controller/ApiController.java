package com.courier.api.controller;


import com.courier.db.entity.Apiconfig;
import com.courier.db.mapper.ApiconfigMapper;
import com.courier.redis.RedisConfig;
import com.courier.sdk.core.Result;
import com.courier.sdk.utils.ResultUtil;
import com.courier.service.ApiConfigService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class ApiController {

        @Autowired
        RedisConfig redisConfig;

        @Value("${ip}")
        private String ip;

        @Autowired
        private ApiConfigService apiConfigService;

        @RequestMapping("indexpage")
        public Result indexpage(){
            //List<Apiconfig> all = apiconfigMapper.selectAll();

            PageInfo pageInfo = apiConfigService.selectPage(1,20,null);
            return ResultUtil.getSuccessResult(pageInfo);
        }

    @RequestMapping("index")
    public Result index(){
        List<Apiconfig> apiconfigPageInfo = apiConfigService.select(null);
        return ResultUtil.getSuccessResult(apiconfigPageInfo);
    }
}
