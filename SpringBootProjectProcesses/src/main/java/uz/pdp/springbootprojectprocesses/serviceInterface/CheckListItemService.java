package uz.pdp.springbootprojectprocesses.serviceInterface;

import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.CheckList_ItemDto;

import java.util.UUID;

public interface CheckListItemService {
    ApiResponse addCheckListItem(CheckList_ItemDto checkListItemDto);

    ApiResponse deleteCheckListItem(UUID id);
}
