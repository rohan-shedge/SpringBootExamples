package com.rohan.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	//Custom finder methods/Derived Query methods
	//IMPLICIT : select * from User where name = "rohan"
	public List<User> findByName(String name);
	public List<User> findByNameAndCity(String name, String city);
	
	//JPQL
	@Query(value = "select * from user", nativeQuery = true)
	public List<User> getNativeUsers();
	
	//JPQL
	@Query("select u from User u")
	public List<User> getAllUsers();
	
	//parameterised JPQL
	@Query("select u from User u where u.name = :n and city =:c")
	public List<User> getAllUsers(@Param("n") String name, @Param("c") String city);
}
