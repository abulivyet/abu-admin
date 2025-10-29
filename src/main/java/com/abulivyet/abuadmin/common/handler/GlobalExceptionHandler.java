package com.abulivyet.abuadmin.common.handler;

import com.abulivyet.abuadmin.common.exception.ServiceException;
import com.abulivyet.abuadmin.common.response.ApiResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.sql.SQLException;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 捕获所有未处理异常
     */
    @ExceptionHandler(Exception.class)
    public ApiResponse<?> handleException(Exception e) {
        e.printStackTrace(); // 控制台打印异常，方便开发调试
        return ApiResponse.failure("系统异常：" + e.getMessage());
    }

    /**
     * 捕获自定义业务异常
     */
    @ExceptionHandler(ServiceException.class)
    public ApiResponse<?> handleServiceException(ServiceException e) {
        return ApiResponse.failure(e.getCode(), e.getMessage());
    }

    /**
     * 捕获参数类型错误异常
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ApiResponse<?> handleTypeMismatch(MethodArgumentTypeMismatchException e) {
        String msg = String.format("参数类型错误：%s，应为 %s", e.getName(), e.getRequiredType().getSimpleName());
        return ApiResponse.failure(msg);
    }

    /**
     * 捕获数据库异常（示例）
     */
    @ExceptionHandler(SQLException.class)
    public ApiResponse<?> handleSQLException(SQLException e) {
        e.printStackTrace();
        return ApiResponse.failure("数据库操作异常：" + e.getMessage());
    }
}
