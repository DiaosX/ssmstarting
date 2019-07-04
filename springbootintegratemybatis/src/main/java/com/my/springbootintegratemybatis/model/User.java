package com.my.springbootintegratemybatis.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "用户信息")
public class User {

    @ApiModelProperty(value = "ID", dataType = "String", name = "ID", example = "1")
    public Integer id;
    @ApiModelProperty(value = "name", notes = "cccc", dataType = "String", name = "name", example = "user")
    public String name;
    @ApiModelProperty(value = "description", dataType = "String", name = "description", example = "description")
    public String description;
    @ApiModelProperty(value = "age", dataType = "Integer", name = "age", example = "1")
    public Integer age;
    @ApiModelProperty(value = "sex", dataType = "Boolean", name = "sex", example = "1")
    public boolean sex;
    @ApiModelProperty(value = "remark", dataType = "String", name = "remark", example = "remark")
    public String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
