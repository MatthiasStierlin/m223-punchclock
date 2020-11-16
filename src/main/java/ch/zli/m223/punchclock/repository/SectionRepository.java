package ch.zli.m223.punchclock.repository;

import ch.zli.m223.punchclock.domain.Section;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * SectionRepository
 *
 * @author Matthias Stierlin
 * @version 16.11.2020
 */
public interface SectionRepository extends JpaRepository<Section, Long> {
}
