package com.ibm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ibm.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
	Optional<User> findByUsername(String username);
	Optional<User> findByCode(String code);
	@Modifying
	@Query(value="update User t set t.confirmed=?3 where t.username=?1 and t.password=?2")
	void updateConfirmed(String username,String password,int confirmed);	
	@Query(value="select t from User t where t.username=?1 and t.password=?2 and t.confirmed=?3")
	Optional<User> loginUser(String username,String password,int confirmed);
}
