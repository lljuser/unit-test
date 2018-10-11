package com.demo.utest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = {"com.demo"})
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**","/static/");
    }

   /* @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/view/",".jsp");
        registry.order(0);
    }*/


   @Bean
   public InternalResourceViewResolver jspviewResolver(){
       InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
       viewResolver.setPrefix("/WEB-INF/view/");
       viewResolver.setSuffix(".jsp");
       return  viewResolver;
   }

/*
    @Bean
    public ThymeleafViewResolver thyviewResolver(TemplateEngine templateEngine){
        ThymeleafViewResolver viewResolver=new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine);
        viewResolver.setViewClass(ThymeleafView.class);
        viewResolver.setOrder(1);
        return  viewResolver;
    }*/



   /* @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter=new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform("org.hibernate.dialect.HSQLDialect");
        return adapter;
    }

    *//*jpa setting with server container no Persistence.xml*//*
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,JpaVendorAdapter jpaVendorAdapter){
        //LocalEntityManagerFactoryBean 基于应用程序管理类型的持久化对象容器 配置Persistence.xml
        LocalContainerEntityManagerFactoryBean manager=new LocalContainerEntityManagerFactoryBean();
        manager.setDataSource(dataSource);
        manager.setJpaVendorAdapter(jpaVendorAdapter);
        manager.setPackagesToScan("com.cnabs.portal.domain");
        manager.setPersistenceUnitName("MyDS");
        return manager;
    }




    @Bean
    //确保spring 可以识别persistenceunit和 PersistenceContext注解
    // 这两个注解并不是SPRINGR的部分，是JPA的标准
    public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor(){
        return  new PersistenceAnnotationBeanPostProcessor();
    }

    @Bean //JPA 持久化异常统一处理 类似SQL的异常统一处理
    public BeanPostProcessor persistenceTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }*/
}
