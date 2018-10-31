package com.courier.api;


import com.courier.db.entity.Apiconfig;
import com.courier.db.mapper.ApiconfigMapper;
import com.courier.sdk.core.Result;
import com.courier.sdk.utils.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class ApiController {


        @Autowired
        private ApiconfigMapper apiconfigMapper;

        @RequestMapping("index")
        public Result index(){
            //List<Apiconfig> all = apiconfigMapper.selectAll();

            PageHelper.startPage(1,20);
            PageInfo<Apiconfig> apiconfigPageInfo = new PageInfo<Apiconfig>(apiconfigMapper.selectAll());
            return ResultUtil.getSuccessResult(apiconfigPageInfo);
        }

}
