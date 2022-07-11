package com.batuhankiltac.springSample.service.concretes;

import com.batuhankiltac.springSample.model.Customer;
import com.batuhankiltac.springSample.repository.CustomerRepository;
import com.batuhankiltac.springSample.service.abstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Customer add(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        customerRepository.findById(customer.getCustomerId());
        Customer updatedCustomer = Customer.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .build();
        return customerRepository.save(updatedCustomer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> getAllByPage(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return customerRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Customer> getAllSortedByID() {
        Sort sort = Sort.by(Sort.Direction.ASC, "customerId");
        return customerRepository.findAll(sort);
    }

    @Override
    public List<Customer> getAllSortedByName() {
        Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
        return customerRepository.findAll(sort);
    }

    @Override
    public Customer getByCustomerId(Integer customerId) {
        return customerRepository.getByCustomerId(customerId);
    }
}