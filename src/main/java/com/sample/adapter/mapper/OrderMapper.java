package com.sample.adapter.mapper;

import java.util.List;

import com.sample.model.Order;
import com.sample.model.OrderDetail;

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
			@Result(column = "{orderNo=order_no,orderItem=order_item}", property = "orderDetails", many = @Many(select = "selectRef")) })
	List<Order> findOneById(int orderNo);

	@Select("""
			SELECT
				*
			FROM
				public.sample_ref
			WHERE
				order_no = #{orderNo}
				AND order_detail_comment = #{orderItem}
			""")
	List<OrderDetail> selectRef(
			int orderNo,
			String orderItem);

}