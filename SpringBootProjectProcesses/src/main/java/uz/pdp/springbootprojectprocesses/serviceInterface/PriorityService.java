package uz.pdp.springbootprojectprocesses.serviceInterface;

import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.PriorityDto;

import java.util.UUID;

public interface PriorityService {
    ApiResponse addPriorityService(PriorityDto priorityDto );

    ApiResponse editPriorityService(PriorityDto priorityDto, UUID uuid);

    ApiResponse deletePriorityService(UUID id);
}
