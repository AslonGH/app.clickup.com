package uz.pdp.springbootprojectprocesses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.TagDto;
import uz.pdp.springbootprojectprocesses.payload.TaskTagDto;
import uz.pdp.springbootprojectprocesses.security.CurrentUser;
import uz.pdp.springbootprojectprocesses.serviceInterface.TagService;
import uz.pdp.springbootprojectprocesses.serviceInterface.TaskTagService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/tag")
public class TagController {

    @Autowired
    TagService tagService;
/*
  Status va tasklarni qo'shish, Task statusini o'zgartirish, Task ga file biriktirish, biriktirilgan file ni o'chirish,
  Task ga comment yoki tag qo'shish uni edit qilish va o'chirish, task ga user assign qilish va assign qilingan user_ni
  olib tashlash kabi amallarni bajaruvchi method larni yozing.
*/


    @PostMapping("/addTag")
    public HttpEntity<?>addTag(@Valid @RequestBody TagDto tagDto){
      ApiResponse apiResponse=tagService.addTagService(tagDto);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }

    @PutMapping("/{id}")
    public HttpEntity<?>editTag(@Valid @RequestBody TagDto tagDto, UUID uuid){
      ApiResponse apiResponse=tagService.editTagService(tagDto, uuid);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }


    @DeleteMapping("/{id}")
    public HttpEntity<?>deleteTag( @PathVariable UUID id){
      ApiResponse apiResponse=tagService.deleteTagService(id);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }


}
