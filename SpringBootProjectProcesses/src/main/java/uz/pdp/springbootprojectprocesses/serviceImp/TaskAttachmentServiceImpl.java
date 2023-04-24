package uz.pdp.springbootprojectprocesses.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.springbootprojectprocesses.entity.les10_1.TaskAttachment;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.TaskAttachmentDto;
import uz.pdp.springbootprojectprocesses.repository.AttachmentRepository;
import uz.pdp.springbootprojectprocesses.repository.TaskAttachmentRepository;
import uz.pdp.springbootprojectprocesses.repository.TaskRepository;
import uz.pdp.springbootprojectprocesses.serviceInterface.TaskAttachmentService;

import java.util.UUID;

@Service
public class TaskAttachmentServiceImpl implements TaskAttachmentService {

    @Autowired
    TaskAttachmentRepository taskAttachmentRepository;
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    TaskRepository taskRepository;


    @Override
    public ApiResponse addTaskAttachmentService(TaskAttachmentDto taskAttachmentDto) {

       TaskAttachment taskAttachment=new TaskAttachment();
     taskAttachment.setAttachment(attachmentRepository.findById(taskAttachmentDto.getAttachmentID()).orElseThrow(() -> new ResourceNotFoundException("Not Found")));
     taskAttachment.setTask(taskRepository.findById(taskAttachmentDto.getTaskID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
     taskAttachment.setPinCoverImage(taskAttachmentDto.getPinCoverImage());
     taskAttachmentRepository.save(taskAttachment);
     return new ApiResponse("saved",true);
    }

    @Override
    public ApiResponse deleteTaskAttachmentService(UUID id) {
       try {
           taskAttachmentRepository.deleteById(id);
           return new ApiResponse("deleted",true);
       }catch (Exception e){
           return new ApiResponse("not deleted",false);
       }
    }

    @Override
    public ApiResponse editTaskAttachmentService(TaskAttachmentDto taskAttachmentDto) {

         TaskAttachment taskAttachment = taskAttachmentRepository.findById(taskAttachmentDto.getAttachmentID()).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        taskAttachment.setAttachment(attachmentRepository.findById(taskAttachmentDto.getAttachmentID()).orElseThrow(() -> new ResourceNotFoundException("Not Found")));
        taskAttachment.setTask(taskRepository.findById(taskAttachmentDto.getTaskID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        taskAttachment.setPinCoverImage(taskAttachmentDto.getPinCoverImage());
        taskAttachmentRepository.save(taskAttachment);
        return new ApiResponse("saved",true);
    }

}
