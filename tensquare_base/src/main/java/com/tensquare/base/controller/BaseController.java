package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import eneity.PageResult;
import eneity.Result;
import eneity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  跨域是什么？浏览器从一个域名的网页去请求另一个域名的资源时，域名、端口、 协议任一不同，都是跨域 。
 *  我们是采用前后端分离开发的，也是前后端分离部署的，必 然会存在跨域问题。
 *  怎么解决跨域？很简单，只需要在controller类上添加注解 @CrossOrigin 即可！这个注解其实是CORS的实现。
 */
@RestController
@RequestMapping("/label")
@CrossOrigin
public class BaseController {

    @Autowired
    private LabelService labelService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){

        return new Result(true, StatusCode.OK,"查询所有label成功",labelService.findAll());
    }

    @RequestMapping(value = "/{labelId}",method = RequestMethod.GET)
    public Result findById(@PathVariable String labelId){
        return new Result(true, StatusCode.OK,"根据labelId查询label成功",labelService.findById(labelId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label){
        labelService.save(label);
        return new Result(true, StatusCode.OK,"label新增成功");
    }

    @RequestMapping(value = "/{labelId}",method = RequestMethod.PUT)
    public Result update(@PathVariable String labelId, @RequestBody Label label){
        label.setId(labelId);
        labelService.update(label);
        return new Result(true, StatusCode.OK,"label修改成功");
    }

    @RequestMapping(value = "/{labelId}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String labelId){
        labelService.delete(labelId);
        return new Result(true, StatusCode.OK,"label删除成功");
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public Result findSearch(@RequestBody Label label){
        List<Label> list = labelService.findSearch(label);
        return new Result(true, StatusCode.OK,"label查询成功",list);
    }

    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)
    public Result pageQuray(@RequestBody Label label, @PathVariable int page, @PathVariable int size){
        Page<Label> pageData = labelService.pageQuray(label,page,size);
        return new Result(true, StatusCode.OK,"label查询成功",new PageResult<Label>(pageData.getTotalElements(),pageData.getContent()));
    }

}
