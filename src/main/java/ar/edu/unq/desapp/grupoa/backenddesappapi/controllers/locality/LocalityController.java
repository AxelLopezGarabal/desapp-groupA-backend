package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.locality;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.locality.requestbody.LocalityBodyPost;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Locality;
import ar.edu.unq.desapp.grupoa.backenddesappapi.service.locality.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class LocalityController {

    @Autowired
    private LocalityService localityService;

    public LocalityController(LocalityService localityService) {
        this.localityService = localityService;
    }

    //get_ALL
    @RequestMapping(value = "/locality/list", method = RequestMethod.GET)
    public ResponseEntity  listLocalities() {
        List<Locality> localitiesDetails = localityService.getLocalitiesDetails();
        return new ResponseEntity (localitiesDetails, HttpStatus.OK);
    }

    //get_ONE
    @RequestMapping(value = "/locality/{id}", method = RequestMethod.GET)
    public ResponseEntity getLocality(@PathVariable Integer id){
        Locality recoveredLocality = localityService.getById(id);
        return new ResponseEntity(recoveredLocality, HttpStatus.OK);
    }

    //ADD_ONE
    @RequestMapping(value = "/locality/", method = RequestMethod.POST)
    public ResponseEntity addLocality(@RequestBody LocalityBodyPost locality){
        localityService.save(locality);
        return new ResponseEntity(HttpStatus.OK);
    }

    //DELETE_ONE
    @RequestMapping(value = "/locality/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteLocality(@PathVariable Integer id){
        localityService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
