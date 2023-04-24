package uz.pdp.springbootprojectprocesses.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.entity.les10_2.CheckList;
import uz.pdp.springbootprojectprocesses.entity.les10_2.CheckList_Item;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.CheckListDto;
import uz.pdp.springbootprojectprocesses.payload.CheckList_ItemDto;
import uz.pdp.springbootprojectprocesses.repository.CheckListRepository;
import uz.pdp.springbootprojectprocesses.repository.CheckList_ItemRepository;
import uz.pdp.springbootprojectprocesses.repository.TaskUserRepository;
import uz.pdp.springbootprojectprocesses.repository.UserRepository;
import uz.pdp.springbootprojectprocesses.serviceInterface.CheckListItemService;

import java.util.UUID;

@Service
public class CheckList_ItemServiceImpl implements CheckListItemService {

    @Autowired
    CheckListRepository checkListRepository;
    @Autowired
    CheckList_ItemRepository checkList_itemRepository;


    @Autowired
    UserRepository userRepository;

    @Override
    public ApiResponse addCheckListItem(CheckList_ItemDto checkListItemDto) {

      CheckList_Item checkList_item=new CheckList_Item();
     checkList_item.setName(checkListItemDto.getName());
     checkList_item.setCheckList(checkListRepository.findById(checkListItemDto.getCheckListID()).orElseThrow(
             () ->new ResourceNotFoundException("not found")));
     checkList_item.setAssignedUser(userRepository.findById(checkListItemDto.getAssignedUserID()).orElseThrow(
             () ->new ResourceNotFoundException("not found")));
     checkList_item.setResolved(checkListItemDto.isResolved());
     checkList_itemRepository.save(checkList_item);
     return new ApiResponse("saved",true);
    }

    @Override
    public ApiResponse deleteCheckListItem(UUID id) {
        try {
            checkList_itemRepository.deleteById(id);
            return new ApiResponse("deleted",true);
        }catch (Exception e){
            return new ApiResponse("not deleted",false);
        }
    }

}
