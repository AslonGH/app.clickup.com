package uz.pdp.springbootprojectprocesses.serviceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Status;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.StatusDto;
import uz.pdp.springbootprojectprocesses.repository.CategoryRepository;
import uz.pdp.springbootprojectprocesses.repository.ProjectRepository;
import uz.pdp.springbootprojectprocesses.repository.SpaceRepository;
import uz.pdp.springbootprojectprocesses.repository.StatusRepository;
import uz.pdp.springbootprojectprocesses.serviceInterface.StatusService;

import java.util.UUID;


@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    SpaceRepository spaceRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public ApiResponse addStatus(StatusDto statusDto) {

     Status status=new Status();
    status.setName(statusDto.getName());
    status.setColor(statusDto.getColor());
    status.setSpace(spaceRepository.findById(statusDto.getSpaceID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
    status.setProject(projectRepository.findById(statusDto.getProjectID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
    status.setCategory(categoryRepository.findById(statusDto.getCategoryID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
    status.setType(statusDto.getType());
    statusRepository.save(status);
    return new ApiResponse("saved",true);
    }

    @Override
    public ApiResponse editStatus(StatusDto statusDto, UUID id) {

        Status status = statusRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
     status.setName(statusDto.getName());
     status.setColor(statusDto.getColor());
     status.setSpace(spaceRepository.findById(statusDto.getSpaceID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
     status.setProject(projectRepository.findById(statusDto.getProjectID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
     status.setCategory(categoryRepository.findById(statusDto.getCategoryID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
     status.setType(statusDto.getType());
     statusRepository.save(status);
     return new ApiResponse("edited",true);
    }


}
