package com.TCU2.Config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfiguration {

    public Docket docket(){
      new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder().description("核酸检测信息综合服务平台API接口文档")
                        .termsOfServiceUrl("https://hsjc.tcu.edu.cn")
                        .version("V-2.0").build())
                .groupName("核酸检测小组")
                .host("https://hsjc.tcu.edu.cn/**")
                .select()
                .apis(RequestHandlerSelectors.any())
                .build();
        return docket();

    }

    public void AddResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
