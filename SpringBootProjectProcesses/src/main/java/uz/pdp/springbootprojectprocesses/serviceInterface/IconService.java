package uz.pdp.springbootprojectprocesses.serviceInterface;

import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.IconDto;

import java.util.UUID;

public interface IconService {
    ApiResponse addIconService(IconDto iconDto);

    ApiResponse editIconService(IconDto iconDto, UUID uuid);

    ApiResponse deleteIconService(UUID id);
}
