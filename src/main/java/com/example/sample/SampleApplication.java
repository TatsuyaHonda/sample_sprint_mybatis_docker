package com.example.sample;

import java.util.List;

import com.example.sample.mapper.OrderMapper;
import com.example.sample.model.Order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SampleApplication {

	private final OrderMapper orderMapper;

	public SampleApplication(OrderMapper orderMapper) {
		this.orderMapper = orderMapper; // Mapperをインジェクションする
	}

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

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

	}

}