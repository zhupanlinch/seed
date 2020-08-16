package com.mysiteforme.admin.controller.front;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 前端入口
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/front")
public class FrontIndexController {

    @RequestMapping(value = {"", "/", "index"})
    public Object index() {
        return "/front/index";
    }

}
