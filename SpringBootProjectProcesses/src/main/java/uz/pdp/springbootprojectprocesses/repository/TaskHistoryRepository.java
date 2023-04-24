package uz.pdp.springbootprojectprocesses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootprojectprocesses.entity.les10_2.TaskHistory;

import java.util.UUID;

public interface TaskHistoryRepository extends JpaRepository<TaskHistory, UUID> {
}
