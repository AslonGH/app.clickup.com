package uz.pdp.springbootprojectprocesses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.TaskAttachmentDto;
import uz.pdp.springbootprojectprocesses.security.CurrentUser;
import uz.pdp.springbootprojectprocesses.serviceInterface.TaskAttachmentService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/taskAttachment")
public class TaskAttachmentController {

    @Autowired
    TaskAttachmentService taskAttachmentService;
/*
  Status va tasklarni qo'shish, Task statusini o'zgartirish, Task ga file biriktirish, biriktirilgan file ni o'chirish,
  Task ga comment yoki tag qo'shish uni edit qilish va o'chirish, task ga user assign qilish va assign qilingan user_ni
  olib tashlash kabi amallarni bajaruvchi method larni yozing.
*/


    @PostMapping("/addTaskAttachment")
    public HttpEntity<?>addTaskAttachment(@Valid @RequestBody TaskAttachmentDto taskAttachmentDto){
      ApiResponse apiResponse=taskAttachmentService.addTaskAttachmentService(taskAttachmentDto);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }

    @PutMapping("/editTaskAttachment")
    public HttpEntity<?>editTaskAttachment(@Valid @RequestBody TaskAttachmentDto taskAttachmentDto){
      ApiResponse apiResponse=taskAttachmentService.editTaskAttachmentService(taskAttachmentDto);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }


    @DeleteMapping("/{id}")
    public HttpEntity<?>deleteTaskAttachment(@PathVariable UUID id){
      ApiResponse apiResponse=taskAttachmentService.deleteTaskAttachmentService(id);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }


}
