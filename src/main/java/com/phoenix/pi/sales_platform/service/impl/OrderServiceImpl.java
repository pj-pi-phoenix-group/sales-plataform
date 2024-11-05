package com.phoenix.pi.sales_platform.service.impl;

import com.phoenix.pi.sales_platform.dto.OrderDto;
import com.phoenix.pi.sales_platform.mappers.OrderMapper;
import com.phoenix.pi.sales_platform.model.entity.Order;
import com.phoenix.pi.sales_platform.repository.OrderRepository;
import com.phoenix.pi.sales_platform.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    public OrderDto saveOrder(OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toDto(savedOrder);
    }
}
