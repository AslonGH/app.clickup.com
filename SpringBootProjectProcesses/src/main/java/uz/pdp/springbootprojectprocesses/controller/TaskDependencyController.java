package uz.pdp.springbootprojectprocesses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.TaskDependencyDto;
import uz.pdp.springbootprojectprocesses.payload.TaskTagDto;
import uz.pdp.springbootprojectprocesses.security.CurrentUser;
import uz.pdp.springbootprojectprocesses.serviceInterface.TaskDependencyService;
import uz.pdp.springbootprojectprocesses.serviceInterface.TaskTagService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/taskDependency")
public class TaskDependencyController {

    @Autowired
    TaskDependencyService taskDependencyService;
/*
  Status va tasklarni qo'shish, Task statusini o'zgartirish, Task ga file biriktirish, biriktirilgan file ni o'chirish,
  Task ga comment yoki tag qo'shish uni edit qilish va o'chirish, task ga user assign qilish va assign qilingan user_ni
  olib tashlash kabi amallarni bajaruvchi method larni yozing.
*/


    @PostMapping("/addTaskDependency")
    public HttpEntity<?>addTaskDependency(@Valid @RequestBody TaskDependencyDto dependencyDto){
      ApiResponse apiResponse=taskDependencyService.addTaskDependency(dependencyDto);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }

    @PutMapping("/{id}")
    public HttpEntity<?>editTaskDependency(@Valid @RequestBody TaskDependencyDto dependencyDto, UUID uuid){
      ApiResponse apiResponse=taskDependencyService.editTaskDependency(dependencyDto,uuid);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }


    @DeleteMapping("/{id}")
    public HttpEntity<?>deleteTaskDependency( @PathVariable UUID id){
      ApiResponse apiResponse=taskDependencyService.deleteTaskDependency(id);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }


}
