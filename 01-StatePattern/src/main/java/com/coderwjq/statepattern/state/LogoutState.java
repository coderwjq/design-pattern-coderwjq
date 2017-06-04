package com.coderwjq.statepattern.state;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.coderwjq.statepattern.LoginActivity;
import com.coderwjq.statepattern.LoginContext;
import com.coderwjq.statepattern.MainActivity;

/**
 * @Created by coderwjq on 2017/6/3 17:20.
 * @Desc 未登录状态
 */

public class LogoutState implements IUserState {

    @Override
    public void forward(Context context) {
        gotoLoginActivity(context);
    }

    @Override
    public void comment(Context context) {
        gotoLoginActivity(context);
    }

    @Override
    public void logout(Context context) {
        Toast.makeText(context, "当前未登录", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void login(Context context) {
        LoginContext.getLoginContext().setUserState(new LoginedState());

        Toast.makeText(context, "登陆成功", Toast.LENGTH_SHORT).show();

        gotoMainActivity(context);
    }

    private void gotoLoginActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        Activity activity = (Activity) context;
        activity.startActivity(intent);
        context.startActivity(intent);
    }

    private void gotoMainActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        Activity activity = (Activity) context;
        activity.startActivity(intent);
        activity.finish();
    }
}
