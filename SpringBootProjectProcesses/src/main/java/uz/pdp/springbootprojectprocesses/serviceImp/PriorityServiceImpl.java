package uz.pdp.springbootprojectprocesses.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Priority;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.PriorityDto;
import uz.pdp.springbootprojectprocesses.repository.IconRepository;
import uz.pdp.springbootprojectprocesses.repository.PriorityRepository;
import uz.pdp.springbootprojectprocesses.serviceInterface.PriorityService;

import java.util.UUID;

@Service
public class PriorityServiceImpl implements PriorityService {

    @Autowired
    IconRepository iconRepository;
    @Autowired
    PriorityRepository priorityRepository;

    @Override
    public ApiResponse addPriorityService(PriorityDto priorityDto) {

         Priority priority=new Priority();
        priority.setName(priorityDto.getName());
        priority.setIcon(iconRepository.findById(priorityDto.getIconID()).orElseThrow(() -> new ResourceNotFoundException("not Found")));
        priorityRepository.save(priority);
        return new ApiResponse("saved",true);
    }

    @Override
    public ApiResponse editPriorityService(PriorityDto priorityDto, UUID uuid) {

         Priority priority = priorityRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("not Found"));
        priority.setName(priorityDto.getName());
        priority.setIcon(iconRepository.findById(priorityDto.getIconID()).orElseThrow(() -> new ResourceNotFoundException("not Found")));
        priorityRepository.save(priority);
        return new ApiResponse("edited",true);
    }

    @Override
    public ApiResponse deletePriorityService(UUID id) {
      try {
           priorityRepository.deleteById(id);
          return new ApiResponse("deleted",true);
      }catch (Exception e){
          return new ApiResponse("not deleted",false);
      }

    }
}
