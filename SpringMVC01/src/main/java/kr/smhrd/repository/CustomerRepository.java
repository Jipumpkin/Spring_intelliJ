package kr.smhrd.repository;

import kr.smhrd.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository {

    // public Customer findByUsernameAndPassword(String username, String password);
    public Customer findByUsernameAndPassword(Customer customer);
}
