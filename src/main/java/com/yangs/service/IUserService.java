package com.yangs.service;

import com.yangs.modal.vo.UserVo;

/**
 * Created by Ytadpole on 2018/2/24.
 * 用户接口
 */
public interface IUserService {
    UserVo login(String username, String password);
}
