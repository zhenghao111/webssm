package com.zhenghao.rest;

import com.zhenghao.domain.Spittle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Date;

public class RestClient {

    // Get资源
    public void fetchSpittle(String id) {
        RestTemplate restTemplate = new RestTemplate();
        // getForObject只返回资源，通过消息转换器将响应体转换为对象
        Spittle spittle = restTemplate.getForObject("http://localhost:8080/spittles/{spitter}",
                Spittle.class,
                id);
        System.out.println(spittle.getId());

        // getForEntity返回资源，还有HTTP状态码和响应头
        ResponseEntity<Spittle> responseEntity = restTemplate.getForEntity("http://localhost:8080/spittles/{spitter}",
                        Spittle.class,
                        id);
        System.out.println("状态码：" + responseEntity.getStatusCode());
        System.out.println(responseEntity.getHeaders().getDate());
        System.out.println(responseEntity.getBody().getId());

        // POST一个资源
        Spittle spittle1 = new Spittle(123L, "message", new Date());
        URI uri = restTemplate.postForLocation("http://localhost:8080/spittles", spittle1);
        System.out.println(uri);

    }

    public static void main(String[] args) {
        RestClient client = new RestClient();
        client.fetchSpittle("1");

    }
}
