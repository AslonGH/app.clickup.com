package uz.pdp.springbootprojectprocesses.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.entity.les10_2.TaskDependency;
import uz.pdp.springbootprojectprocesses.entity.les10_2.View;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.TaskDependencyDto;
import uz.pdp.springbootprojectprocesses.repository.TaskDependencyRepository;
import uz.pdp.springbootprojectprocesses.repository.TaskRepository;
import uz.pdp.springbootprojectprocesses.serviceInterface.TaskDependencyService;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class TaskDependencyServiceImpl implements TaskDependencyService {

    @Autowired
    TaskDependencyRepository taskDepRepository;
    @Autowired
    TaskRepository taskRepository;


    @Override
    public ApiResponse addTaskDependency(TaskDependencyDto dependencyDto) {
           TaskDependency dependency=new TaskDependency();
        dependency.setTask(taskRepository.findById(dependencyDto.getTaskID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        dependency.setDependencyTask(taskRepository.findById(dependencyDto.getDependencyTaskID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        dependency.setDependencyType(dependency.getDependencyType());
        taskDepRepository.save(dependency);
        return new ApiResponse("saved",true);
    }

    @Override
    public ApiResponse editTaskDependency(TaskDependencyDto dependencyDto, UUID uuid) {
          TaskDependency dependency = taskDepRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("not found"));
        dependency.setTask(taskRepository.findById(dependencyDto.getTaskID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        dependency.setDependencyTask(taskRepository.findById(dependencyDto.getDependencyTaskID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        dependency.setDependencyType(dependency.getDependencyType());
        taskDepRepository.save(dependency);
        return new ApiResponse("edited",true);
    }

    @Override
    public ApiResponse deleteTaskDependency(UUID id) {
        try {
            taskDepRepository.deleteById(id);
            return new ApiResponse("deleted",true);
        }catch (Exception e){
            return new ApiResponse("not deleted",false);
        }
    }
}
