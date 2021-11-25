package com.j2ee.tdspring.controllers;

import com.j2ee.tdspring.entities.*;
import com.j2ee.tdspring.repositories.UserRepository;
import com.j2ee.tdspring.services.ProjectService;
import com.j2ee.tdspring.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController 
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;

    @Operation(summary = "Créer un projet")
    @Valid
    @RequestMapping(path = "/project", method = RequestMethod.POST)
    public void addProject(
            @RequestParam("followers") List<String> followers,
            @RequestParam("description") String description,
            @RequestParam("author") String author,
            @RequestParam("name") String name,
            @RequestParam("number_patients") int number_patients,
            @RequestParam("wishing_patients") int wishing_patients,
            @RequestParam("keywords") List<Keywords> keywords,
            @RequestParam("closed_at") List<Messages> messages,
            @RequestParam("participants") List<String> participants
    ) {
        Projects projects = new Projects();
        projects.setAuthor(userService.getUserById(author));
        projects.setDescription(description);
        projects.setName(name);
        projects.setNumber_patient(number_patients);
        projects.setWishing_patient(wishing_patients);
        projects.setCreated_at(new Date());
        projects.setClosed_at(new Date());
        projects.setFollowers(projectService.getFollowers(followers));
        projects.setParticipants(projectService.getParticipants(participants));
        projects.setKeywords(keywords);
        projects.setMessages(messages);
        projectService.createOrUpdate(projects);
    }
}
