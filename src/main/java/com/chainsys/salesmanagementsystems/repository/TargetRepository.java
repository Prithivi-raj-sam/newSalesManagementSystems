package com.chainsys.salesmanagementsystems.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chainsys.salesmanagementsystems.model.Target;

public interface TargetRepository extends CrudRepository<Target,Integer>{
	Target save(Target target);
	void deleteById(int id);
	Target findById(int id);
	List<Target> findAll();
}