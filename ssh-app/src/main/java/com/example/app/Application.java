package com.example.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * 	@author yangfan
 * 	@date 2018/11/26
 * 	@describe spring boot 项目启动类
 *
 * 	@Configuration 注解用于标识 Application 类是一个配置类
 * 	|----	标注在类上，相当于把该类作为spring的xml配置文件中的<beans>，作用为：配置spring容器(应用上下文)
 * 	|----	配置spring并启动spring容器
 * 	|----	启动容器+@Bean注册Bean
 *	|----	启动容器+@Component注册Bean
 *	|----	使用 AnnotationConfigApplicationContext 注册 AppContext 类的两种方法
 *	|----	配置Web应用程序(web.xml中配置AnnotationConfigApplicationContext)
 *
 * 	@SpringBootApplication 注解用于配置自动扫描注解的包
 * 	|----	scanBasePackages 属性表示扫描的包路径
 * 	|----	exclude 属性表示要排除的类
 *
 * 	@EnableAutoConfiguration
 * 	借助AutoConfigurationImportSelector，可以帮助SpringBoot应用将所有符合条件的@Configuration配置
 * 	都加载到当前SpringBoot创建并使用的IoC容器。
 * 	在AutoConfigurationImportSelector类中可以看到通过 SpringFactoriesLoader.loadFactoryNames()
 * 	把 spring-boot-autoconfigure.jar/META-INF/spring.factories
 * 	中的每一个xxxAutoConfiguration文件都加载到容器中
 * 	@ConditionalOnClass ： classpath中存在该类时起效
 * 	@ConditionalOnMissingClass ： classpath中不存在该类时起效
 * 	@ConditionalOnBean ： DI容器中存在该类型Bean时起效
 * 	@ConditionalOnMissingBean ： DI容器中不存在该类型Bean时起效
 * 	@ConditionalOnSingleCandidate ： DI容器中该类型Bean只有一个或@Primary的只有一个时起效
 * 	@ConditionalOnExpression ： SpEL表达式结果为true时
 * 	@ConditionalOnProperty ： 参数设置或者值一致时起效
 * 	@ConditionalOnResource ： 指定的文件存在时起效
 * 	@ConditionalOnJndi ： 指定的JNDI存在时起效
 * 	@ConditionalOnJava ： 指定的Java版本存在时起效
 * 	@ConditionalOnWebApplication ： Web应用环境下起效
 * 	@ConditionalOnNotWebApplication ： 非Web应用环境下起效
 *
 *
 * Application 类通过实现 CommandLineRunner 或者 ApplicationRunner ，
 * 实现重写 run 方法，执行一些预加载数据
 *
 */
@Configuration
@SpringBootApplication(
		scanBasePackages = {"com.example"},
		exclude = {
				JpaRepositoriesAutoConfiguration.class,
				HibernateJpaAutoConfiguration.class
		}
)
public class Application implements CommandLineRunner {

	private static final Logger LOGGER  = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		/**
		 * Spring Boot的SpringApplication类，用以启动一个Spring应用，
		 * 实质上是为Spring应用创建并初始化Spring上下文
		 */
		SpringApplication app = new SpringApplication(Application.class);
		/**
		 * 读取 /src/main/resources 目录下的 banner.txt 以定制启动LOGO
		 */
		app.setBannerMode(Banner.Mode.CONSOLE);
		/**
		 * 启动Spring应用
		 */
		app.run(args);
	}

	@Override
	public void run(String... args){
		LOGGER.info("com.example application is running...");
	}
}
