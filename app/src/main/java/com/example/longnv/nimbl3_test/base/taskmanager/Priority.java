package com.example.longnv.nimbl3_test.base.taskmanager;

/**
 * Created by Vu Long on 8/24/2018.
 * nguyenvulong2002@gmail.com
 */

/**
 * Priority levels recognized by the request server.
 */
public enum Priority {
    /**
     * NOTE: DO NOT CHANGE ORDERING OF THOSE CONSTANTS UNDER ANY CIRCUMSTANCES.
     * Doing so will make ordering incorrect.
     */

    /**
     * Lowest priority level. Used for prefetches of data.
     */
    LOW,

    /**
     * Medium priority level. Used for warming of data that might soon get visible.
     */
    MEDIUM,

    /**
     * Highest priority level. Used for data that are currently visible on screen.
     */
    HIGH,

    /**
     * Highest priority level. Used for data that are required instantly(mainly for emergency).
     */
    IMMEDIATE
}
