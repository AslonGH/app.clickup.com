package uz.pdp.springbootprojectprocesses.serviceInterface;

import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.TagDto;

import java.util.UUID;

public interface TagService {
    ApiResponse addTagService(TagDto tagDto);

    ApiResponse editTagService(TagDto tagDto, UUID uuid);

    ApiResponse deleteTagService(UUID id);
}
