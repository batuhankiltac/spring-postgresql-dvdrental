package com.batuhankiltac.springSample.service;

import com.batuhankiltac.springSample.model.Category;
import com.batuhankiltac.springSample.model.Customer;
import com.batuhankiltac.springSample.repository.CategoryRepository;
import com.batuhankiltac.springSample.repository.CustomerRepository;
import com.batuhankiltac.springSample.service.abstracts.CategoryService;
import com.batuhankiltac.springSample.service.abstracts.CustomerService;
import com.batuhankiltac.springSample.service.concretes.CategoryManager;
import com.batuhankiltac.springSample.service.concretes.CustomerManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class CustomerManagerTest {

    @InjectMocks
    private CustomerManager customerManager;

    @Mock
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void it_should_save_customer() {
        // Given
        final Customer customer = Customer.builder()
                .customerId(1)
                .firstName("Batuhan")
                .email("test@test.com")
                .build();

        // When
        when(customerManager.add(customer)).thenReturn(customer);

        // Then
        assertThat(customer.getCustomerId()).isNotNull();
        assertThat(customer.getFirstName()).isEqualTo("Batuhan");
    }

    @Test
    public void it_should_update_customer() {
        // Given
        final Customer customer1 = Customer.builder()
                .customerId(1)
                .firstName("Batuhan")
                .email("test@test.com")
                .build();
        final Customer customer2 = Customer.builder()
                .customerId(1)
                .firstName("Batu")
                .email("test1@test.com")
                .build();

        // When
        when(customerManager.update(customer1)).thenReturn(customer2);

        // Then
        assertThat(customer1.getCustomerId()).isEqualTo(customer2.getCustomerId());
        assertThat(customer1.getFirstName()).isEqualTo("Batuhan");
    }

    @Test
    public void it_should_delete_customer() {
        // Given
        final Customer customer = Customer.builder().build();

        // When
        customerManager.delete(customer);

        // Then
        verify(customerRepository).delete(customer);
    }

    @Test
    public void it_should_get_all_customers() {
        // Given
        final Customer customer1 = Customer.builder()
                .customerId(1)
                .firstName("Batuhan")
                .email("test@test.com")
                .build();
        final Customer customer2 = Customer.builder()
                .customerId(2)
                .firstName("Batu")
                .email("test1@test.com")
                .build();
        final List<Customer> all = new ArrayList<>();
        all.add(customer1);
        all.add(customer2);

        // When
        when(customerManager.getAll()).thenReturn(all);

        // Then
        assertThat(customer1.getCustomerId()).isNotEqualTo(customer2.getCustomerId());
        assertThat(customer2.getFirstName()).isEqualTo("Batu");
    }
}
