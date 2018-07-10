package com.zhenghao.rest;

import com.zhenghao.domain.Spittle;
import com.zhenghao.repository.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    public static final String MAX_AS_STRING = "9223372036854775807";

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    // 内容协商：
    // 自动添加到Model中
    // 返回的逻辑视图名是spittles
    // 默认媒体类型是HTML，所以会被InternalResourceViewResolver解析为/WEB-INF/views/spittles.jsp视图
    // 还会被BeanNameViewResolver解析（逻辑视图名和bean名相同），根据逻辑视图名找到bean，将Bean解析为JSON视图（MappingJackson2JsonView对象完成）
    // 正常访问/spittles，返回jsp视图
    // /spittles.json，返回JSON视图

    // 消息转化器：
    // @ResponseBody 使用消息转换，没有模型没有视图，只有控制器产生的数据、有消息转换后的资源表述作为响应体
    // DispatcherServlet查看请求的Accept头信息，查找相应的消息转换器
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = MAX_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        System.out.println("SpittleController.spittles()");
        return spittleRepository.findSpittles(max, count);

    }
}
