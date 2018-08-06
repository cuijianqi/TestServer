package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * 
 * @author cjq
 * 
 * @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息",produces = "application/json")
 * @ApiResponses(value = {@ApiResponse(code = 405,message = "Invalid input",response = Integer.class)})
 * @ApiImplicitParam(name = "id",value = "用户ID",dataType = "int",paramType = "path")
 * @RequestMapping(value="/users/{id}", method= RequestMethod.GET)
 * @ApiImplicitParams({
        @ApiImplicitParam(name = "id",value = "用户ID",paramType = "path",dataType = "int"),
        @ApiImplicitParam(name = "userName",value = "用户名称",paramType = "form",dataType = "string")
		})
		paramType 有五个可选值 ： path 以地址的形式提交数据, 
								query 直接跟参数完成自动映射赋值, 
								body 以流的形式提交 仅支持POST,
								header 参数在request headers 里边提交, 
								form 以form表单的形式提交 仅支持POST
 *
 */
@Configuration
@EnableSwagger2//通过注解EnableSwagger2声明Swagger的可用性
public class Swagger2 {

	 @Bean
	    public Docket createRestApi() {
//		 Docket的select()方法会提供给swagger-springmvc framework的一个默认构造器（ApiSelectorBuilder），
//		 这个构造器为配置swagger提供了一系列的默认属性和便利方法。
	        return new Docket(DocumentationType.SWAGGER_2)
	                .apiInfo(apiInfo())
	                .select()// 选择那些路径和api会生成document
	                //需扫描的包路径
	                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
	                .paths(PathSelectors.any())// 对所有路径进行监控
	                .build();
	    }

	    private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("Spring Boot中使用Swagger2构建RESTful APIs")
	                .description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
	                .termsOfServiceUrl("http://blog.didispace.com/")
	                .contact("cuijianqi")
	                .version("1.0")
	                .build();
	    }
}
