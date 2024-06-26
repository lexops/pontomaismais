package xyz.lexops.pontomaismais.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lexops.pontomaismais.exceptions.EmployeeNotFoundException;
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

    public TimeClockEntry findLastTimeEntryFromEmployeeId(Long employeeId) throws EmployeeNotFoundException {
        Optional<TimeClockEntry> timeClockEntry =
                timeClockEntryRepository.findTop1ByEmployeeIdOrderByClockInDesc(employeeId);
        if (timeClockEntry.isPresent()){
            return timeClockEntry.get();
        }
        throw new EmployeeNotFoundException();
    }

    public List<TimeClockEntry> findAll(){
        return timeClockEntryRepository.findAll();
    }

    public TimeClockEntry findById(Long id) throws EmployeeNotFoundException {
        Optional<TimeClockEntry> timeClockEntry = timeClockEntryRepository.findById(id);
        if (timeClockEntry.isPresent()){
            return timeClockEntry.get();
        }
        throw new EmployeeNotFoundException();
    }

    public TimeClockEntry save(TimeClockEntry timeClockEntry){
        return timeClockEntryRepository.save(timeClockEntry);
    }

    public void deleteById(Long id){
        timeClockEntryRepository.deleteById(id);
    }

}
