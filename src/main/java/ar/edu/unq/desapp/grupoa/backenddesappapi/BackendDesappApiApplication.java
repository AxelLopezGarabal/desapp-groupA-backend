package ar.edu.unq.desapp.grupoa.backenddesappapi;

import ar.edu.unq.desapp.grupoa.backenddesappapi.dao.locality.LocalityDAO;
import ar.edu.unq.desapp.grupoa.backenddesappapi.dao.project.ProjectDAO;
import ar.edu.unq.desapp.grupoa.backenddesappapi.dao.punctuationsystem.PunctuationSystemDAO;
import ar.edu.unq.desapp.grupoa.backenddesappapi.dao.user.UserDAO;
import ar.edu.unq.desapp.grupoa.backenddesappapi.dao.wallet.WalletDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BackendDesappApiApplication {

	public static void main(String[] args) {
	    ConfigurableApplicationContext configApp = SpringApplication.run(BackendDesappApiApplication.class, args);
        LocalityDAO localityDAO = configApp.getBean(LocalityDAO.class);
        ProjectDAO projectDAO = configApp.getBean(ProjectDAO.class);
        UserDAO userDAO = configApp.getBean(UserDAO.class);
        WalletDAO walletDAO = configApp.getBean(WalletDAO.class);
        PunctuationSystemDAO systemDAO = configApp.getBean(PunctuationSystemDAO.class);

        Loader loader = new Loader();
        loader.addLocalitiesEntities(localityDAO);
        loader.addProjectEntities(projectDAO);
        loader.add(systemDAO, walletDAO, userDAO);
	}

}
