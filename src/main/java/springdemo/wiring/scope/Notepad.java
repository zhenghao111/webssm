package springdemo.wiring.scope;

import jdk.nashorn.internal.objects.annotations.ScriptClass;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
// 在自动装配中使用作用域
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Scope("prototype") // 或者用字符串
public class Notepad {

    @Bean
    // 在JavaConfig中使用作用域
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Notepad notepad() {
        return new Notepad();
    }

    @Bean
    //web应用中，购物车bean使用会话作用域
    //会话作用域bean注入到单例中，指定代理模式
    //INTERFACES，代理实现接口，有相同方法，调用委托给会话作用域真正的接口bean
    // TARGET_CLASS，注入的bean是具体类，表明也生成目标类扩展的方式创建代理
    // xml中用<aop:scoped-proxy>设置代理模式，生成基于接口的代理将proxy-target-class=false
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.INTERFACES)
    public ShoppingCart cart() {
        return new ShoppingCart();
    }
}
