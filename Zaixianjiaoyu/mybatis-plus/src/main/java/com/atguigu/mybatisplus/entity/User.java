package com.atguigu.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    @TableId(value = "id",type = IdType.ID_WORKER)
    private Long id;

    private String name;
    private Integer age;
    private String email;
    @TableField(fill= FieldFill.INSERT)
    private Date createTime;
    @TableField(fill= FieldFill.UPDATE)
    private Date updateTime;
}
