package uz.pdp.springbootprojectprocesses.serviceInterface;

import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.SpaceUserDto;
import uz.pdp.springbootprojectprocesses.payload.SpaceViewDto;

import java.util.UUID;

public interface SpaceViewService {

    ApiResponse getSpaceViewsBySpaceId(UUID uuid);

    ApiResponse addSpaceView(SpaceViewDto spaceDto);

    ApiResponse editSpaceView(SpaceViewDto spaceDto, UUID id);

    ApiResponse deleteSpaceView(UUID id);
}
