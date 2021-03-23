package com.ayigroup.mepv.repositories;

import com.ayigroup.mepv.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository <Customer, Long> {
}
