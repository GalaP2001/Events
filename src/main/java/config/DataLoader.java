package config;

import entities.ERole;
import entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import repositories.RoleRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.count() == 0) {
            Role adminRole = new Role();
            adminRole.setName(ERole.ROLE_ADMIN);

            Role userRole = new Role();
            userRole.setName(ERole.ROLE_USER);

            Role guestRole = new Role();
            guestRole.setName(ERole.ROLE_GUEST);

            roleRepository.save(adminRole);
            roleRepository.save(userRole);
            roleRepository.save(guestRole);
        }
    }
}