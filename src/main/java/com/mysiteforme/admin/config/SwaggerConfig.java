package com.mysiteforme.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger 接口配置
 *
 * @author zhupan
 * @date 2020-08-15
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createInterRestApi() {
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        Parameter p = ticketPar.name("Authorization").description("用户令牌")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(true).build();
//        pars.add(p);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(innerApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mysiteforme.admin.controller.front"))
                .paths(PathSelectors.any())
                .build().groupName("前端服务接口");
    }

    @Bean
    public Docket createOuterRestApi() {
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        Parameter p = ticketPar.name("Authorization").description("用户令牌")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(true).build();
//        pars.add(p);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(outerApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mysiteforme.admin.controller.wechat"))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(pars).groupName("微信服务接口");
    }

    private ApiInfo outerApiInfo() {
        return new ApiInfoBuilder()
                .title("微信服务接口")
                .description("<strong>微信服务接口</strong>")
                .version("1.0.0")
                .build();
    }

    private ApiInfo innerApiInfo() {
        return new ApiInfoBuilder()
                .title("前端服务接口")
                .description("<strong>前端服务接口</strong>")
                .version("1.0.0")
                .build();
    }

}