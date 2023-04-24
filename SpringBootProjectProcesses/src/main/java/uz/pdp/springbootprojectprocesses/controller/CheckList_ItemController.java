package uz.pdp.springbootprojectprocesses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.CheckList_ItemDto;
import uz.pdp.springbootprojectprocesses.security.CurrentUser;
import uz.pdp.springbootprojectprocesses.serviceInterface.CheckListItemService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/checkListItem")
public class CheckList_ItemController {

    @Autowired
    CheckListItemService checkListItemService;

//  Checklist qo'shish, edit qilish, delete qilish, checklist ga item qo'shish, qo'shilgan item ni delete qilish,
//  checklistga assign qilish va space bo'yicha viewlarn olish kabi amallarni bajaruvchi method larni yozing.


    @PostMapping("/addCheckListItem")
    public HttpEntity<?>addCheckListItem(@Valid @RequestBody CheckList_ItemDto checkListItemDto){
      ApiResponse apiResponse=checkListItemService.addCheckListItem( checkListItemDto);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }


    @DeleteMapping("/{id}")
    public HttpEntity<?>deleteCheckList(@PathVariable UUID id){
      ApiResponse apiResponse=checkListItemService.deleteCheckListItem(id );
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }

}
