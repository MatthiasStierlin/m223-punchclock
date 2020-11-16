package ch.zli.m223.punchclock.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Project
 *
 * @author Matthias Stierlin
 * @version 16.11.2020
 */
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectID;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToMany
    private Set<ApplicationUser> applicationUser;

    public Long getProjectID() {
        return projectID;
    }

    public void setProjectID(Long projectID) {
        this.projectID = projectID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ApplicationUser> getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(Set<ApplicationUser> applicationUser) {
        this.applicationUser = applicationUser;
    }
}
