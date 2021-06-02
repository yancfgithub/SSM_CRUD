package com.chaofans.controller;

import com.chaofans.pojo.Girl;
import com.chaofans.service.GirlService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/girl")
public class GirlController {

    @Autowired
    private GirlService girlService;

    @GetMapping("page")
    public PageInfo<Girl> page(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "pageSize", required = false,defaultValue = "5") Integer pageSize,
                               Girl girl) {
        PageHelper.startPage(pageNum, pageSize);
        List<Girl> ret = girlService.findByGirlQuery(girl);
        PageInfo<Girl> pageInfo = new PageInfo<>(ret);
        if(pageInfo.getNextPage() == 0) {
            pageInfo.setNextPage(pageNum);
        }
        return pageInfo;
    }

    @GetMapping
    List<Girl> findAll(){
        return girlService.findAll();
    }

    @GetMapping("{id}")
    Girl findById(@PathVariable Integer id){
        return girlService.findById(id);
    }

    @GetMapping("query")
    List<Girl> findByGirlQuery(@RequestBody Girl girl){
        return girlService.findByGirlQuery(girl);
    }

    @PostMapping("save")
    Boolean insertGirl(@RequestBody Girl girl){
        System.out.println(girl);
        Boolean aBoolean = girlService.insertGirl(girl);
        System.out.println("a;;；：：：："+ aBoolean);
        return aBoolean;
    }

    @PostMapping("update")
    Boolean updateGirl(@RequestBody Girl girl){
        System.out.println(girl);
        return girlService.updateGirl(girl);
    }

    @PostMapping("{id}")
    Boolean deleteGirl(@PathVariable Integer id){
        return girlService.deleteGirl(id);
    }
}
