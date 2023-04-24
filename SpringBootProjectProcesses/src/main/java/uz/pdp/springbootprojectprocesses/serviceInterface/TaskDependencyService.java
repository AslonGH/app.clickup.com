package uz.pdp.springbootprojectprocesses.serviceInterface;

import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.TaskDependencyDto;

import java.util.UUID;

public interface TaskDependencyService {
    ApiResponse addTaskDependency(TaskDependencyDto dependencyDto);

    ApiResponse editTaskDependency(TaskDependencyDto dependencyDto, UUID uuid);

    ApiResponse deleteTaskDependency(UUID id);
}
