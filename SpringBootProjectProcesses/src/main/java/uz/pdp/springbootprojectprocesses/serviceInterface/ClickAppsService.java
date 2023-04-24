package uz.pdp.springbootprojectprocesses.serviceInterface;

import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.ClickAppsDto;

import java.util.UUID;

public interface ClickAppsService {
    ApiResponse addClickApps(ClickAppsDto checkListDto);

    ApiResponse editClickApps(ClickAppsDto checkListDto, UUID id);

    ApiResponse deleteClickApps(UUID id);
}
