package com.mysiteforme.admin.controller.wechat;

import com.mysiteforme.admin.base.ResponseInvoke;
import com.mysiteforme.admin.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "前端服务接口", tags = "测试接口")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/wechat")
public class WechatTestController {

    private final MenuService menuService;

    @ApiOperation(value = "获取菜单列表", notes = "对接人：zhupan")
    @RequestMapping(value = "getMenus", method = RequestMethod.GET)
    public Object getMenus() {
        return ResponseInvoke.ok(menuService.showTreeMenus());
    }

}
