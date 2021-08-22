package ru.project.restaraunt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.restaraunt.dto.OrderDTO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/order")
@RequiredArgsConstructor
public class OrderController {

    @PostMapping("/create")
    public ResponseEntity createOrder(@RequestBody OrderDTO orderDTO){
        //реализовать отправку в кафку (сначала в сервис с заказами, а оттуда реализовать отправку в кафку)
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list/customerId/{customerId}")
    public List<OrderDTO> getListByCustomerId(@PathVariable("customerId") BigInteger customerId) {
        return new ArrayList<>();
    }
}
