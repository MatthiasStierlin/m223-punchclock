package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Project;
import ch.zli.m223.punchclock.domain.Section;
import ch.zli.m223.punchclock.service.ProjectService;
import ch.zli.m223.punchclock.service.SectionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * ProjectController
 *
 * @author Matthias Stierlin
 * @version 16.11.2020
 */
@RestController
@RequestMapping("/projects")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Project createProject(@Valid @RequestBody Project project) {
        return projectService.createProject(project);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @DeleteMapping("/{projectId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable Long projectId) {
        projectService.deleteProject(projectId);
    }

    @PutMapping("/{projectId}")
    @ResponseStatus(HttpStatus.OK)
    public Project updateProject(@PathVariable Long projectId, @Valid @RequestBody Project project) {
        project.setProjectID(projectId);
        return projectService.updateProject(project);
    }
}
