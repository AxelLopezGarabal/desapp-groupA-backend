package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.donation.requestbody.DonationRequestBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.requestbody.UserBodyPost;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.requestbody.UserBodyPut;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.responsebody.UserResponseBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.responsebody.UserResponseBodyList;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidIdException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidOrNullFieldException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.MailValidation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    private @Autowired UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //get_ALL
    @GetMapping(value = "/list", produces = { "application/json" })
    public ResponseEntity listUsers() {
        List<UserResponseBodyList> usersDetails = userService.listAllUsers();
        return new ResponseEntity (usersDetails, HttpStatus.OK);
    }

    //get_ONE
    @GetMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity getUser(@PathVariable Integer id) throws InvalidIdException {
        UserResponseBody recoveredUser = userService.getById(id);
        return new ResponseEntity(recoveredUser, HttpStatus.OK);
    }

    //update exception for id and body
    @PutMapping(value = "/{id}", produces = { "application/json" },consumes = { "application/json" })
    public  ResponseEntity updateUser(@RequestBody UserBodyPut user, @PathVariable Long id) throws MailValidation, InvalidIdException, InvalidOrNullFieldException {
        userService.update(user, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    //ADD_ONE exception for body
    @PostMapping(value = "/register", produces = { "application/json" },consumes = { "application/json" })
    public ResponseEntity save(@RequestBody UserBodyPost user) throws MailValidation, InvalidOrNullFieldException {
        userService.save(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    //DELETE_ONE exception for id
    @DeleteMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity deleteUser(@PathVariable Integer id) throws InvalidIdException {
        userService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    //DONATE exception for id and body
    @PostMapping(value = "/{id}/donate", produces = { "application/json" },consumes = { "application/json" })
    public ResponseEntity donate(@PathVariable Integer id, @RequestBody DonationRequestBody body) throws InvalidIdException, InvalidOrNullFieldException {
        userService.donate(id, body);
        return new ResponseEntity(HttpStatus.OK);
    }
}
