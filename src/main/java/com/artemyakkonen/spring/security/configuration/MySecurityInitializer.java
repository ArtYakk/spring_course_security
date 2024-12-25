package com.artemyakkonen.spring.security.configuration;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Order(3)
public class MySecurityInitializer extends AbstractSecurityWebApplicationInitializer {

}
