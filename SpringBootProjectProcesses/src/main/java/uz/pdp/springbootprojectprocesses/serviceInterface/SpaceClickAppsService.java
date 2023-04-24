package uz.pdp.springbootprojectprocesses.serviceInterface;

import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.SpaceClickAppsDto;

import java.util.UUID;

public interface SpaceClickAppsService {
    ApiResponse addSpaceClickApps(SpaceClickAppsDto clickAppsDto);

    ApiResponse editSpaceClickApps(SpaceClickAppsDto clickAppsDto, UUID id);

    ApiResponse deleteSpaceClickApps(UUID id);
}
