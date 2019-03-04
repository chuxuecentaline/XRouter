package com.example.router;

/**
 *
 * @Author: cherish
 * @CreateDate: 2019/2/26 15:29
 */

public interface ActionCallback<T> {
    void onInterrupt();

    void onResult(T result);
}
