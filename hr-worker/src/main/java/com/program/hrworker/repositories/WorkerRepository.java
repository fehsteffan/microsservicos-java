package com.program.hrworker.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.program.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>  {

}
