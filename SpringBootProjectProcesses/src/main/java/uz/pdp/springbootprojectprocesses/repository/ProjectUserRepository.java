package uz.pdp.springbootprojectprocesses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootprojectprocesses.entity.Les9.ProjectUser;

import java.util.UUID;

public interface ProjectUserRepository extends JpaRepository<ProjectUser, UUID> {
}
