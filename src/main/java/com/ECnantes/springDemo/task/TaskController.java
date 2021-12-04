package com.ECnantes.springDemo.task;




import com.ECnantes.springDemo.models.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/task")
public class TaskController {


    private JpaTaskRepository jpaTaskRepository;

    public TaskController(JpaTaskRepository jpaTaskRepository) {
        this.jpaTaskRepository = jpaTaskRepository;
    }

    @PostMapping
    public Task createTask (@RequestBody Task task){
        return jpaTaskRepository.save(task);
    }

    @PostMapping("/set-name-and-description/{id}")
    public ResponseEntity<Task> setNameAndDesciptionTask(@PathVariable("id") Integer id,
                                             @RequestBody SetNameAndDescrip setNameAndDescrip){
        Optional<Task> optionalTask = jpaTaskRepository.findById(id);
        if(optionalTask.isPresent()){
            Task taskSet = optionalTask.get();
            taskSet.setName(setNameAndDescrip.getName());
            taskSet.setDescription(setNameAndDescrip.getDescription());
            jpaTaskRepository.save(taskSet);
            return ResponseEntity.ok(taskSet);
        }else {return ResponseEntity.notFound().build();}
    }

    @PostMapping("/set-completed-task/{id}")
    public ResponseEntity<Task> setCompletedTask(@PathVariable("id") Integer id,
                                                 @RequestBody SetCompleted setCompleted){
        Optional<Task> optionalTask = jpaTaskRepository.findById(id);
        if(optionalTask.isPresent()){
            Task taskSet = optionalTask.get();
            taskSet.setCompleted(setCompleted.getCompleted());
            jpaTaskRepository.save(taskSet);
            return ResponseEntity.ok(taskSet);
        }else {return ResponseEntity.notFound().build();}
    }

    @PostMapping("/assign-task-to-collaborator/{id}")
    public ResponseEntity<Task> assignTaskToCollaborator(@PathVariable("id") Integer id,
                                                 @RequestBody AssignTaskToCollaborator assignTaskToCollaborator){
        Optional<Task> optionalTask = jpaTaskRepository.findById(id);
        if(optionalTask.isPresent()){
            Task taskSet = optionalTask.get();
            taskSet.setCollaborator(assignTaskToCollaborator.getCollaborator());
            jpaTaskRepository.save(taskSet);
            return ResponseEntity.ok(taskSet);
        }else {return ResponseEntity.notFound().build();}
    }

    @DeleteMapping("/{id}")
    public String deleteTaskById(@PathVariable("id") Integer id){
            jpaTaskRepository.deleteById(id);
            return ("Votre tâche id: " + id + " a été supprimé");
    }

    @GetMapping("/get-by-task-list/{id}")
    public List<Task> getListOfTaskByTaskListId(@PathVariable("id") Integer id){
        List<Task> tasks = jpaTaskRepository.findAllByTaskListIdOrderById(id);
        List<Task> tasksHighPriority = new ArrayList<>();
        List<Task> tasksModeratePriority = new ArrayList<>();
        List<Task> tasksLowPriority = new ArrayList<>();
        List<Task> tasksOrderByPriority = new ArrayList<>();
        for (Task task: tasks) {
            switch (task.getPriority()){
                case HAUTE -> tasksHighPriority.add(task);
                case MOYENNE -> tasksModeratePriority.add(task);
                case BASSE -> tasksLowPriority.add(task);
            }
        }
        tasksOrderByPriority.addAll(tasksHighPriority);
        tasksOrderByPriority.addAll(tasksModeratePriority);
        tasksOrderByPriority.addAll(tasksLowPriority);
        return tasksOrderByPriority;
    }
}



