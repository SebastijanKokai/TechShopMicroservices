package com.agilne.prodavnica_tehnike.services.implementations;

import com.agilne.prodavnica_tehnike.dtos.GetOrderDto;
import com.agilne.prodavnica_tehnike.dtos.ModifyOrderDto;
import com.agilne.prodavnica_tehnike.dtos.PostOrderItemDto;
import com.agilne.prodavnica_tehnike.dtos.PostOrderDto;
import com.agilne.prodavnica_tehnike.models.*;
import com.agilne.prodavnica_tehnike.repositories.OrderProductRepository;
import com.agilne.prodavnica_tehnike.services.interfaces.OrderProductService;
import com.agilne.prodavnica_tehnike.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderProductImpl implements OrderProductService {

    @Autowired
    private OrderProductRepository orderRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    CustomerService customerService = new CustomerService();
    EmployeeService employeeService = new EmployeeService();
    DelivererService delivererService = new DelivererService();
    ProductService productService = new ProductService();
    OrderItemService orderItemService = new OrderItemService();
    private final String orderItemURL = "http://localhost:8084/items";

    @Override
    public List<GetOrderDto> findAllOrders() {
        List<OrderProduct> orders = orderRepository.findAll();
        List<GetOrderDto> mappedOrders = new ArrayList<>();
        String employee = "", deliverer = "", customer = "";
        for (OrderProduct order : orders) {
            if(order.getEmployee() != null)
            employee = order.getEmployee().getName() + " " + order.getEmployee().getLastName();
            if (order.getDeliverer() != null)
            deliverer = order.getDeliverer().getCompanyName();
            if (order.getCustomer() != null)
            customer = order.getCustomer().getName() + " " + order.getCustomer().getLastName();

            mappedOrders.add(new GetOrderDto(order.getId(), order.getOrderDate(), order.getPrice(), order.getOrderItems(), employee, deliverer, customer));
        }
        return mappedOrders;
    }

    public GetOrderDto findOrderById(Integer id) {
        String employee = "", deliverer = "", customer = "";
        if (orderRepository.findById(id).isPresent()) {
            OrderProduct order = orderRepository.findById(id).get();
            if(order.getEmployee() != null)
                employee = order.getEmployee().getName() + " " + order.getEmployee().getLastName();
            if (order.getDeliverer() != null)
                deliverer = order.getDeliverer().getCompanyName();
            if (order.getCustomer() != null)
                customer = order.getCustomer().getName() + " " + order.getCustomer().getLastName();
            return new GetOrderDto(order.getId(), order.getOrderDate(), order.getPrice(), order.getOrderItems(), employee, deliverer, customer);
        }
        return null;
    }

    @Override
    public OrderProduct insert(PostOrderDto order) {

        OrderProduct postOrder = new OrderProduct();
        // Communication with customer, employee, deliverer microservices
        Customer customer = customerService.getCustomerById(order.getCustomerId());
        Employee employee = employeeService.getEmployeeById(order.getEmployeeId());
        Deliverer deliverer = delivererService.getDelivererById(order.getDelivererId());

        postOrder.setOrderDate(order.getOrderDate());
        postOrder.setPrice(order.getPrice());

        if(customer != null) {
            postOrder.setCustomerId(customer.getId());
            postOrder.setCustomer(customer);
        }
        if(employee != null) {
            postOrder.setEmployeeId(employee.getId());
            postOrder.setEmployee(employee);
        }
        if(deliverer != null) {
            postOrder.setDelivererId(deliverer.getId());
            postOrder.setDeliverer(deliverer);
        }

        // Because I need to create an ID first
        postOrder = orderRepository.save(postOrder);

        for(PostOrderItemDto item : order.getOrderItems()) {

            OrderItem orderItem = new OrderItem();
            // Communication with product microservice
            Product product = productService.getProductById(item.getProductId());

            orderItem.setOrderId(postOrder.getId());
            orderItem.setProductId(item.getProductId());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setProduct(product);
            orderItem.setOrderProduct(postOrder);

            postOrder.getOrderItems().add(orderItem);

            // Communication with Order Item microservice
            // Create the order item also
            orderItemService.postOrderItem(orderItem);
        }
        return postOrder;
     }

    @Override
    public Optional<OrderProduct> update(ModifyOrderDto order, Integer id) {
        return orderRepository.findById(id).map(oldOrder ->{
            oldOrder.setOrderDate(order.getOrderDate());
            oldOrder.setPrice(order.getPrice());
            return orderRepository.save(oldOrder);
        } );
    }

    @Override
    public void delete(Integer id) {
        if(orderRepository.findById(id).isPresent()) {
            ResponseEntity<OrderItem[]> responseEntity = orderItemService.getOrderItems();
            OrderItem[] orderItems = responseEntity.getBody();
            // Delete items of order before deleting the order
            for (OrderItem item : orderItems) {
                if (item.getOrderId().equals(id)) {
                    restTemplate.delete(orderItemURL + "/" + item.getProductId() + "/" + item.getOrderId());
                }
            }
            orderRepository.deleteById(id);
        }
    }
}