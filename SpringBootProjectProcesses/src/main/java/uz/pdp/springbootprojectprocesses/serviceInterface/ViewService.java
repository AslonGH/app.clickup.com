package uz.pdp.springbootprojectprocesses.serviceInterface;

import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.ViewDto;

import java.util.UUID;

public interface ViewService {
    ApiResponse getViews();

    ApiResponse addView(ViewDto viewDto, User user);

    ApiResponse editView(ViewDto viewDto, UUID id, User user);

    ApiResponse deleteView(UUID id);
}
