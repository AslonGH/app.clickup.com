package uz.pdp.springbootprojectprocesses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Task;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}
