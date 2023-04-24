package uz.pdp.springbootprojectprocesses.serviceInterface;

import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.ProjectDto;
import uz.pdp.springbootprojectprocesses.payload.ProjectUserAddEditRemDto;

import java.util.UUID;

public interface ProjectService {

    ApiResponse addFolder(ProjectDto projectDto);
    ApiResponse editFolder(ProjectDto projectDto, UUID id);
    ApiResponse getFolders();
    ApiResponse addOrEditRemoveProjectUser(UUID id, ProjectUserAddEditRemDto projectUserDto);
    ApiResponse deleteFolder(UUID id);

    // ApiResponse joinToFolder(Long id, User user);
    // ApiResponse changeOwnerFolder(Long id, UUID ownerId);
}
