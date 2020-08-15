package com.mysiteforme.admin.controller.front;

import com.mysiteforme.admin.base.ResponseInvoke;
import com.mysiteforme.admin.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "前端服务接口", tags = "测试接口")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/front")
public class FrontTestController {

    private final MenuService menuService;

    @ApiOperation(value = "获取菜单列表", notes = "对接人：zhupan")
    @RequestMapping(value = "getMenus", method = RequestMethod.GET)
    public Object getMenus(@ApiParam("整形参数：1，2") @RequestParam(name = "arg", required = false)Integer arg) {
        System.out.println(arg);
        return ResponseInvoke.ok(menuService.showTreeMenus());
    }

}
