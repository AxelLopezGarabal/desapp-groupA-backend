package ar.edu.unq.desapp.grupoa.backenddesappapi.service.project;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody.ProjectBodyPost;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody.ProjectBodyPut;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.responsebody.ProjectResponseBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.responsebody.ProjectResponseBodyList;

import java.util.List;

public interface ProjectService {
    List<ProjectResponseBodyList> listAllProjects();

    ProjectResponseBody getById(Integer id);

    void save(ProjectBodyPost project);

    void delete(Integer id);

    void update(ProjectBodyPut project, Long id);
}
