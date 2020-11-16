package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Section;
import ch.zli.m223.punchclock.repository.SectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SectionService
 *
 * @author Matthias Stierlin
 * @version 16.11.2020
 */
@Service
public class SectionService {
    private SectionRepository sectionRepository;

    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public Section createSection(Section section) {
        return sectionRepository.saveAndFlush(section);
    }

    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    public void deleteSection(Long id) {
        sectionRepository.deleteById(id);
    }

    public Section updateSection(Section section) {
        return sectionRepository.save(section);
    }
}
