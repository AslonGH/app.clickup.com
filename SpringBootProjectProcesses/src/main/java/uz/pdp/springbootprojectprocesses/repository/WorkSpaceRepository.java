package uz.pdp.springbootprojectprocesses.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootprojectprocesses.entity.Les9.WorkSpace;

import java.util.Optional;
import java.util.UUID;

public interface WorkSpaceRepository extends JpaRepository<WorkSpace,Long> {

    boolean existsByOwnerIdAndName(UUID owner_id, String name);
    boolean existsByOwnerIdAndNameNot(UUID owner_id, String name);
    Optional<WorkSpace> findByOwnerId(UUID owner_id);



}
