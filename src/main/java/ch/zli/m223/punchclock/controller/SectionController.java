package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Section;
import ch.zli.m223.punchclock.service.SectionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * SectionController
 *
 * @author Matthias Stierlin
 * @version 16.11.2020
 */
@RestController
@RequestMapping("/sections")
public class SectionController {
    private SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Section createSection(@Valid @RequestBody Section section) {
        return sectionService.createSection(section);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Section> getAllSections() {
        return sectionService.getAllSections();
    }

    @DeleteMapping("/{sectionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSection(@PathVariable Long sectionId) {
        sectionService.deleteSection(sectionId);
    }

    @PutMapping("/{sectionId}")
    @ResponseStatus(HttpStatus.OK)
    public Section updateSection(@PathVariable Long sectionId, @Valid @RequestBody Section section) {
        section.setSectionId(sectionId);
        return sectionService.updateSection(section);
    }
}
