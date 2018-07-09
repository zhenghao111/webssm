1. 作为DispatcherServlet的初始化参数
2. 作为web应用的上下文
```xml
<!-- 为上下文设置默认profile -->
  <context-param>
    <param-name>spring.profiles.default</param-name>
    <param-value>dev</param-value>
  </context-param>

  <!--<servlet>-->
    <!--<servlet-name>appServlet</servlet-name>-->
    <!--&lt;!&ndash; 为Servlet设置profile &ndash;&gt;-->
    <!--<init-param>-->
      <!--<param-name>spring.profiles.default</param-name>-->
      <!--<param-value>dev</param-value>-->
    <!--</init-param>-->
  <!--</servlet>-->
```

3. 作为JNDI条目
4. 作为环境变量
5. 作为JVM的系统属性
6. 集成测试类，用@ActiveProfiles("dev")