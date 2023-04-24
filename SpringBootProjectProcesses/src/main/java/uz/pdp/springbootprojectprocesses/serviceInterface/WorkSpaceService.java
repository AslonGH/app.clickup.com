package uz.pdp.springbootprojectprocesses.serviceInterface;

import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.*;

import java.util.List;
import java.util.UUID;

public interface WorkSpaceService {

     ApiResponse  addWorSpace(WorkSpaceDto workSpaceDto,  User user);

     ApiResponse  editWorSpace(WorkSpaceDto workSpaceDto);

     ApiResponse  changeOwnerWorkSpace(Long id, UUID ownerId);

     ApiResponse  deleteWorkSpace(Long id);

     ApiResponse  addOrEditRemoveWorkSpace(Long id, MemberDto memberDto);

     ApiResponse  joinToWorkSpace(Long id, User user);

     // ApiResponse getMemberAndGuestWorkSpaces(Long id);

     List<MemberDto> getMemberAndGuestWorkSpaces(Long id);

     ApiResponse addWorSpaceRole(Long workSpaceId, WorkSpaceRoleDto workSpaceRoleDto, User user);

     ApiResponse addOrRemovePermissionToWorkSpaceRole(AddRemovePermissionDto dto);

     List<WorkSpaceDto> getMyWorkSpaces(User user);
}
