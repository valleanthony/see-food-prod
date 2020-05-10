package com.anthonyvalle.seefoodprod.Repos;

import com.anthonyvalle.seefoodprod.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

}
