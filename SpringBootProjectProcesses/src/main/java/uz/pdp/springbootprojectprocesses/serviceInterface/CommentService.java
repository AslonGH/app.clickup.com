package uz.pdp.springbootprojectprocesses.serviceInterface;

import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.CommentDto;

import java.util.UUID;

public interface CommentService {
    ApiResponse addComment(CommentDto commentDto);

    ApiResponse editComment(CommentDto commentDto, UUID uuid);

    ApiResponse deleteComment(UUID id);
}
