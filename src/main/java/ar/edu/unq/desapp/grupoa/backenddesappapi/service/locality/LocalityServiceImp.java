package ar.edu.unq.desapp.grupoa.backenddesappapi.service.locality;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.locality.requestbody.LocalityBodyPost;
import ar.edu.unq.desapp.grupoa.backenddesappapi.dao.locality.LocalityDAO;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Locality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalityServiceImp implements LocalityService {

    @Autowired
    private LocalityDAO localityDAO;

    @Override
    public List<Locality> getLocalitiesDetails() {
        return (List<Locality>) localityDAO.findAll();
    }

    @Override
    public Locality getById(Integer id) {
        return localityDAO.findById(Long.valueOf(id)).orElse(new Locality());//TODO:: SHOULD BE AN EXCEPTION
    }

    @Override
    public void save(LocalityBodyPost body) {
        Locality newLocality = new Locality();
        localityDAO.save(newLocality.setBody(body));
    }

    @Override
    public void delete(Integer id) {
        localityDAO.deleteById(Long.valueOf(id));
    }
}
