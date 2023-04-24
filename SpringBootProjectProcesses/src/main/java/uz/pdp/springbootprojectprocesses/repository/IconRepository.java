package uz.pdp.springbootprojectprocesses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Icon;

import java.util.UUID;

public interface IconRepository extends JpaRepository<Icon, UUID> {
}
