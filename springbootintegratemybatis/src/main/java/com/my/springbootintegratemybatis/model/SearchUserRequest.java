package com.my.springbootintegratemybatis.model;

import com.my.springbootintegratemybatis.common.CommonRequest;

public class SearchUserRequest extends CommonRequest {

    public SearchUserCondition condition;

    public SearchUserCondition getCondition() {
        return condition;
    }

    public void setCondition(SearchUserCondition condition) {
        this.condition = condition;
    }
}
