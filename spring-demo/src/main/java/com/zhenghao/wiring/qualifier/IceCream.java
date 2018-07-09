package com.zhenghao.wiring.qualifier;

import org.springframework.stereotype.Component;
import com.zhenghao.wiring.qualifier.customqualifier.Cold;
import com.zhenghao.wiring.qualifier.customqualifier.Creamy;

@Component
//自定义的限定符注解，可以添加多个
@Cold
@Creamy
public class IceCream implements Dessert {
}
