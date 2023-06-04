package com.crud.redis_mongo_crud.repository;

import com.crud.redis_mongo_crud.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDBRepository extends MongoRepository<User, String> {
}
