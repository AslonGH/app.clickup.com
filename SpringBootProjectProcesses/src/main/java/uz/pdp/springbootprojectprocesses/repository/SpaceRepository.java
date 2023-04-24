package uz.pdp.springbootprojectprocesses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootprojectprocesses.entity.Les9.Space;

import java.util.UUID;

public interface SpaceRepository extends JpaRepository<Space, UUID> {
    boolean existsByName(String name);
}
