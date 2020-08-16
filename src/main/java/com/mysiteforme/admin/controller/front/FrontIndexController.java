package com.mysiteforme.admin.controller.front;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 前端入口
 */
@Api(value = "前端入口", tags = "网站信息", hidden = true)
@Controller
@RequiredArgsConstructor
@RequestMapping("/front")
public class FrontIndexController {

    @ApiOperation(value = "首页", hidden = true)
    @RequestMapping(value = {"", "/", "index"})
    public Object index() {
        return "/front/index";
    }

}
