package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.repository.EntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * EntryService
 *
 * @author Matthias Stierlin
 * @version 13.11.2020
 */
@Service
public class EntryService {
    private EntryRepository entryRepository;

    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public Entry createEntry(Entry entry) {
        return entryRepository.saveAndFlush(entry);
    }

    public void deleteEntry(long id) {
        entryRepository.deleteById(id);
    }

    public List<Entry> findAll() {
        return entryRepository.findAll();
    }

    public Entry updateEntry(Entry entry) {
        return entryRepository.save(entry);
    }
}
