package uz.pdp.springbootprojectprocesses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootprojectprocesses.entity.Les9.Project;

import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, UUID> {
}
