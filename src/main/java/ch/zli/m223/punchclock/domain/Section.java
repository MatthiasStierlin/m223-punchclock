package ch.zli.m223.punchclock.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.glassfish.jersey.jaxb.internal.XmlJaxbElementProvider;

import javax.persistence.*;
import java.util.Set;

/**
 * Section
 *
 *  This Entity is called "Abteilung" in the Fachklassendiagramm.
 *
 * @author Matthias Stierlin
 * @version 16.11.2020
 */
@Entity
@JsonIgnoreProperties({"applicationUser"})
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sectionId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @OneToMany
    private Set<ApplicationUser> applicationUser;

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
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
