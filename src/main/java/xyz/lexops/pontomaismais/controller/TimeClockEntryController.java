package xyz.lexops.pontomaismais.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.lexops.pontomaismais.model.Employee;
import xyz.lexops.pontomaismais.model.TimeClockEntry;
import xyz.lexops.pontomaismais.service.EmployeeService;
import xyz.lexops.pontomaismais.service.TimeClockEntryService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping
public class TimeClockEntryController {

    @Autowired
    private TimeClockEntryService timeClockEntryService;
    private EmployeeService employeeService;

    @GetMapping("/employee/{employeeId}/time-clock")
    public ResponseEntity<List<TimeClockEntry>> getAllTimeClockEntrys(@PathVariable Long employeeId){
        Optional<Employee> employee = employeeService.findById(employeeId);
        if (employee.isPresent()){
            return ResponseEntity.ok(timeClockEntryService.findTimeClockEntriesByEmployeeId(employeeId));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/employee/{employeeId}/time-clock")
    public ResponseEntity<TimeClockEntry> createTimeClockEntry(@PathVariable Long employeeId){
        Optional<Employee> employee = employeeService.findById(employeeId);
        if (employee.isPresent()){
            TimeClockEntry timeClockEntry =
                    new TimeClockEntry(employee.get(), LocalDateTime.now());
            return new ResponseEntity<>(timeClockEntryService.save(timeClockEntry), HttpStatus.CREATED);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/employee/{employeeId}/time-clock")
    public ResponseEntity<TimeClockEntry> updateTimeClockEntry(@PathVariable Long employeeId){
        Optional<Employee> employee = employeeService.findById(employeeId);
        if (employee.isPresent()){
            Optional<TimeClockEntry> timeClockEntry =
                    timeClockEntryService.findLastTimeEntryFromEmployeeId(employeeId);
            if (timeClockEntry.isPresent()) {
                TimeClockEntry updatedTimeClockEntry = timeClockEntry.get();
                updatedTimeClockEntry.setClockOut(LocalDateTime.now());
                return ResponseEntity.ok(timeClockEntryService.save(updatedTimeClockEntry));
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
