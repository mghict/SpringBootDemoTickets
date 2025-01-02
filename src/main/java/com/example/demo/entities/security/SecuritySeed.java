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
        List<Role> roles = Arrays.asList(
                new Role(1L,"ADMIN"),
                new Role(2L,"USER")
        );

        Iterable<Role> rolesSaved= roleRepository.saveAll(roles);
        Set<Role> rolesSavedSet = new HashSet<Role>();
        rolesSaved.forEach(role -> rolesSavedSet.add(role));



        List<User> users =new ArrayList<User>();
        users.add(
                new User("admin",
                        "root",
                        true,
                        rolesSavedSet)
        );

        Optional<Role> userRole=rolesSavedSet
                                        .stream()
                                        .filter(p->"USER".equals(p.getName()))
                                        .findFirst();
        if(userRole.isPresent()){
            Set<Role> userRoleSelected = new HashSet<Role>();
            userRoleSelected.add(userRole.get());
            new User("user",
                     "pass",
                    true,
                    userRoleSelected);
        }

        userRepository.saveAll(users);
    }
}