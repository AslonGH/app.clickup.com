package uz.pdp.springbootprojectprocesses.serviceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.springbootprojectprocesses.serviceInterface.ProjectService;
import uz.pdp.springbootprojectprocesses.entity.Les9.WorkSpaceUser;
import uz.pdp.springbootprojectprocesses.entity.enums.AddType;
import uz.pdp.springbootprojectprocesses.entity.Les9.Project;
import uz.pdp.springbootprojectprocesses.entity.Les9.ProjectUser;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.ProjectDto;
import uz.pdp.springbootprojectprocesses.payload.ProjectUserAddEditRemDto;
import uz.pdp.springbootprojectprocesses.repository.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService {

     @Autowired
     SpaceRepository  spaceRepository;
     @Autowired
     WorkspaceUserRepository workspaceUserRepository;
     @Autowired
     ProjectRepository projectRepository;
     @Autowired
     ProjectUserRepository projectUserRepository;


    @Override
    public ApiResponse addFolder(ProjectDto projectDto) {

          Project project =new Project();
        project.setName(projectDto.getName());
        project.setSpace(spaceRepository.findById(projectDto.getSpaceId()).orElseThrow(() -> new ResourceNotFoundException(projectDto.getSpaceId()+ " not found ")));
        project.setColor(projectDto.getColor());
        project.setAccessType(projectDto.getAccessType());
        project.setArchived(projectDto.isArchived());
        projectRepository.save(project);
        return new ApiResponse("Project saved",true);
    }

    @Override
    public ApiResponse editFolder(ProjectDto projectDto, UUID id) {

         Project project = projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " not found "));
        project.setName(projectDto.getName());
        project.setSpace(spaceRepository.findById(projectDto.getSpaceId()).orElseThrow(() -> new ResourceNotFoundException(projectDto.getSpaceId()+ " not found ")));
        project.setColor(projectDto.getColor());
        project.setAccessType(projectDto.getAccessType());
        project.setArchived(projectDto.isArchived());
        projectRepository.save(project);
        return new ApiResponse("Project edited",true);
    }

    @Override
    public ApiResponse deleteFolder(UUID id) {
        try {
            projectRepository.deleteById(id);
            return new ApiResponse("deleted",true);
        }catch (Exception e){
            return new ApiResponse("not deleted",false);
        }
    }

    @Override
    public ApiResponse getFolders() {
        List<Project> all = projectRepository.findAll();
        return new ApiResponse("List of projects",true, Collections.singletonList(all));
    }

    @Override
    public ApiResponse addOrEditRemoveProjectUser(UUID id, ProjectUserAddEditRemDto dto) {

        Optional<WorkSpaceUser> optionalUser= workspaceUserRepository.findById(dto.getUserId());
        if(!optionalUser.isPresent())
            return new ApiResponse("bunday User yo'q",false);

        if (dto.getAddType().equals(AddType.ADD)) {
             ProjectUser projectUser=new ProjectUser();
            projectUser.setProject(projectRepository.findById(dto.getProjectId()).orElseThrow(() -> new ResourceNotFoundException(dto.getProjectId()+ " not found ")));
            projectUser.setUser(optionalUser.get().getUser());
            projectUser.setTaskPermission(dto.getTaskPermission());
            projectUserRepository.save(projectUser);
        }
        else if (dto.getAddType().equals(AddType.EDIT)) {
            ProjectUser projectUser = projectUserRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " not found "));
            projectUser.setProject(projectRepository.findById(dto.getProjectId()).orElseThrow(() -> new ResourceNotFoundException(dto.getProjectId()+ " not found ")));
            projectUser.setUser(optionalUser.get().getUser());
            projectUser.setTaskPermission(dto.getTaskPermission());
            projectUserRepository.save(projectUser);
        } else if (dto.getAddType().equals(AddType.REMOVE)) {
            projectUserRepository.deleteById(id);
        }
        return new ApiResponse("Muvaffaqiyatli bajarildi",true);
    }

}
