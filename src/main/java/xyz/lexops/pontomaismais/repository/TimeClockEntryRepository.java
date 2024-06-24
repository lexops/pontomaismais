package xyz.lexops.pontomaismais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.lexops.pontomaismais.model.TimeClockEntry;

import java.util.Optional;
import java.util.List;

public interface TimeClockEntryRepository extends JpaRepository<TimeClockEntry, Long> {
    List<TimeClockEntry> findByEmployeeId(Long employeeId);

    Optional<TimeClockEntry> findTop1ByEmployeeIdOrderByClockInDesc(Long employeeId);

}