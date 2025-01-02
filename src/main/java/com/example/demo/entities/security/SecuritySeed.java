package com.example.demo.entities.security;

import com.example.demo.entities.ticket.Ticket;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SecuritySeed implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        Iterable<Role> rolesSaved= createRole();
        createUserAdmin(rolesSaved);
        createUser(rolesSaved);
    }

    private Iterable<Role> createRole()
    {
        List<Role> roles = Arrays.asList(
                new Role(1L,"ADMIN"),
                new Role(2L,"USER")
        );

        return roleRepository.saveAll(roles);
    }

    private Set<Role> convertIterableRoleToSetRole(Iterable<Role> roles)
    {
        Set<Role> rolesSet = new HashSet<Role>();
        roles.forEach(role -> rolesSet.add(role));

        return rolesSet;
    }

    private void createUserAdmin(Iterable<Role> roles)
    {
        Set<Role> rolesSavedSet = convertIterableRoleToSetRole(roles);
        User user=
                new User("admin",
                        "root",
                        true,
                        rolesSavedSet);

        userRepository.save(user);
    }

    private Optional<Role> findUser(Iterable<Role> roles)
    {
        Set<Role> rolesSavedSet = convertIterableRoleToSetRole(roles);
        return rolesSavedSet
                .stream()
                .filter(p->"USER".equals(p.getName()))
                .findFirst();
    }

    private void createUser(Iterable<Role> roles) {
        Optional<Role> userRole = findUser(roles);
        if (userRole.isPresent()) {
            Set<Role> userRoleSelected = new HashSet<Role>();
            User user =
                    new User("user",
                            "pass",
                            true,
                            userRoleSelected);
            userRepository.save(user);
        }

    }
}