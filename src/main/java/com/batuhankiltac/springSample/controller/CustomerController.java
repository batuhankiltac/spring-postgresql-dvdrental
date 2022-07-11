package com.batuhankiltac.springSample.controller;

import com.batuhankiltac.springSample.model.Customer;
import com.batuhankiltac.springSample.service.abstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/add")
    public Customer add(@RequestBody Customer customer) {
        return customerService.add(customer);
    }

    @PutMapping("/update")
    public Customer update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Customer customer) {
        customerService.delete(customer);
    }

    @GetMapping("/getAll")
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/getAllByPage")
    public List<Customer> getAllByPage(Integer pageNumber, Integer pageSize) {
        return customerService.getAllByPage(pageNumber, pageSize);
    }

    @GetMapping("/getAllSortedByID")
    public List<Customer> getAllSortedByID() {
        return customerService.getAllSortedByID();
    }

    @GetMapping("/getAllSortedByName")
    public List<Customer> getAllSortedByName() {
        return customerService.getAllSortedByName();
    }

    @GetMapping("/getByCustomerId")
    public Customer getByCustomerId(@RequestParam Integer customerId) {
        return customerService.getByCustomerId(customerId);
    }
}