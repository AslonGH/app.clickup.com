package uz.pdp.springbootprojectprocesses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootprojectprocesses.entity.Les9.WorkSpaceRole;

import java.util.UUID;

public interface WorkSpaceRoleRepository extends JpaRepository<WorkSpaceRole, UUID> {

    void findAllByWorkSpaceIdAndWorkSpaceName(Long workSpace_id, String workSpace_name);


    boolean existsByWorkSpaceIdAndName(Long workSpace_id, String name);
}
