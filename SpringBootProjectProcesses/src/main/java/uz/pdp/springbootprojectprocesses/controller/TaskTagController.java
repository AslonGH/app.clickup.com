package uz.pdp.springbootprojectprocesses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.TaskTagDto;
import uz.pdp.springbootprojectprocesses.security.CurrentUser;
import uz.pdp.springbootprojectprocesses.serviceInterface.TaskTagService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/taskTag")
public class TaskTagController {

    @Autowired
    TaskTagService taskTagService;
/*
  Status va tasklarni qo'shish, Task statusini o'zgartirish, Task ga file biriktirish, biriktirilgan file ni o'chirish,
  Task ga comment yoki tag qo'shish uni edit qilish va o'chirish, task ga user assign qilish va assign qilingan user_ni
  olib tashlash kabi amallarni bajaruvchi method larni yozing.
*/


    @PostMapping("/addTaskTag")
    public HttpEntity<?>addTaskTag(@Valid @RequestBody TaskTagDto taskTagDto){
      ApiResponse apiResponse=taskTagService.addTaskAttachmentService(taskTagDto);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }

    @PutMapping("/{id}")
    public HttpEntity<?>editTaskTag(@Valid @RequestBody TaskTagDto taskTagDto, UUID uuid){
      ApiResponse apiResponse=taskTagService.editTaskTagService(taskTagDto,uuid);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }


    @DeleteMapping("/{id}")
    public HttpEntity<?>deleteTaskTag( @PathVariable UUID id){
      ApiResponse apiResponse=taskTagService.deleteTaskTagService(id);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }


}
