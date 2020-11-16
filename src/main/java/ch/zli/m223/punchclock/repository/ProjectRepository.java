package ch.zli.m223.punchclock.repository;

import ch.zli.m223.punchclock.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ProjectRepository
 *
 * @author Matthias Stierlin
 * @version 16.11.2020
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
