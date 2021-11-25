package com.j2ee.tdspring.controllers;

import com.j2ee.tdspring.entities.*;
import com.j2ee.tdspring.services.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController 
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Operation(summary = "Créer un projet")
    @Valid
    @RequestMapping(path = "/project", method = RequestMethod.POST)
    public void addProject(
            @RequestBody Users userReceive,
            @RequestBody List<Users> followers,
            @RequestBody List<Users> participants,
            @RequestBody List<Users> requests,
            @RequestBody List<Keywords> keywords,
            @RequestBody List<Messages> messages
    ) {
        Projects projects = new Projects();
        projects.setCreated_at(new Date());
        projects.setAuthor(userReceive);
        projects.setDescription("Nouveau projet des deux cracks");
        projects.setName("Ce genre de projet");
        projects.setNumber_patient(5);
        projects.setWishing_patient(10);
        projects.setFollowers(followers);
        projects.setParticipants(participants);
        projects.setRequests(requests);
        projects.setKeywords(keywords);
        projects.setMessages(messages);

        projectService.createOrUpdate(projects);
    }
}
