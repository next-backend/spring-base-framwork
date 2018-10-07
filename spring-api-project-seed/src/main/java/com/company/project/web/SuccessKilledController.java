package com.company.project.web;

import com.company.project.core.PageResult;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.entity.SuccessKilled;
import com.company.project.service.SuccessKilledService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2018/10/05.
 */
@RestController
@RequestMapping("/success/killed")
public class SuccessKilledController {
    @Resource
    private SuccessKilledService successKilledService;

    @PostMapping
    public Result add(@RequestBody SuccessKilled successKilled) {
        successKilledService.save(successKilled);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        successKilledService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody SuccessKilled successKilled) {
        successKilledService.update(successKilled);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        SuccessKilled successKilled = successKilledService.findById(id);
        return ResultGenerator.genSuccessResult(successKilled);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer pageNum, @RequestParam(defaultValue = "0") Integer pageSize) {
        Page page = PageHelper.startPage(pageNum, pageSize);
        List<SuccessKilled> data = successKilledService.findAll();
        PageResult<List<SuccessKilled>> result = new PageResult<>();
        result.setResult(data);
        result.setPageNum(page.getPageNum());
        result.setPageSize(page.getPageSize());
        result.setTotal(page.getTotal());
        return ResultGenerator.genSuccessResult(result);
    }
}
