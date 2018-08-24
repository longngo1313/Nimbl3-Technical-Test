package com.example.longnv.nimbl3_test.base.taskmanager;

import android.os.Process;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.concurrent.ThreadFactory;

/**
 * Created by Vu Long on 8/24/2018.
 * nguyenvulong2002@gmail.com
 */
public class PriorityThreadFactory implements ThreadFactory {

    private static final String TAG = "PriorityThreadFactory";
    private final int mThreadPriority;

    public PriorityThreadFactory(int threadPriority) {
        mThreadPriority = threadPriority;
    }

    @Override
    public Thread newThread(@NonNull final Runnable runnable) {
        Runnable wrapperRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Process.setThreadPriority(mThreadPriority);
                } catch (Throwable t) {
                    Log.e(TAG, "run: "+t.toString() );
                }
                runnable.run();
            }
        };
        return new Thread(wrapperRunnable);
    }

}
