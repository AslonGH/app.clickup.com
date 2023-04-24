package uz.pdp.springbootprojectprocesses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.StatusDto;
import uz.pdp.springbootprojectprocesses.security.CurrentUser;
import uz.pdp.springbootprojectprocesses.serviceInterface.StatusService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    @Autowired
    StatusService statusService;
/*
  Status va tasklarni qo'shish, Task statusini o'zgartirish, Task ga file biriktirish, biriktirilgan file ni o'chirish,
  Task ga comment yoki tag qo'shish uni edit qilish va o'chirish, task ga user assign qilish va assign qilingan user_ni
  olib tashlash kabi amallarni bajaruvchi method larni yozing.
*/



    @PostMapping("/addStatus")
    public HttpEntity<?>addStatus(@Valid @RequestBody StatusDto statusDto){
      ApiResponse apiResponse=statusService.addStatus( statusDto);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }


    @PutMapping("/{id}")
    public HttpEntity<?>editStatus(@Valid @RequestBody StatusDto statusDto, @PathVariable UUID id){
      ApiResponse apiResponse=statusService.editStatus( statusDto, id);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }




}
