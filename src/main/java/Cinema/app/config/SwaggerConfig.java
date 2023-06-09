package Cinema.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

        @Bean
        public Docket customerApi() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("Cinema.app.controller"))
                    .paths(regex("/.*"))
                    .build()
                    .apiInfo(metaData());
        }
        private ApiInfo metaData() {
            return new ApiInfo(
                    "Assessment",
                    "Spring Boot REST API for Assessment",
                    "1.0",
                    "Terms of service",
                    new Contact("Cavid Kazimzada", "https://github.com/cavidk", "cavidc253@gmail.com"),
                    "Apache License Version 2.0",
                    "https://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());

    }
}