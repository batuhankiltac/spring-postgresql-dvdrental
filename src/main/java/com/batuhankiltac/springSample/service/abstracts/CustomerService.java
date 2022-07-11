package com.batuhankiltac.springSample.service.abstracts;

import com.batuhankiltac.springSample.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer add(Customer customer);
    Customer update(Customer customer);
    void delete(Customer customer);
    List<Customer> getAll();
    List<Customer> getAllByPage(Integer pageNumber, Integer pageSize);
    List<Customer> getAllSortedByID();
    List<Customer> getAllSortedByName();
    Customer getByCustomerId(Integer customerId);
}
