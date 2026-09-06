package org.example.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.example.mybatisplusdemo.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Test
    void select() {
        System.out.println(userInfoMapper.selectById(2));
    }
    @Test
    void selectByIds() {
        System.out.println(userInfoMapper.selectByIds(List.of(1,2,3,4)));
    }
    @Test
    void insertUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("test");
        userInfo.setPassword("123456");
        userInfo.setAge(21);
        userInfoMapper.insert(userInfo);
    }
    @Test
    void updateUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("1111");
        userInfo.setPassword("126");
        userInfo.setAge(21);
        userInfo.setId(8);
        userInfoMapper.updateById(userInfo);
    }

    @Test
    void testQueryWrapper() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id","username","password","age")
                .eq("age",18)
                .like("username","min");
        System.out.println(userInfoMapper.selectList(queryWrapper));
    }

    @Test
    void testQueryWrapper2() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age",20);
        UserInfo userInfo = new UserInfo();
        userInfo.setDeleteFlag(1);
        userInfoMapper.update(userInfo,queryWrapper);
    }

    @Test
    void testQueryWrapper3() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("age",21);
        userInfoMapper.delete(queryWrapper);
    }

    @Test
    void testUpdateWrapper() {
        UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("age",10)
                .set("delete_flag",1)
                .le("id",4);
        userInfoMapper.update(updateWrapper);
    }

    @Test
    void testUpdateWrapper2() {
        UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.setSql("age=age-5")
                .le("id",4);
        userInfoMapper.update(updateWrapper);
    }

    @Test
    void testLambdaQueryWrapper() {
//        LambdaQueryWrapper<UserInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().select(UserInfo::getId, UserInfo::getUsername, UserInfo::getAge)
                .eq(UserInfo::getAge,18);
        System.out.println(userInfoMapper.selectList(queryWrapper));
    }

    @Test
    void queryUserByCustom() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username","test");
        System.out.println(userInfoMapper.queryUserByCustom(queryWrapper));
    }
}