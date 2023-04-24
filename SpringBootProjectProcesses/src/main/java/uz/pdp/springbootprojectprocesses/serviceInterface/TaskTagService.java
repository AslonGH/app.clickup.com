package uz.pdp.springbootprojectprocesses.serviceInterface;

import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.TaskTagDto;

import java.util.UUID;

public interface TaskTagService {
    ApiResponse addTaskAttachmentService(TaskTagDto taskTagDto);

    ApiResponse editTaskTagService(TaskTagDto taskTagDto, UUID uuid);

    ApiResponse deleteTaskTagService(UUID id);
}
