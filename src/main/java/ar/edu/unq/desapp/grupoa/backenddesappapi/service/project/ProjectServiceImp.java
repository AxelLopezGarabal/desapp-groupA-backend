package ar.edu.unq.desapp.grupoa.backenddesappapi.service.project;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody.ProjectBodyPost;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody.ProjectBodyPut;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.responsebody.ProjectResponseBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.responsebody.ProjectResponseBodyList;
import ar.edu.unq.desapp.grupoa.backenddesappapi.dao.locality.LocalityDAO;
import ar.edu.unq.desapp.grupoa.backenddesappapi.dao.project.ProjectDAO;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Locality;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImp implements ProjectService {

    @Autowired
    private ProjectDAO projectDAO;
    @Autowired
    private LocalityDAO localityDAO;

    @Override
    public List<ProjectResponseBodyList> listAllProjects() {
        return ((List<Project>) projectDAO.findAll()).stream()
                .map(ProjectResponseBodyList::new).collect(Collectors.toList());
    }

    @Override
    public ProjectResponseBody getById(Integer id) {
        Project recoverProject = projectDAO.findById(Long.valueOf(id)).orElse(new Project());
        return new ProjectResponseBody(recoverProject);
    }

    @Override
    public void save(ProjectBodyPost body) {
        Locality locality = localityDAO.findById(body.getLocalityId()).orElse(new Locality());
        Project project = new Project();
        projectDAO.save(project.setBody(body, locality));
    }

    @Override
    public void delete(Integer id) {
        projectDAO.deleteById(Long.valueOf(id));
    }

    @Override
    public void update(ProjectBodyPut project, Long id) {
        projectDAO.findById(Long.valueOf(id))
                .map(recoverProject -> {
                    recoverProject.updateProject(project);
                    return projectDAO.save(recoverProject);
                })
                .orElse(new Project());
    }
}
