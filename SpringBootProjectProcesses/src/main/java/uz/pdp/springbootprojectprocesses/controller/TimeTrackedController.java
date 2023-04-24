package uz.pdp.springbootprojectprocesses.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.TimeTrackedDto;
import uz.pdp.springbootprojectprocesses.security.CurrentUser;
import uz.pdp.springbootprojectprocesses.serviceInterface.TimeTrackedService;

import java.util.UUID;

@RestController
@RequestMapping("/api/timeTracked")
public class TimeTrackedController {

    @Autowired
    TimeTrackedService timeTrackedService;

   /*
   Space va Folder larni CRUD qilish, Folderga user qo'shish yoki edit qilish va Folder dan user ni o'chirish kabi
   amallarni bajaruvchi method larni yozing.
   */


    @GetMapping
    public HttpEntity<?>getTimeTracked(){
        ApiResponse apiResponse=timeTrackedService.getTimeTracked();
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    // SYSTEMAGA KIRGAN USER OZIGA  WORKSPACE OCHAYAPTI
    @PostMapping("/addTimeTracked")
    public HttpEntity<?>addTimeTracked(@RequestBody TimeTrackedDto dto, @CurrentUser User user){
      ApiResponse apiResponse=timeTrackedService.addTimeTracked(dto, user);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }

    @PutMapping("/{id}")
    public HttpEntity<?>editTimeTracked(@RequestBody TimeTrackedDto dto, @PathVariable UUID id, @CurrentUser User user){
      ApiResponse apiResponse=timeTrackedService.editTimeTracked( dto, id, user);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }

    @DeleteMapping("/{id}")
    public HttpEntity<?>deleteTimeTracked(@PathVariable UUID id){
      ApiResponse apiResponse=timeTrackedService.deleteTimeTracked(id);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }

}
