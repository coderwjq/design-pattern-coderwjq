package com.coderwjq.mementopattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created by coderwjq on 2017/6/5 16:18.
 * @Desc
 */

public class NoteCaretaker {
    // 最大存储数量
    private static final int MAX = 10;

    // 存储记录
    private List<Mementor> mMementors = new ArrayList<>(MAX);

    private int mIndex = 0;

    /**
     * 保存当前状态到记录列表
     *
     * @param mementor
     */
    public void saveMementor(Mementor mementor) {
        if (mMementors.size() > MAX) {
            mMementors.remove(0);
        }

        mMementors.add(mementor);
        mIndex = mMementors.size() - 1;
    }

    /**
     * @return 上一个存档信息
     */
    public Mementor getPreMementor() {
        mIndex = mIndex > 0 ? --mIndex : mIndex;
        return mMementors.get(mIndex);
    }

    /**
     * @return 下一个存档信息
     */
    public Mementor getNextMementor() {
        mIndex = mIndex < mMementors.size() - 1 ? ++mIndex : mIndex;
        return mMementors.get(mIndex);
    }

    /**
     * @return 撤销按钮是否可用
     */
    public boolean isPreButtonEnable() {
        return mIndex != 0;
    }

    /**
     * @return 回撤按钮是否可用
     */
    public boolean isNextButtonEnable() {
        return mIndex != mMementors.size() - 1;
    }
}
