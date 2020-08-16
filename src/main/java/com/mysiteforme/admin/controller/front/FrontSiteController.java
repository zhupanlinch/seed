package com.mysiteforme.admin.controller.front;

import com.mysiteforme.admin.base.ResponseInvoke;
import com.mysiteforme.admin.service.MenuService;
import com.mysiteforme.admin.service.SiteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "前端服务接口", tags = "网站信息")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/front/site")
public class FrontSiteController {

    private final SiteService siteService;

    @ApiOperation(value = "查询网站信息", notes = "对接人：zhupan")
    @RequestMapping(value = "getSiteInfo", method = RequestMethod.GET)
    public Object getMenus(@ApiParam("整形参数：1，2") @RequestParam(name = "arg", required = false)Integer arg) {
        return ResponseInvoke.ok(siteService.getCurrentSite());
    }

}
