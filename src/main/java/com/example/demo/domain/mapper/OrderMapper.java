package com.example.demo.domain.mapper;

import java.util.List;

import com.example.demo.domain.model.Order;
import com.example.demo.domain.model.OrderDetail;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper {

	@Select("""
			SELECT
				*
			FROM
				public.sample
			""")
	@Results(id = "Order", value = {
			@Result(column = "order_no", property = "orderNo"),
			@Result(column = "order_item", property = "orderItem"),
			@Result(column = "order_no", property = "orderDetails", many = @Many(select = "selectRef")) })
	List<Order> findOneById(int orderNo);

	@Select("""
			SELECT
				*
			FROM
				public.sample_ref
			WHERE
				order_no = #{orderNo}
			""")
	List<OrderDetail> selectRef(int orderNo);

}