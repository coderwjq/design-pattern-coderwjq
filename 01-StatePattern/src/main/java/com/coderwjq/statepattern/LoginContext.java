package com.coderwjq.statepattern;

import android.content.Context;

import com.coderwjq.statepattern.state.IUserState;
import com.coderwjq.statepattern.state.LogoutState;

/**
 * @Created by coderwjq on 2017/6/3 17:25.
 * @Desc 用户接口和状态的管理类
 */

public class LoginContext {
    private static LoginContext sLoginContext = new LoginContext();
    private IUserState mUserState = new LogoutState();

    private LoginContext() {

    }

    public static LoginContext getLoginContext() {
        return sLoginContext;
    }

    public void setUserState(IUserState state) {
        mUserState = state;
    }

    public void forward(Context context) {
        mUserState.forward(context);
    }

    public void comment(Context context) {
        mUserState.comment(context);
    }

    public void logout(Context context) {
        mUserState.logout(context);
    }

    public void login(Context context) {
        mUserState.login(context);
    }
}
