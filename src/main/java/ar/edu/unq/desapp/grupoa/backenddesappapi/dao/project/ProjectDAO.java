package ar.edu.unq.desapp.grupoa.backenddesappapi.dao.project;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectDAO extends CrudRepository<Project, Long> {
}
