package com.mysiteforme.admin.base;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页
 * @author zhupan
 * @date 2020-08-15
 */
@Data
public class BasePage implements Serializable {

    private int pageNum = 1;
    private int pageSize = 20;

}
