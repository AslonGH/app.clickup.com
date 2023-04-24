package uz.pdp.springbootprojectprocesses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootprojectprocesses.entity.les10_2.View;

import java.util.UUID;

public interface ViewRepository extends JpaRepository<View, UUID> {
}
