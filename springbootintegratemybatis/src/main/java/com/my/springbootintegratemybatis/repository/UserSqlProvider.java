package com.my.springbootintegratemybatis.repository;

import com.alibaba.druid.util.StringUtils;
import com.my.springbootintegratemybatis.model.SearchUserCondition;
import org.apache.ibatis.jdbc.SQL;


/**
 * 动态拼接sql使用场景
 */
public class UserSqlProvider {

    public String findUsersByConditionsSql(SearchUserCondition condition) {
        //String sqlText = "SELECT * FROM user where 1=1 ";
        //SearchUserCondition condition = (SearchUserCondition) paramMap.get("condition");
        SQL sqlBuilder = new SQL();
        sqlBuilder.SELECT("*").FROM("user");
        if (condition != null) {
            if (condition.age != null && condition.age > 0) {
                sqlBuilder.WHERE("user_age=" + condition.getAge());
            }
            if (!StringUtils.isEmpty(condition.userName)) {
                sqlBuilder.WHERE("user_name like '%" + condition.getUserName() + "%'");
            }
        }
        return sqlBuilder.toString();
    }
}
