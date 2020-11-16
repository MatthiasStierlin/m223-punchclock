package ch.zli.m223.punchclock.domain;

import javax.persistence.*;

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
    Long projectID;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String description;

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
}
