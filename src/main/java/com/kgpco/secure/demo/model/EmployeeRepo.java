
package com.kgpco.secure.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
