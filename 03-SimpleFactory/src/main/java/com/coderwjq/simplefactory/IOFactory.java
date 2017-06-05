package com.coderwjq.simplefactory;

/**
 * @Created by coderwjq on 2017/6/5 11:35.
 * @Desc
 */

public class IOFactory {
    public static <T extends IOHandler> T getIOHandler(Class<T> clz) {
        IOHandler handler = null;

        try {
            handler = (IOHandler) Class.forName(clz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return (T) handler;
    }
}
