package com.ECnantes.springDemo.collaborator;

import com.ECnantes.springDemo.models.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCollaboratorRepository extends JpaRepository<Collaborator, Integer> {
}
