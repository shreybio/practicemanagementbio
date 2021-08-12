package com.shreysambhwani.fleetapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shreysambhwani.fleetapp.models.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
	
	@Query(value="select * from Patient e where e.firstname like %:keyword%  or e.lastname like %:keyword%", nativeQuery=true)
	List<Patient> findByKeyword(@Param("keyword") String keyword);

}
