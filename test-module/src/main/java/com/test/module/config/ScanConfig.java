package com.test.module.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"com.test"})
@Configuration
public class ScanConfig {
}
