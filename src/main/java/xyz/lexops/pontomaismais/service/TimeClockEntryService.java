package xyz.lexops.pontomaismais.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lexops.pontomaismais.model.TimeClockEntry;
import xyz.lexops.pontomaismais.repository.TimeClockEntryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TimeClockEntryService {

    @Autowired
    private TimeClockEntryRepository timeClockEntryRepository;

    public List<TimeClockEntry> findTimeClockEntriesByEmployeeId(Long employeeId) {
        return timeClockEntryRepository.findByEmployeeId(employeeId);
    }

    public Optional<TimeClockEntry> findLastTimeEntryFromEmployeeId(Long employeeId) {
        return timeClockEntryRepository.findTop1ByEmployeeIdOrderByClockInDesc(employeeId);
    }

    public List<TimeClockEntry> findAll(){
        return timeClockEntryRepository.findAll();
    }

    public Optional<TimeClockEntry> findById(Long id){
        return timeClockEntryRepository.findById(id);
    }

    public TimeClockEntry save(TimeClockEntry timeClockEntry){
        return timeClockEntryRepository.save(timeClockEntry);
    }

    public void deleteById(Long id){
        timeClockEntryRepository.deleteById(id);
    }

}
