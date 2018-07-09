package com.zhenghao.wiring.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.zhenghao.wiring.qualifier.customqualifier.Cold;
import com.zhenghao.wiring.qualifier.customqualifier.Creamy;

public class ChoseDessert {
    private Dessert dessert;

    @Autowired
    @Qualifier("cold") //注入时指定限定符，不指定使用首选项
    @Cold//注入时使用自定义的限定符注解，可以添加多个，自定义的更安全
    @Creamy
    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }
}
