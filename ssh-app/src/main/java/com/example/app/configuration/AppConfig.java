package com.example.app.configuration;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangfan
 * @date 2018/11/26
 * @describe AppConfig
 */
@Configuration
public class AppConfig extends WebMvcConfigurationSupport {

    private static final String[] RESOURCE_LOCATIONS = {
            "classpath:/static/",
            "classpath:/public/",
            "classpath:/resources/",
            "classpath:/META-INF/resources/"
    };

    private static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         *  静态资源路径配置
         */
        registry.addResourceHandler("/**").addResourceLocations(RESOURCE_LOCATIONS);

        super.addResourceHandlers(registry);
    }

    /**
     *  实际开发中会涉及到大量的页面跳转。我们可以重写addVeiwControllers来简化页面的跳转
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /**
         *  设置默认跳转地址
         */
        registry.addRedirectViewController("/", "/swagger-ui.html");

        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);

        super.addViewControllers(registry);
    }

    /**
     *  更改HttpMessageConverters使用FastJson配置
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();

        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        /**
         *  编码格式
         */
        fastJsonConfig.setCharset(StandardCharsets.UTF_8);
        /**
         *  日期时间格式化
         */
        fastJsonConfig.setDateFormat(DEFAULT_DATE_TIME_FORMAT);
        /**
         *  response json 格式化
         */
        fastJsonConfig.setSerializerFeatures(
                /**
                 *  是否输出值为null的字段,默认为false
                 */
                SerializerFeature.WriteMapNullValue,
                /**
                 *  List字段如果为null,输出为[],而非null
                 */
                SerializerFeature.WriteNullListAsEmpty,
                /**
                 *  字符类型字段如果为null,输出为"",而非null
                 */
                SerializerFeature.WriteNullStringAsEmpty
                /**
                 *  数值字段如果为null,输出为0,而非null
                 */
                //SerializerFeature.WriteNullNumberAsZero,
                /**
                 *  Boolean字段如果为null,输出为false,而非null
                 */
                //SerializerFeature.WriteNullBooleanAsFalse,
                /**
                 *  如果是true，类中的Get方法对应的Field是transient，序列化时将会被忽略。默认为true
                 */
                //SerializerFeature.SkipTransientField,
                /**
                 *  全局修改日期格式,默认为false
                 */
                //SerializerFeature.WriteDateUseDateFormat
        );
        /**
         *  response 输出为 json 格式
         */
        List<MediaType> fastMediaTypes = new ArrayList<>(Arrays.asList(
                MediaType.APPLICATION_JSON
        ));

        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters(fastJsonHttpMessageConverter);
    }

    /**
     *  用RestTemplateBuilder配置一个RestTemplate
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        RestTemplate restTemplate = builder.build();
        return restTemplate;
    }
}
