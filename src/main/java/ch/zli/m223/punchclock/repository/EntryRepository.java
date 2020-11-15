package ch.zli.m223.punchclock.repository;

import ch.zli.m223.punchclock.domain.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Matthias Stierlin
 * @version 13.11.2020
 */
public interface EntryRepository extends JpaRepository<Entry, Long> {
}
