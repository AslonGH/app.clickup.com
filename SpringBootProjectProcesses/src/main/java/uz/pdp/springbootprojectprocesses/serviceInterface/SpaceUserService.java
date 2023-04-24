package uz.pdp.springbootprojectprocesses.serviceInterface;

import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.SpaceDto;
import uz.pdp.springbootprojectprocesses.payload.SpaceUserDto;

import java.util.UUID;

public interface SpaceUserService {

    ApiResponse getSpaceUsers();

    ApiResponse addSpaceUser(SpaceUserDto spaceDto);

    ApiResponse editSpaceUser(SpaceUserDto spaceDto, UUID id);

    ApiResponse deleteSpaceUser(UUID id);

}
