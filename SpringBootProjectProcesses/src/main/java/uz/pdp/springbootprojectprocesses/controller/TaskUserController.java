package uz.pdp.springbootprojectprocesses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.TaskUserDto;
import uz.pdp.springbootprojectprocesses.security.CurrentUser;
import uz.pdp.springbootprojectprocesses.serviceInterface.TaskUserService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/taskUser")
public class TaskUserController {

    @Autowired
    TaskUserService taskUserService;
/*
  Status va tasklarni qo'shish, Task statusini o'zgartirish, Task ga file biriktirish, biriktirilgan file ni o'chirish,
  Task ga comment yoki tag qo'shish uni edit qilish va o'chirish, task ga user assign qilish  va assign qilingan user_ni
  olib tashlash kabi amallarni bajaruvchi method larni yozing.
*/


    @PostMapping("/addTaskUser")
    public HttpEntity<?>addTaskUser(@Valid @RequestBody TaskUserDto taskUserDto ){
      ApiResponse apiResponse=taskUserService.addTaskUserService(taskUserDto);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }

    @DeleteMapping("/{id}")
    public HttpEntity<?>deleteTaskUser(@PathVariable UUID id){
      ApiResponse apiResponse=taskUserService.deleteTaskUserService(id);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }


}
