package uz.pdp.springbootprojectprocesses.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.SpaceUserDto;
import uz.pdp.springbootprojectprocesses.payload.SpaceViewDto;
import uz.pdp.springbootprojectprocesses.security.CurrentUser;
import uz.pdp.springbootprojectprocesses.serviceInterface.SpaceUserService;
import uz.pdp.springbootprojectprocesses.serviceInterface.SpaceViewService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/spaceView")
public class SpaceViewController {

    @Autowired
    SpaceViewService spaceViewService;

   /*
   Space va Folder larni CRUD qilish, Folderga user qo'shish yoki edit qilish va Folder dan user ni o'chirish kabi
   amallarni bajaruvchi method larni yozing.
   */


    // space bo'yicha viewlarn olish
    @GetMapping("/{id}")
    public HttpEntity<?>getSpaceViewsBySpaceId(@PathVariable UUID id){
        ApiResponse apiResponse=spaceViewService.getSpaceViewsBySpaceId(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }


    // SYSTEMAGA KIRGAN USER OZIGA  WORKSPACE OCHAYAPTI
    @PostMapping("/addSpaceView")
    public HttpEntity<?>addSpaceView(@RequestBody SpaceViewDto spaceDto){
      ApiResponse apiResponse=spaceViewService.addSpaceView(spaceDto);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }

    @PutMapping("/{id}")
    public HttpEntity<?>editSpaceView(@RequestBody SpaceViewDto spaceDto, @PathVariable UUID id){
      ApiResponse apiResponse=spaceViewService.editSpaceView( spaceDto, id);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }


    @DeleteMapping("/{id}")
    public HttpEntity<?>deleteSpaceView(@PathVariable UUID id){
      ApiResponse apiResponse=spaceViewService.deleteSpaceView(id);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }

}
