package com.spring.restaurant.controller;

import com.spring.restaurant.entity.Order;
import com.spring.restaurant.exception.ApiRequestException;
import com.spring.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("allOrder")  // localhost:8085/api/allOrder?page=0&size=10
    public List<Order> getAllOrder(@RequestParam int page,@RequestParam int size){
        return orderService.getAllOrder(page, size);
    }

    @GetMapping("category")  // localhost:8085/api/category?page= &size= &id=
    public List<Order> findByCategory_Id(@RequestParam int page,@RequestParam int size,@RequestParam int id)
    {
       List<Order> orders=orderService.findByCategory_Id(page, size,id);

       return orders;
    }

    @GetMapping("orderName")  // localhost:8085/api/orderName?page= &size= & name=
    public List<Order> findByOrderName(@RequestParam int page,@RequestParam int size,@RequestParam String name)
    {
        return orderService.findByOrderName(page, size,name);
    }

    @GetMapping("getOrder/{id}")  // localhost:8085/api/orderName/{value}
    public Order findOrderById(@PathVariable int id){
        return orderService.findOrderById(id);
    }

    @GetMapping("orderSize")   // localhost:8085/api/orderSize
    public Long getSizeOfAllOrder()
    {
        return orderService.getSizeOfAllOrder();
    }

    @GetMapping("categoryOrderSize") // localhost:8085/api/categoryOrderSize?id=
   public long getOrderSizeByCategoryId(int id)
   {
       return orderService.getOrderSizeByCategoryId(id);
   }

   @GetMapping("OrderSizeByName") // localhost:8085/api/OrderSizeByName?name=
   public long getOrderSizeByName(String name)
   {
       return orderService.getOrderSizeByName(name);
   }

   @GetMapping("allOrderPrice")  // localhost:8085/api/allOrderPrice
    public long getAllOrderPrice()
    {
        return orderService.getAllOrderPrice();
    }

    @GetMapping("orderPriceById")   // localhost:8085/api/OrderPriceById?id=
    public long getOrderPriceById(int id)
    {
        return orderService.getOrderPriceById(id);
    }
}
