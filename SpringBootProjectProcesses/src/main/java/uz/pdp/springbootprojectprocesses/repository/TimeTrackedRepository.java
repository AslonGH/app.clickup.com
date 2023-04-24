package uz.pdp.springbootprojectprocesses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootprojectprocesses.entity.les10_2.TimeTracked;
import uz.pdp.springbootprojectprocesses.payload.TimeTrackedDto;

import java.util.UUID;

public interface TimeTrackedRepository extends JpaRepository<TimeTracked, UUID> {
}
