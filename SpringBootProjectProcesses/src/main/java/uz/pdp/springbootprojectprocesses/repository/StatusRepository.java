package uz.pdp.springbootprojectprocesses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Status;

import java.util.UUID;

public interface StatusRepository extends JpaRepository<Status, UUID> {
}
