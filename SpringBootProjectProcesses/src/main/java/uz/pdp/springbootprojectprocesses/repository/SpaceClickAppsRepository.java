package uz.pdp.springbootprojectprocesses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootprojectprocesses.entity.les10_2.SpaceClickApps;
import uz.pdp.springbootprojectprocesses.payload.SpaceClickAppsDto;

import java.util.UUID;

public interface SpaceClickAppsRepository extends JpaRepository<SpaceClickApps, UUID> {
}
