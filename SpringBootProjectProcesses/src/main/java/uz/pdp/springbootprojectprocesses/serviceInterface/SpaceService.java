package uz.pdp.springbootprojectprocesses.serviceInterface;


import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.SpaceDto;

import java.util.UUID;

public interface SpaceService {

    ApiResponse addSpace(SpaceDto spaceDto, User user);
    ApiResponse editWorSpace(SpaceDto spaceDto, UUID id, User user);
    ApiResponse deleteSpace(UUID id);
    ApiResponse getSpaces();

//    ApiResponse changeOwnerSpace(Long id, UUID ownerId);
//    ApiResponse joinToWorkSpace(UUID id, User user);
}
