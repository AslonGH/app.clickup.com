package uz.pdp.springbootprojectprocesses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Priority;

import java.util.UUID;

public interface PriorityRepository extends JpaRepository<Priority, UUID> {
}
