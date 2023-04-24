package uz.pdp.springbootprojectprocesses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Priority;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.IconDto;
import uz.pdp.springbootprojectprocesses.payload.PriorityDto;
import uz.pdp.springbootprojectprocesses.security.CurrentUser;
import uz.pdp.springbootprojectprocesses.serviceInterface.IconService;
import uz.pdp.springbootprojectprocesses.serviceInterface.PriorityService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/priority")
public class PriorityController {

    @Autowired
    PriorityService priorityService;
/*
  Status va tasklarni qo'shish, Task statusini o'zgartirish, Task ga file biriktirish, biriktirilgan file ni o'chirish,
  Task ga comment yoki tag qo'shish uni edit qilish va o'chirish, task ga user assign qilish va assign qilingan user_ni
  olib tashlash kabi amallarni bajaruvchi method larni yozing.
*/


    @PostMapping("/addPriority")
    public HttpEntity<?>addPriority(@Valid @RequestBody PriorityDto priorityDto){
      ApiResponse apiResponse=priorityService.addPriorityService(priorityDto);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }

    @PutMapping("/{id}")
    public HttpEntity<?>editPriority(@Valid @RequestBody PriorityDto priorityDto, UUID uuid){
      ApiResponse apiResponse=priorityService.editPriorityService(priorityDto,uuid);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }


    @DeleteMapping("/delete/{id}")
    public HttpEntity<?>deletePriority( @PathVariable UUID id){
      ApiResponse apiResponse=priorityService.deletePriorityService(id);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }


}
