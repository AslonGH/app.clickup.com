package uz.pdp.springbootprojectprocesses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootprojectprocesses.entity.les10_1.TaskUser;

import java.util.UUID;

public interface TaskUserRepository extends JpaRepository<TaskUser, UUID> {
}
