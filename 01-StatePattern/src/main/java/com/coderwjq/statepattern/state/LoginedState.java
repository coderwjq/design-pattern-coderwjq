package com.coderwjq.statepattern.state;

import android.content.Context;
import android.widget.Toast;

import com.coderwjq.statepattern.LoginContext;

/**
 * @Created by coderwjq on 2017/6/3 17:20.
 * @Desc 已登录状态
 */

public class LoginedState implements IUserState {

    @Override
    public void forward(Context context) {
        Toast.makeText(context, "转发成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void comment(Context context) {
        Toast.makeText(context, "评论成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void logout(Context context) {
        // 设置用户状态为未登录
        LoginContext.getLoginContext().setUserState(new LogoutState());

        Toast.makeText(context, "注销成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void login(Context context) {
        Toast.makeText(context, "别闹，当前已经登录了啊", Toast.LENGTH_SHORT).show();
    }

}
