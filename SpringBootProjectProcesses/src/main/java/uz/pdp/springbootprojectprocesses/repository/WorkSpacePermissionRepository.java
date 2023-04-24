package uz.pdp.springbootprojectprocesses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootprojectprocesses.entity.Les9.WorkSpacePermission;
import uz.pdp.springbootprojectprocesses.entity.enums.WorkSpacePermissionName;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkSpacePermissionRepository extends JpaRepository<WorkSpacePermission, UUID> {

    Optional<WorkSpacePermission> findByWorkSpaceRoleIdAndPermissionName(UUID workSpaceRole_id, WorkSpacePermissionName permissionName);

    List<WorkSpacePermission> findAllByWorkSpaceRole_NameAndWorkSpaceRole_WorkSpaceId(
                             String workSpaceRole_name, Long workSpaceRole_workSpace_id);
}
