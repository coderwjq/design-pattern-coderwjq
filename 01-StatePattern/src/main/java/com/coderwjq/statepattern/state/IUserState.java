package com.coderwjq.statepattern.state;

import android.content.Context;

/**
 * @Created by coderwjq on 2017/6/3 17:14.
 * @Desc
 */

public interface IUserState {
    void forward(Context context);

    void comment(Context context);

    void logout(Context context);

    void login(Context context);
}
