package com.example.model.Aspect;

import java.lang.annotation.*;

/**
 * @author yangfan
 * @date 2018/11/29
 * @describe TimeoutLog 注解：用于在请求超时的方法中记录错误日志
 *
 * @Target 定义注解修饰的目标，ElementType.METHOD 表示该注解可修饰方法
 *
 * @Retention 定义注解的生命周期 RetentionPolicy.RUNTIME 表示该注解的级别为运行期级别
 *
 * @Documented 定义注解会被 javadoc 或者其他类似工具文档化
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TimeoutLog {
}
