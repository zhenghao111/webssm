package com.zhenghao.rest;

import com.zhenghao.exception.Error;
import com.zhenghao.domain.Spittle;
import com.zhenghao.exception.SpittleNotFoundException2;
import com.zhenghao.repository.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;
import java.util.List;

@Controller
//@RestController //代替@Controller，每个方法都使用消息转换过程
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

    // RequestMapping中的produce属性看请求中的Accept头部信息，表明只接受预期输出为JSON的请求
    @RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
    public @ResponseBody List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = MAX_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        System.out.println("SpittleController.spittles()");
        return spittleRepository.findSpittles(max, count);

    }

    // Spring查看请求中的Content-Type头部信息，查找能将请求转化为Spittle的消息转换器
    // consumes属性查看请求中的Context-Type头部信息，只处理指定类型的请求
    @RequestMapping(method = RequestMethod.POST, consumes = {"application/json"})
    public ResponseEntity<Spittle> saveSpittle(@RequestBody Spittle spittle, UriComponentsBuilder builder) {
        System.out.println("保存spittle");
        // 存放响应的头部信息值，是一个MultiValueMap<String, String>类型
        HttpHeaders headers = new HttpHeaders();
//        URI locationURI = URI.create("http://localhost:8080/spittles/1234");
        URI locationURI = builder
                                .path("/spittles/")
                                .path(String.valueOf(spittle.getId()))
                                .build()
                                .toUri();

        // 将资源的URL放在响应的头部信息Location
        headers.setLocation(locationURI);

        // 返回状态码201，表明了请求成功。且创建了新资源
        ResponseEntity<Spittle> responseEntity = new ResponseEntity<Spittle>(spittle, headers, HttpStatus.CREATED);
        return responseEntity;
    }

    // 处理错误信息给响应体
    // 方法1：用@ResponseStatus指定状态码，参考SpittleNotFoundException异常处理，抛出异常，直接返回错误状态
    // 方法2：用ResponseEntity对象替代@ResponseBody，包含了响应相关的元数据和要转换成资源表述的对象，可以用错误对象来填充响应体
    // 方法3：用异常处理器应对错误场景，异常处理和业务代码分离
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public @ResponseBody Spittle spittleById(@PathVariable long id) {
        System.out.println("spittleById找不到对象");
//        return null;//假设找不到，返回null

        Spittle spittle = spittleRepository.findOne(id);

        // 方法2 返回类型为ResponseEntity<Spittle>
//        HttpStatus httpStatus = spittle == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
//        return new ResponseEntity<Spittle>(spittle, httpStatus);

        // 方法2 返回类型为ResponseEntity<?>
//        if (spittle == null) {
//            Error error = new Error(4, "spittleById could'n find spittle");
//            return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<Spittle>(spittle, HttpStatus.OK);

        // 方法3 返回类型为ResponseEntity<Spittle>
        if (spittle == null) {
            //抛出异常后，在AppWideExceptionHandler中有对应的异常处理器@ExceptionHandler处理
            // 那边的返回，相当于这边的返回
            throw new SpittleNotFoundException2(id);
        }
        // 因为返回始终是200，所以可以用@ResponseBody Spittle
        // 如果用了@RestController，可以省略@ResponseBody
//        return new ResponseEntity<Spittle>(spittle, HttpStatus.OK);
        return spittle;
    }



}
