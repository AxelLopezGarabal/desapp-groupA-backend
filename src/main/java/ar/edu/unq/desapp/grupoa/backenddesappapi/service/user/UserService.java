package ar.edu.unq.desapp.grupoa.backenddesappapi.service.user;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.donation.requestbody.DonationRequestBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.requestbody.UserBodyPost;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.requestbody.UserBodyPut;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.responsebody.UserResponseBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.responsebody.UserResponseBodyList;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.MailValidation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.User;

import java.util.List;

public interface UserService {
    List<UserResponseBodyList> listAllUsers();

    UserResponseBody getById(Integer id);

    void update(UserBodyPut body, Long id);

    void delete(Integer id);

    void save(UserBodyPost user) throws MailValidation;

    void donate(Integer id, DonationRequestBody body);
}
