package ar.edu.unq.desapp.grupoa.backenddesappapi.service.locality;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.locality.requestbody.LocalityBodyPost;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Locality;

import java.util.List;

public interface LocalityService {

    List<Locality> getLocalitiesDetails();

    Locality getById(Integer id);

    void save(LocalityBodyPost locality);

    void delete(Integer id);
}
