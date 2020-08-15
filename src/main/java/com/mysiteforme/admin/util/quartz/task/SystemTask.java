package com.mysiteforme.admin.util.quartz.task;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Sets;
import com.mysiteforme.admin.entity.*;
import com.mysiteforme.admin.service.*;
import com.mysiteforme.admin.util.SpringContextHolder;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.util.ThreadContext;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.apache.shiro.mgt.SecurityManager;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wangl on 2018/1/26.
 * todo: 系统定时任务
 */
@Component("systemTask")
public class SystemTask {
    private static Log log = LogFactory.get();

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private BlogArticleService blogArticleService;

    @Autowired
    protected UserService userService;

    @Autowired
    protected SiteService siteService;

    @Value("#{${weight}}")
    private int weightPerPerson;

    /**
     * 同步文章点击量
     * @param params
     */
    public void  synchronizationArticleView(String params){
        ValueOperations<String, Object> operations=redisTemplate.opsForValue();
        EntityWrapper<BlogArticle> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        List<BlogArticle> list = blogArticleService.selectList(wrapper);
        for (BlogArticle article : list){
            String key = "article_click_id_"+article.getId();
            if(redisTemplate.hasKey(key)){
                Integer count = (Integer)operations.get(key);
                if(count > 0){
                    article.setClick(blogArticleService.getArticleClick(article.getId()));
                    if(StringUtils.isNotBlank(params)){
                        article.setUpdateId(Long.valueOf(params));
                    }
                    blogArticleService.updateById(article);
                }
            }
        }
    }

    /**
     * 生成文章搜索索引
     */
    public void createArticleIndex(String params) {
        blogArticleService.createArticlIndex();
    }



    @Resource
    org.apache.shiro.mgt.SecurityManager securityManager;


}
