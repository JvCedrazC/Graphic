package com.example.phase4.dao.CustomerDao;

import com.example.phase4.Model.Customer;
import com.example.phase4.dao.CRUD;

public interface CustomerDAO extends CRUD<Customer>{
    public Customer create(Customer customer);
}
