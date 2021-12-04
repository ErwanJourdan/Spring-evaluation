package com.ECnantes.springDemo.taskList;


import com.ECnantes.springDemo.models.Task;
import com.ECnantes.springDemo.models.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaTaskListRepository extends JpaRepository<TaskList, Integer> {

}
