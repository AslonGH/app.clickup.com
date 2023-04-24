package uz.pdp.springbootprojectprocesses.serviceInterface;

import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.TimeTrackedDto;

import java.util.UUID;

public interface TimeTrackedService {
    ApiResponse addTimeTracked(TimeTrackedDto dto, User user);

    ApiResponse editTimeTracked(TimeTrackedDto dto, UUID id, User user);

    ApiResponse deleteTimeTracked(UUID id);

    ApiResponse getTimeTracked();

}
