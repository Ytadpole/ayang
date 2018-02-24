package com.yangs.service.impl;

import com.yangs.dao.UserVoMapper;
import com.yangs.modal.vo.UserVo;
import com.yangs.modal.vo.UserVoExample;
import com.yangs.service.IUserService;
import com.yangs.utils.PWDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Ytadpole on 2018/2/24.
 */
@Service
public class UserService implements IUserService{
    @Resource
    private UserVoMapper userVoMapper;

    @Override
    public UserVo login(String username, String password) {
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            // TODO: 2018/2/24
            return null;
        }
        UserVoExample example = new UserVoExample();
        UserVoExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);

        List<UserVo> userList = userVoMapper.selectByExample(example);
        if(userList.size() <= 0){
            // TODO: 2018/2/24
            return null;
        }
        criteria.andPasswordEqualTo(PWDUtil.MD5encode(username + password));
        List<UserVo> userInfo = userVoMapper.selectByExample(example);
        if (userInfo.size() != 1){
            // TODO: 2018/2/24
            return null;
        }
        return userInfo.get(0);
    }
}
