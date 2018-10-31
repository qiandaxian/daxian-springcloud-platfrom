package ${basePackage}.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import ${commonsPackage}.core.Result;
import ${commonsPackage}.core.ResultUtil;
import ${basePackage}.model.entity.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;


/**
* Created by ${author} on ${date}.
*/
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {
    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping("/add")
    public Result add(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.insertSelective(${modelNameLowerCamel});
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        ${modelNameLowerCamel}Service.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.updateByPrimaryKeySelective(${modelNameLowerCamel});
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.selectByPrimaryKey(id);
        return ResultUtil.getSuccessResult(${modelNameLowerCamel});
    }

    @PostMapping("/list")
    public Result list(@RequestBody ${modelNameUpperCamel}Vo ${modelNameLowerCamel}Vo) {
//      List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.select(null);
		return ResultUtil.getSuccessResult(null);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody ${modelNameUpperCamel}Vo ${modelNameLowerCamel}Vo) {


//		String orderBy = sort + " " + order;
//		PageInfo<${modelNameUpperCamel}> pageInfo = ${modelNameLowerCamel}Service.selectPage(page, size, null);
//		return ResultUtil.getSuccessResult(pageInfo);
		
		return ResultUtil.getSuccessResult(null);
	}
}
