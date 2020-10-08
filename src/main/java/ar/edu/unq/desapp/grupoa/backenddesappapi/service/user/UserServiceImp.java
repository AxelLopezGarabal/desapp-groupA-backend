package ar.edu.unq.desapp.grupoa.backenddesappapi.service.user;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.donation.requestbody.DonationRequestBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.requestbody.UserBodyPost;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.requestbody.UserBodyPut;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.responsebody.UserResponseBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.responsebody.UserResponseBodyList;
import ar.edu.unq.desapp.grupoa.backenddesappapi.dao.project.ProjectDAO;
import ar.edu.unq.desapp.grupoa.backenddesappapi.dao.punctuationsystem.PunctuationSystemDAO;
import ar.edu.unq.desapp.grupoa.backenddesappapi.dao.user.UserDAO;
import ar.edu.unq.desapp.grupoa.backenddesappapi.dao.wallet.WalletDAO;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.MailValidation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Project;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.PunctuationSystem;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.User;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private PunctuationSystemDAO systemDAO;
    @Autowired
    private WalletDAO walletDAO;
    @Autowired
    private ProjectDAO projectDAO;

    @Override
    public List<UserResponseBodyList> listAllUsers() {
        return ((List<User>) userDAO.findAll()).stream().map(UserResponseBodyList::new).collect(Collectors.toList());
    }

    @Override
    public UserResponseBody getById(Integer id) {
        User userRecovered = userDAO.findById(Long.valueOf(id)).orElse(new User());
        return new UserResponseBody(userRecovered);
    }

    @Override
    public void update(UserBodyPut body, Long id) {
        userDAO.findById(Long.valueOf(id))
                .map(recoverUser -> {
                    try {
                        recoverUser.updateUser(body);
                    } catch (MailValidation mailValidation) {
                        mailValidation.printStackTrace();
                    }
                    return userDAO.save(recoverUser);
                })
                .orElse(new User());
    }

    @Override
    public void delete(Integer id) {
        userDAO.deleteById(Long.valueOf(id));
    }

    @Override
    public void save(UserBodyPost user) throws MailValidation {
        PunctuationSystem system = systemDAO.findAll().iterator().next();
        Wallet newWallet = walletDAO.save(new Wallet(0.0, system));
        User newUser = ((new User()).setUser(user));
        newUser.setWallet(newWallet);
        userDAO.save(newUser);
    }

    @Override
    public void donate(Integer id, DonationRequestBody body) {
        User recoveredUser = userDAO.findById(Long.valueOf(id)).orElse(new User());
        Project recoveredProject = projectDAO.findById(Long.valueOf(body.getProjectId())).orElse(new Project());
        recoveredUser.createDonation(body.getAmount(), recoveredProject);
        userDAO.save(recoveredUser);
        projectDAO.save(recoveredProject);
    }
}

