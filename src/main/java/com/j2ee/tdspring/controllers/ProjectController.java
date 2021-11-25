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
            @RequestBody String author,
            @RequestBody String description,
            @RequestBody String name,
            @RequestBody int number_patients,
            @RequestBody int wishing_patients,
            @RequestBody Date created_at,
            @RequestBody List<String> followers,
            @RequestBody List<String> participants,
            @RequestBody List<Keywords> keywords,
            @RequestBody List<Messages> messages
    ) {
        Projects projects = new Projects();
        projects.setCreated_at(created_at);
        projects.setAuthor(userService.getUserById(author));
        projects.setDescription(description);
        projects.setName(name);
        projects.setNumber_patient(number_patients);
        projects.setWishing_patient(wishing_patients);
        projects.setFollowers(projectService.getFollowers(followers));
        projects.setParticipants(projectService.getParticipants(participants));
//        projects.setRequests(requests);
        projects.setKeywords(keywords);
        projects.setMessages(messages);
        projectService.createOrUpdate(projects);
    }
}
