package com.test.module.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"com.test"},
        excludeFilters = {
                // 过滤sa-token
                // @ComponentScan.Filter(type = FilterType.REGEX, pattern = {"com.test.auth.satoken.*"})
        }
)
@Configuration
public class ScanConfig {
}
