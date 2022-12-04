package com.app.gestionProjectBackend.Services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.gestionProjectBackend.Dto.Request.OrderRequestDto;
import com.app.gestionProjectBackend.Dto.Response.OrderProductResponseDto;
import com.app.gestionProjectBackend.Dto.Response.OrderResponseDto;
import com.app.gestionProjectBackend.Repository.OrderRepository;
import com.app.gestionProjectBackend.Security.Services.UserDetailsImpl;
import com.app.gestionProjectBackend.models.Message;
import com.app.gestionProjectBackend.models.Order;
import com.app.gestionProjectBackend.models.OrderProduct;
import com.app.gestionProjectBackend.models.Product;
import com.app.gestionProjectBackend.models.User;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private MessageService messageService;
	
	public Optional<Order> findById(Long id) {
		return orderRepository.findById(id);
	}
	
	public OrderResponseDto addOrder(OrderRequestDto orderDto) {
		Order order = new Order();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();	
		if(orderDto.getAddress() != null) {
			order.setAddress(orderDto.getAddress());
		}
		order.setUser(userService.findById(userDetails.getId()).get());
		if(orderDto.getProductList() != null ) {
			Set<OrderProduct> list = new HashSet<>();
			orderDto.getProductList().forEach(element -> {
				OrderProduct orderProductTmp =  new OrderProduct();
				orderProductTmp.setOrder(order);
				orderProductTmp.setProduct(productService.findById(element.getProductId()).get());
				orderProductTmp.setQuantity(element.getQuantity());
				if(orderProductTmp.getProduct().getQuantity_stock() >= orderProductTmp.getQuantity()) {
					list.add(orderProductTmp);
					Product p = orderProductTmp.getProduct();
					p.setQuantity_stock(orderProductTmp.getProduct().getQuantity_stock() - orderProductTmp.getQuantity());
					productService.update(orderProductTmp.getProduct().getId_product(), p);
					Message message = new Message();
					User receiver = productService.findById(orderProductTmp.getProduct().getId_product()).get().getUser();
					User sender = userService.findById(userDetails.getId()).get();
					message.setMessageRead("false");
					message.setMessageText("Hello "+receiver.getFirst_name()+" ! Votre produit "+p.getName()+" m'intéresse.");
					message.setUserReceiver(receiver);
					message.setUserSender(sender);
					messageService.add(message);
				}
			});
			order.setOrder_product(list);
		}
		if(order.getOrder_product().size() > 0) {
			Order newOrder = add(order);
			return convertOrderToOrderResponseDto(newOrder);
		}else {
			return null;
		}
	}
	
	public OrderResponseDto convertOrderToOrderResponseDto (Order order) {
		OrderResponseDto resp = new OrderResponseDto();
		resp.setAddress(order.getAddress());
		resp.setCreation_date_timestamp(order.getCreation_date_timestamp());
		resp.setId_order(order.getId_order());
		//resp.setOrder_product(order.getOrder_product());
		if(order.getOrder_product() != null) {
			Set<OrderProductResponseDto> order_product = new HashSet<>();
			order.getOrder_product().forEach(element -> {
				OrderProductResponseDto o = new OrderProductResponseDto();
				o.setId(element.getId());
				o.setProduct(element.getProduct());
				o.setQuantity(element.getQuantity());
				order_product.add(o);
			});
			resp.setOrder_product(order_product);
		}
		resp.setStatus(order.getStatus());
		resp.setUpdate_date_timestamp(order.getUpdate_date_timestamp());
		resp.setUser(order.getUser());
		return resp;
	}
	
	@Transactional
	public Order add(Order order) {
		Order newOrder = orderRepository.save(order);
		return newOrder;
	}
	
	@Transactional
	public Order update(Long id, Order order) {
		Order orderOld = findById(id).get();
		if(order.getAddress() != null) {
			orderOld.setAddress(order.getAddress());
		}
		if(order.getOrder_product() != null) {
			orderOld.setOrder_product(order.getOrder_product());
		}
		if(order.getStatus() != null) {
			orderOld.setStatus(order.getStatus());
		}
		if(order.getUser() != null) {
			orderOld.setUser(order.getUser());
		}
		return orderRepository.save(orderOld);
	}
	
	public Iterable<Order> findAll() {
		return orderRepository.findAll();
	}
}
