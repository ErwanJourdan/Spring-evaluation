package com.ECnantes.springDemo.collaborator;


import com.ECnantes.springDemo.models.Collaborator;
import com.ECnantes.springDemo.models.Task;
import com.ECnantes.springDemo.task.JpaTaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collaborator")
public class CollaboratorController {

    private JpaCollaboratorRepository jpaCollaboratorRepository;
    private JpaTaskRepository jpaTaskRepository;

    public CollaboratorController(JpaCollaboratorRepository jpaCollaboratorRepository, JpaTaskRepository jpaTaskRepository) {
        this.jpaCollaboratorRepository = jpaCollaboratorRepository;
        this.jpaTaskRepository = jpaTaskRepository;
    }


    @PostMapping
    public Collaborator createCollaborator (@RequestBody Collaborator collaborator){
        return jpaCollaboratorRepository.save(collaborator);
    }

    @DeleteMapping("/{id}")
    public String deleteCollaboratorById(@PathVariable("id") Integer id){
        List<Task> tasksOfCollaborator = jpaTaskRepository.findAllByCollaboratorId(id);
        for (Task task: tasksOfCollaborator) {
            task.setCollaborator(null);
            jpaTaskRepository.save(task);
        }
        jpaCollaboratorRepository.deleteById(id);
        return ("Le collaborateur id: " + id + " a été supprimé");
    }
}
