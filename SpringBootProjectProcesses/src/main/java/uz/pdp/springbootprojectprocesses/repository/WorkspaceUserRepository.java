package uz.pdp.springbootprojectprocesses.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.springbootprojectprocesses.entity.Les9.WorkSpaceUser;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

  public interface WorkspaceUserRepository extends JpaRepository<WorkSpaceUser, UUID> {

    Optional<WorkSpaceUser> findByWorkSpaceIdAndUserId(Long workSpace_id, UUID user_id);

   // List<WorkSpaceUser> findAllByWorkSpaceIdAndWorkSpaceRoleRoleNameIn(Long workSpace_id, Collection<WorkSpaceRoleName> workSpaceRole_roleName);


    @Transactional
    @Modifying       // NATIJASI KERAK EMAS, QOYMASAK XATOLIK BERADI
    void  deleteByWorkSpaceIdAndUserId(Long workSpace_id, UUID user_id);

      List<WorkSpaceUser> findAllByWorkSpaceId(Long id);

      List<WorkSpaceUser>findAllByUserId(UUID user_id);
  }
