package com.astontech.hr.services;

import com.astontech.hr.domain.Project ;

public interface ProjectService {

    Iterable<Project> listAllProject();

    Project getProjectById(Integer id);

    Project saveProject(Project project);

    Iterable<Project> saveProjectList (Iterable<Project> projectIterable);

    void deleteProject(Integer id);
}
