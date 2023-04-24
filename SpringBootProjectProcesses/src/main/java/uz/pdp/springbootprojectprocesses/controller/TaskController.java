package uz.pdp.springbootprojectprocesses.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.*;
import uz.pdp.springbootprojectprocesses.security.CurrentUser;
import uz.pdp.springbootprojectprocesses.serviceInterface.TaskService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/task")
public class TaskController {

  @Autowired
  TaskService taskService;
  /*
  Status va tasklarni qo'shish, Task statusini o'zgartirish, Task ga file biriktirish, biriktirilgan file ni o'chirish,
  Task ga comment yoki tag qo'shish uni edit qilish va o'chirish, task ga user assign qilish va assign qilingan user_ni
  olib tashlash kabi amallarni bajaruvchi method larni yozing.
  */

    

    @PostMapping("/addTask")
    public HttpEntity<?>addTask(@Valid @RequestBody TaskDto taskDto){
      ApiResponse apiResponse=taskService.addTask( taskDto);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }




}
