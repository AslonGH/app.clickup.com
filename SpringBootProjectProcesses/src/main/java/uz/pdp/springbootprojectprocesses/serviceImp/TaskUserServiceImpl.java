package uz.pdp.springbootprojectprocesses.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.springbootprojectprocesses.entity.les10_1.TaskUser;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.TaskUserDto;
import uz.pdp.springbootprojectprocesses.repository.TaskRepository;
import uz.pdp.springbootprojectprocesses.repository.TaskUserRepository;
import uz.pdp.springbootprojectprocesses.repository.UserRepository;
import uz.pdp.springbootprojectprocesses.serviceInterface.TaskUserService;

import java.util.UUID;

@Service
public class TaskUserServiceImpl implements TaskUserService {

    @Autowired
    TaskUserRepository taskUserRepository;
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserRepository userRepository;



    @Override
    public ApiResponse addTaskUserService(TaskUserDto taskUserDto) {

          TaskUser taskUser=new TaskUser();
      taskUser.setTask(taskRepository.findById(taskUserDto.getTaskID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
      taskUser.setUser(userRepository.findById(taskUserDto.getUserID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
      taskUserRepository.save(taskUser);
      return new ApiResponse("saved",true);
    }

    @Override
    public ApiResponse deleteTaskUserService(UUID id) {

        try {
            taskUserRepository.deleteById(id);
            return new ApiResponse("kategoriya öchirildi",true);
        }catch (Exception e){
            return new ApiResponse("Bunday ota kategoriya mavjud emas",false);
        }
    }



}
