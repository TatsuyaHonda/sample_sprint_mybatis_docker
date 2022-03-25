package com.example.sample.model;

import java.util.List;

import lombok.Data;

@Data
public class Order {

	int orderNo;
	String orderItem;

	List<OrderDetail> orderDetails;

}