package uz.pdp.springbootprojectprocesses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootprojectprocesses.entity.les10_2.ClickApps;
import uz.pdp.springbootprojectprocesses.payload.ClickAppsDto;

import java.util.UUID;

public interface ClickAppsRepository extends JpaRepository<ClickApps, UUID> {
}
