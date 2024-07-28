package com.interstellar.service;

import com.interstellar.bean.Result;
import com.interstellar.bean.User;
import com.interstellar.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.interstellar.debug.debuger;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 注册
     * @param user 参数封装
     * @return Result
     */
    public Result regist(User user) {
        Result result = new Result();
        debuger(1);
        result.setSuccess(false);
        debuger(2);
        result.setDetail(null);
        debuger(3);
        try {
            User existUser = userMapper.findUserByUserName(user.getUserName());
            debuger(4);
            if(existUser != null){
                //如果用户名已存在
                debuger(5);
                result.setMsg("用户名已存在");
                debuger(6);

            }else{
                debuger(7);
                userMapper.regist(user);
                debuger(8);
                //System.out.println(user.getId());
                result.setMsg("注册成功");
                debuger(9);
                result.setSuccess(true);
                debuger(10);
                result.setDetail(user);
                debuger(11);
            }
        } catch (Exception e) {
            debuger(12);
            result.setMsg(e.getMessage());
            debuger(13);
            e.printStackTrace();
            debuger(14);
        }
        debuger(15);
        return result;
    }
    /**
     * 登录
     * @param user 用户名和密码
     * @return Result
     */
    public Result login(User user) {
        Result result = new Result();
        debuger(16);
        result.setSuccess(false);
        debuger(17);
        result.setDetail(null);
        debuger(18);
        try {
            Long userId= userMapper.login(user);
            debuger(19);
            if(userId == null){
                debuger(20);
                result.setMsg("用户名或密码错误");
                debuger(21);
            }else{
                debuger(22);
                result.setMsg("登录成功");
                debuger(23);
                result.setSuccess(true);
                debuger(24);
                user.setUserId(userId);
                debuger(25);
                result.setDetail(user);
                debuger(26);
            }
        } catch (Exception e) {
            debuger(27);
            result.setMsg(e.getMessage());
            debuger(28);
            e.printStackTrace();
        }
        debuger(29);
        return result;
    }
}
