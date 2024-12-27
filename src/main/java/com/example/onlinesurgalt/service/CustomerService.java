package com.example.onlinesurgalt.service;

import com.example.onlinesurgalt.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> findByCustomerAddress(String name);
    List<Customer> getAllCustomers();
    public Customer createCustomer(Customer customer);
    List<Customer> createCustomers(List<Customer> customers);
    public Optional<Customer> getCustomerById(Long id);
    public Customer updateCustomer(Customer customer);
    public String deleteCustomerById(Long id);
    List<Customer> deleteCustomers(List<Customer> customers);
}
