package uz.pdp.springbootprojectprocesses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.CheckListDto;
import uz.pdp.springbootprojectprocesses.security.CurrentUser;
import uz.pdp.springbootprojectprocesses.serviceInterface.CheckListService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/checkList")
public class CheckListController {

    @Autowired
    CheckListService checkListService;

//  Checklist qo'shish, edit qilish, delete qilish, checklist ga item qo'shish, qo'shilgan item ni delete qilish,
//  checklistga assign qilish va space bo'yicha viewlarn olish kabi amallarni bajaruvchi method larni yozing.


    @PostMapping("/addCheckList")
    public HttpEntity<?>addCheckList(@Valid @RequestBody CheckListDto checkListDto){
      ApiResponse apiResponse=checkListService.addCheckList( checkListDto);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }

    @PutMapping("/editCheckList/{id}")
    public HttpEntity<?>editCheckList(@Valid @RequestBody CheckListDto checkListDto,@PathVariable UUID id){
      ApiResponse apiResponse=checkListService.editCheckList( checkListDto, id);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }


    @DeleteMapping("/{id}")
    public HttpEntity<?>deleteCheckList(@PathVariable UUID id){
      ApiResponse apiResponse=checkListService.deleteCheckList(id);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }


}
