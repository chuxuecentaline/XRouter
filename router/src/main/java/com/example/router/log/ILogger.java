package com.example.router.log;

/**
 *
 *
 * @Author: cherish
 * @CreateDate: 2019/2/26 15:44
 */

public interface ILogger {
    void e(String tag,String message);
    void i(String tag,String message);
    void w(String tag,String message);
    void d(String tag,String message);
}
