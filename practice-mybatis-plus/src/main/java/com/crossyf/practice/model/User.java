package com.crossyf.practice.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Created by YangFan.
 * @date 2019/11/14
 * 功能:
 */
@Data
@TableName(value = "t_base_user")
public class User {
    @TableId("id")
    private String id;
    private String username;
    private String password;
}
