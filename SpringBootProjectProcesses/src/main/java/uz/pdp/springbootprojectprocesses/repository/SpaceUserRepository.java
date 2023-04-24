package uz.pdp.springbootprojectprocesses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootprojectprocesses.entity.les10_2.SpaceUser;

import java.util.UUID;

public interface SpaceUserRepository extends JpaRepository<SpaceUser, UUID> {
}
