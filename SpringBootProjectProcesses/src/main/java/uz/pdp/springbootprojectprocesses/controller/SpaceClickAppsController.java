package uz.pdp.springbootprojectprocesses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.ClickAppsDto;
import uz.pdp.springbootprojectprocesses.payload.SpaceClickAppsDto;
import uz.pdp.springbootprojectprocesses.security.CurrentUser;
import uz.pdp.springbootprojectprocesses.serviceInterface.ClickAppsService;
import uz.pdp.springbootprojectprocesses.serviceInterface.SpaceClickAppsService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/spaceClickApps")
public class SpaceClickAppsController {

    @Autowired
    SpaceClickAppsService clickAppsService;

    //  Checklist qo'shish, edit qilish, delete qilish, checklist ga item qo'shish, qo'shilgan item ni delete qilish,
    //  checklistga assign qilish va space bo'yicha viewlarn olish kabi amallarni bajaruvchi method larni yozing.


    @PostMapping("/addSpaceClickApps")
    public HttpEntity<?>addSpaceClickApps(@Valid @RequestBody SpaceClickAppsDto clickAppsDto){
      ApiResponse apiResponse=clickAppsService.addSpaceClickApps( clickAppsDto);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }


    @PutMapping("/editSpaceClickApps/{id}")
    public HttpEntity<?>editSpaceClickApps(@Valid @RequestBody SpaceClickAppsDto clickAppsDto,@PathVariable UUID id,  @CurrentUser User user){
      ApiResponse apiResponse=clickAppsService.editSpaceClickApps( clickAppsDto, id);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }


    @DeleteMapping("/{id}")
    public HttpEntity<?>deleteSpaceClickApps(@PathVariable UUID id){
      ApiResponse apiResponse=clickAppsService.deleteSpaceClickApps(id);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }




}
