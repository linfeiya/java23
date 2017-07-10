package com.kaishengit;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * 替代spring配置的类
 * Created by linfeiya on 2017/7/10 0010.
 */
@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class Application {
}
