package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody.ProjectBodyPost;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody.ProjectBodyPut;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.responsebody.ProjectResponseBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.responsebody.ProjectResponseBodyList;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidIdException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidOrNullFieldException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@CrossOrigin(origins = "*")
public class ProjectController {

    private @Autowired ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    //get_ALL
    @GetMapping(value = "/list", produces = { "application/json" })
    public ResponseEntity listProjects() {
        List<ProjectResponseBodyList> projectsDetails = projectService.listAllProjects();
        return new ResponseEntity (projectsDetails, HttpStatus.OK);
    }

    //get_ONE
    @GetMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity getProject(@PathVariable Integer id) throws InvalidIdException {
        ProjectResponseBody recoveredProject = projectService.getById(id);
        return new ResponseEntity(recoveredProject, HttpStatus.OK);
    }

    //update
    @PutMapping(value = "/{id}", produces = { "application/json" },consumes = { "application/json" })
    public  ResponseEntity updateProject(@RequestBody ProjectBodyPut project, @PathVariable Long id) throws InvalidIdException, InvalidOrNullFieldException {
        ProjectResponseBody response = projectService.update(project, id);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    //ADD_ONE
    @PostMapping(value = "/", produces = { "application/json" },consumes = { "application/json" })
    public ResponseEntity addProject(@RequestBody ProjectBodyPost projectBody) throws InvalidOrNullFieldException, InvalidIdException {
        projectService.save(projectBody);
        return new ResponseEntity(HttpStatus.OK);
    }

    //DELETE_ONE
    @DeleteMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity deleteProject(@PathVariable Integer id) throws InvalidIdException {
        projectService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
