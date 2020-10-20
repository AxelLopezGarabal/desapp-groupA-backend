package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.locality;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.locality.requestbody.LocalityBodyPost;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidIdException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidOrNullFieldException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Locality;
import ar.edu.unq.desapp.grupoa.backenddesappapi.service.locality.LocalityService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locality")
@CrossOrigin(origins = "*")
public class LocalityController {

    private @Autowired LocalityService localityService;

    public LocalityController(LocalityService localityService) {
        this.localityService = localityService;
    }

    //get_ALL
    @GetMapping(value = "/list", produces = { "application/json" })
    public ResponseEntity  listLocalities() {
        List<Locality> localitiesDetails = localityService.getLocalitiesDetails();
        return new ResponseEntity (localitiesDetails, HttpStatus.OK);
    }

    //get_ONE
    @GetMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity getLocality(@PathVariable Integer id) throws InvalidIdException {
        Locality recoveredLocality = localityService.getById(id);
        return new ResponseEntity(recoveredLocality, HttpStatus.OK);
    }

    //ADD_ONE
    @PostMapping(value = "/", produces = { "application/json" },consumes = { "application/json" })
    public ResponseEntity addLocality(
            @RequestBody LocalityBodyPost locality
    ) throws InvalidOrNullFieldException {
        localityService.save(locality);
        return new ResponseEntity(HttpStatus.OK);
    }

    //DELETE_ONE
    @DeleteMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity deleteLocality(@PathVariable Integer id){
        localityService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
