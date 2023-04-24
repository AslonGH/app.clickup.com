package uz.pdp.springbootprojectprocesses.serviceInterface;

import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.TaskAttachmentDto;

import java.util.UUID;

public interface TaskAttachmentService {
    ApiResponse addTaskAttachmentService(TaskAttachmentDto taskAttachmentDto);

    ApiResponse deleteTaskAttachmentService(UUID id);

    ApiResponse editTaskAttachmentService(TaskAttachmentDto taskAttachmentDto);
}
