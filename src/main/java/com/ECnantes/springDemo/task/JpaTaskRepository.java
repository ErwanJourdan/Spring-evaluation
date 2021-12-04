package com.ECnantes.springDemo.task;


import com.ECnantes.springDemo.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaTaskRepository extends JpaRepository<Task, Integer> {


    List<Task> findAllByTaskListIdOrderById(Integer id);
    List<Task> findAllByCollaboratorId(Integer id);

}
