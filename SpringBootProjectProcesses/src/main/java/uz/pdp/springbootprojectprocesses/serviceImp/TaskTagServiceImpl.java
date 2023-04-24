package uz.pdp.springbootprojectprocesses.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.springbootprojectprocesses.entity.les10_1.TaskTag;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.TaskTagDto;
import uz.pdp.springbootprojectprocesses.repository.TagRepository;
import uz.pdp.springbootprojectprocesses.repository.TaskRepository;
import uz.pdp.springbootprojectprocesses.repository.TaskTagRepository;
import uz.pdp.springbootprojectprocesses.serviceInterface.TaskTagService;

import java.util.UUID;

@Service
public class TaskTagServiceImpl implements TaskTagService {

    @Autowired
    TaskTagRepository taskTagRepository;

    @Autowired
    TagRepository tagRepository;
     @Autowired
     TaskRepository taskRepository;


    @Override
    public ApiResponse addTaskAttachmentService(TaskTagDto taskTagDto) {

       TaskTag taskTag=new TaskTag();
      taskTag.setTask(taskRepository.findById(taskTagDto.getTaskID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
      taskTag.setTag(tagRepository.findById(taskTagDto.getTagID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
      taskTagRepository.save(taskTag);
      return new ApiResponse("saved",true);
    }

    @Override
    public ApiResponse editTaskTagService(TaskTagDto taskTagDto, UUID id ) {

         TaskTag taskTag = taskTagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
        taskTag.setTask(taskRepository.findById(taskTagDto.getTaskID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        taskTag.setTag(tagRepository.findById(taskTagDto.getTagID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        taskTagRepository.save(taskTag);
        return new ApiResponse("edited",true);
    }

    @Override
    public ApiResponse deleteTaskTagService(UUID id) {
        try {
            taskTagRepository.deleteById(id);
            return new ApiResponse("kategoriya öchirildi",true);
        }catch (Exception e){
            return new ApiResponse("Bunday ota kategoriya mavjud emas",false);
        }
    }

}
