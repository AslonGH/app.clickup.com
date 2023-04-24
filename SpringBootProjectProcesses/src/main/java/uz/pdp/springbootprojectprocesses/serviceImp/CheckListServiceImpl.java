package uz.pdp.springbootprojectprocesses.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.entity.les10_2.CheckList;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.CheckListDto;
import uz.pdp.springbootprojectprocesses.repository.TaskRepository;
import uz.pdp.springbootprojectprocesses.repository.CheckListRepository;
import uz.pdp.springbootprojectprocesses.serviceInterface.CheckListService;

import java.util.UUID;

@Service
public class CheckListServiceImpl implements CheckListService {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    CheckListRepository checkListRepository;


    @Override
    public ApiResponse addCheckList(CheckListDto checkListDto) {

       CheckList checkList=new CheckList();
      checkList.setName(checkListDto.getName());
      checkList.setTask(taskRepository.findById(checkListDto.getTaskID()).orElseThrow(
               () ->new ResourceNotFoundException("not found")));
      checkListRepository.save(checkList);
      return new ApiResponse("saved",true);
    }

    @Override
    public ApiResponse editCheckList(CheckListDto checkListDto, UUID id) {

         CheckList checkList = checkListRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
        checkList.setName(checkListDto.getName());
        checkList.setTask(taskRepository.findById(checkListDto.getTaskID()).orElseThrow(
                                                                     () ->new ResourceNotFoundException("not found")));
        checkListRepository.save(checkList);
        return new ApiResponse("edited",true);
    }

    @Override
    public ApiResponse deleteCheckList(UUID id) {
         try {
             checkListRepository.deleteById(id);
             return new ApiResponse("delete",true);
         }catch (Exception e){

             return new ApiResponse("not deleted",false);
         }
    }

}
