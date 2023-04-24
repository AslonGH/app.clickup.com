package uz.pdp.springbootprojectprocesses.serviceInterface;

import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.TaskUserDto;

import java.util.UUID;

public interface TaskUserService {

    ApiResponse addTaskUserService(TaskUserDto taskUserDto);

    ApiResponse deleteTaskUserService(UUID id);
}
