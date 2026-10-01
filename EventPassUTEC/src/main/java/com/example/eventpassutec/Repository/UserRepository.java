package com.example.eventpassutec.Repository;

import com.example.eventpassutec.model.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<Long, User> {
    Long findById(){}
}
