package com.sample.adapter.controller;

import java.util.List;

import javax.annotation.Resource;

import com.sample.adapter.client.SampleRestClient;
import com.sample.adapter.mapper.OrderMapper;
import com.sample.model.Order;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Resource
	private OrderMapper orderMapper;

	@Resource
	private SampleRestClient sampleRestClient;

	@RequestMapping("/")
	String hello() {
		StringBuilder sb = new StringBuilder();
		List<Order> result = orderMapper.findOneById(2);
		result.stream().forEach(order -> {
			sb.append("\r\n");
			sb.append(order.getOrderNo())
					.append(order.getOrderItem())
					.append(order.getOrderDetails());
		});
		return "Hello Spring Boot!" + sb.toString();
		// CommonResponse res = sampleRestClient.getTestResponse();
		// return "Hello Spring Boot!" + res.getUserId().toString();
	}

}