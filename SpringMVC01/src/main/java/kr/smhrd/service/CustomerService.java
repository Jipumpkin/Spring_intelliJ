package kr.smhrd.service;

import kr.smhrd.entity.Customer;
import kr.smhrd.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer login(Customer customer){
        return customerRepository.findByUsernameAndPassword(customer);
    }
}
