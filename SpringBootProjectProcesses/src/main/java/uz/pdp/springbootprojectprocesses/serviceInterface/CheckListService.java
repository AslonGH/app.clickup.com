package uz.pdp.springbootprojectprocesses.serviceInterface;

import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.CheckListDto;

import java.util.UUID;

public interface CheckListService {

    ApiResponse addCheckList(CheckListDto checkListDto);

    ApiResponse editCheckList(CheckListDto checkListDto, UUID id);

    ApiResponse deleteCheckList(UUID id);
}
