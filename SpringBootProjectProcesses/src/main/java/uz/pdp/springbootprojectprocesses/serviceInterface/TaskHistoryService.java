package uz.pdp.springbootprojectprocesses.serviceInterface;

import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.TaskHistoryDto;

import java.util.UUID;

public interface TaskHistoryService {
    ApiResponse addTaskHistory(TaskHistoryDto taskHistoryDto);

    ApiResponse editTaskHistory(TaskHistoryDto taskHistoryDto, UUID uuid);

    ApiResponse deleteTaskHistory(UUID id);
}
