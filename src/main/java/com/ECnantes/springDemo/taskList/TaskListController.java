package com.ECnantes.springDemo.taskList;



import com.ECnantes.springDemo.models.Task;
import com.ECnantes.springDemo.models.TaskList;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/taskList")
public class TaskListController {


    private JpaTaskListRepository jpaTaskListRepository;

    public TaskListController(JpaTaskListRepository jpaTaskListRepository) {
        this.jpaTaskListRepository = jpaTaskListRepository;
    }

    @PostMapping("/create")
    public TaskList createTaskList (@RequestBody TaskList taskList){
        return jpaTaskListRepository.save(taskList);
    }

    @DeleteMapping("/{id}")
    public String deleteTaskListById(@PathVariable("id") Integer id){
        jpaTaskListRepository.deleteById(id);
        return ("La liste de tâche id: " + id + " et ses tâches associées ont été supprimées");
    }

}