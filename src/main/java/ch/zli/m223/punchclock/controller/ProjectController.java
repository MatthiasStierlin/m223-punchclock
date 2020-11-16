package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Project;
import ch.zli.m223.punchclock.service.ProjectService;
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

    /** Creates a new project.
     *
     * @param project
     * @return
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Project createProject(@Valid @RequestBody Project project) {
        return projectService.createProject(project);
    }

    /** Returns all projects.
     *
     * @return
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    /** Deletes an existing project.
     *
     * @param projectId
     */
    @DeleteMapping("/{projectId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable Long projectId) {
        projectService.deleteProject(projectId);
    }

    /** Updates an existing project.
     *
     * @param projectId
     * @param project
     * @return
     */
    @PutMapping("/{projectId}")
    @ResponseStatus(HttpStatus.OK)
    public Project updateProject(@PathVariable Long projectId, @Valid @RequestBody Project project) {
        project.setProjectID(projectId);
        return projectService.updateProject(project);
    }
}
