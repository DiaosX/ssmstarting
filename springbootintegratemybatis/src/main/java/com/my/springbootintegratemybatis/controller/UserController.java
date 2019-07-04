package com.my.springbootintegratemybatis.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.springbootintegratemybatis.Service.UserService;
import com.my.springbootintegratemybatis.common.CommonResponse;
import com.my.springbootintegratemybatis.common.PageResult;
import com.my.springbootintegratemybatis.model.SearchUserRequest;
import com.my.springbootintegratemybatis.model.User;
import com.my.springbootintegratemybatis.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "用户API")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiOperation(value = "创建用户")
    public CommonResponse<Boolean> create(@RequestBody User user) {
        CommonResponse<Boolean> response = new CommonResponse<Boolean>();
        int result = this.userRepository.addUser(user);
        if (result > 0) {
            response.setSuccess(true);
            response.setCode(200);
            response.setResult(true);
        } else {
            response.setSuccess(false);
            response.setErrorMessage("创建用户成功.");
        }
        return response;
    }

    @RequestMapping(value = "/createWithTrans", method = RequestMethod.POST)
    @ApiOperation(value = "事务创建用户")
    public CommonResponse<Boolean> createWithTrans(@RequestBody User user) {
        CommonResponse<Boolean> response = new CommonResponse<Boolean>();
        int result = this.userService.addUser(user);
        if (result > 0) {
            response.setSuccess(true);
            response.setCode(200);
            response.setResult(true);
        } else {
            response.setSuccess(false);
            response.setErrorMessage("创建用户成功.");
        }
        return response;
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ApiOperation(value = "修改用户")
    public CommonResponse<String> modify(@RequestBody User user) {
        CommonResponse<String> response = new CommonResponse<String>();
        int result = this.userRepository.updateById(user);
        if (result > 0) {
            response.setSuccess(true);
            response.setCode(200);
            response.setResult("修改成功.");
        } else {
            response.setSuccess(false);
            response.setErrorMessage("修改用户成功.");
        }
        return response;
    }

    @RequestMapping(value = "/modifyWithTrans", method = RequestMethod.POST)
    @ApiOperation(value = "事务修改用户")
    public CommonResponse<String> modifyWithTrans(@RequestBody User user) {
        CommonResponse<String> response = new CommonResponse<String>();
        int result = this.userService.modifyUser(user);
        if (result > 0) {
            response.setSuccess(true);
            response.setCode(200);
            response.setResult("修改成功.");
        } else {
            response.setSuccess(false);
            response.setErrorMessage("修改用户成功.");
        }
        return response;
    }

    @RequestMapping(value = "getUser/{id}", method = {RequestMethod.GET})
    @ApiOperation(value = "获取用户")
    public CommonResponse<User> getUser(@PathVariable int id) {
        CommonResponse<User> response = new CommonResponse<User>();
        User user = this.userRepository.findById(id);
        response.setResult(user);
        response.setSuccess(true);
        return response;
    }

    @RequestMapping(value = "getAllUser", method = {RequestMethod.GET})
    @ApiOperation(value = "获取所有用户")
    public CommonResponse<List<User>> getAllUser() {
        CommonResponse<List<User>> response = new CommonResponse<List<User>>();
        List<User> users = this.userRepository.findAllUser();
        response.setResult(users);
        response.setSuccess(true);
        response.setPageResult(null);
        return response;
    }

    @RequestMapping(value = "deleteUser/{id}", method = {RequestMethod.GET})
    @ApiOperation(value = "删除用户")
    public CommonResponse<Boolean> deleteUser(@PathVariable("id") int id) {
        CommonResponse<Boolean> response = new CommonResponse<Boolean>();
        Integer result = this.userRepository.deleteById(id);
        if (result > 0) {
            response.setResult(true);
            response.setSuccess(true);
        } else {
            response.setResult(false);
            response.setSuccess(false);
        }
        return response;
    }


    @RequestMapping(value = "findUsersByPage", method = {RequestMethod.GET})
    @ApiOperation(value = "分页获取用户")
    public CommonResponse<User> findUsersByPage(@RequestParam("pageIndex") int pageIndex, @RequestParam("pageSize") int pageSize) {
        CommonResponse<User> response = new CommonResponse<User>();
        PageHelper.startPage(pageIndex, pageSize);
        List<User> users = this.userRepository.findAllUser();
        PageInfo<User> pagedUsers = new PageInfo<>(users);
        PageResult<User> userList = new PageResult<User>();
        userList.setTotal(pagedUsers.getTotal());
        userList.setItems(pagedUsers.getList());
        response.setPageResult(userList);
        response.setSuccess(true);
        return response;
    }

    @RequestMapping(value = "findUsersByConditions", method = {RequestMethod.POST})
    @ApiOperation(value = "分页获取用户")
    public CommonResponse<User> findUsersByConditions(@RequestBody SearchUserRequest request) {
        CommonResponse<User> response = new CommonResponse<>();
        PageHelper.startPage(request.getPageIndex(), request.getPageSize());
        List<User> users = this.userRepository.findUsersByConditions(request.getCondition());
        PageInfo<User> pagedUsers = new PageInfo<>(users);
        PageResult<User> userList = new PageResult<User>();
        userList.setTotal(pagedUsers.getTotal());
        userList.setItems(pagedUsers.getList());
        response.setPageResult(userList);
        response.setSuccess(true);
        return response;
    }
}
