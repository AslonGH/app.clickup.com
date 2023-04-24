package uz.pdp.springbootprojectprocesses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootprojectprocesses.entity.les10_2.TaskDependency;
import uz.pdp.springbootprojectprocesses.payload.TaskDependencyDto;

import java.util.UUID;

public interface TaskDependencyRepository extends JpaRepository<TaskDependency, UUID> {
}
