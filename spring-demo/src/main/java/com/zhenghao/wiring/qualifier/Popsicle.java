package com.zhenghao.wiring.qualifier;

import org.springframework.stereotype.Component;
import com.zhenghao.wiring.qualifier.customqualifier.Cold;
import com.zhenghao.wiring.qualifier.customqualifier.Fruity;

@Component
//Java不允许添加多个相同的注解，用自定义的限定符注解
//@Qualifier("cold")
//@Qualifier("fruity")
@Cold
@Fruity
public class Popsicle implements Dessert {

}
