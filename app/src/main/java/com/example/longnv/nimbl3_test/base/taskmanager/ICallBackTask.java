package com.example.longnv.nimbl3_test.base.taskmanager;

/**
 * Created by Vu Long on 8/24/2018.
 * nguyenvulong2002@gmail.com
 */
public interface ICallBackTask {
    void Success(Object data);
    void Error(Exception e);
}
