package uz.pdp.springbootprojectprocesses.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootprojectprocesses.payload.*;
import uz.pdp.springbootprojectprocesses.serviceInterface.ProjectService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/folder")
public class FolderController {

    @Autowired
    ProjectService projectService;
    /*
     Space va Folder larni CRUD qilish, Folderga user qo'shish yoki edit qilish va Folder dan user ni o'chirish kabi
     amallarni bajaruvchi method larni yozing.
   */


    // SYSTEMAGA KIRGAN USER  OCHAYAPTI
    @PostMapping("/addFolder")
    public HttpEntity<?>addFolder(@Valid @RequestBody ProjectDto projectDto){
      ApiResponse apiResponse=projectService.addFolder( projectDto);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }


    @PutMapping("/{id}")
    public HttpEntity<?>editFolder(@RequestBody ProjectDto projectDto, @PathVariable UUID id){
      ApiResponse apiResponse=projectService.editFolder( projectDto, id);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }


    @DeleteMapping("/{id}")
    public HttpEntity<?>deleteFolder(@PathVariable UUID id){
      ApiResponse apiResponse=projectService.deleteFolder(id);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }


    @GetMapping
    public HttpEntity<?>getFolders(){
        ApiResponse apiResponse=projectService.getFolders();
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }


    @PostMapping("/addOrEditRemoveProjectUser/{id}")
    public HttpEntity<?>addOrEditRemoveProjectUser(@PathVariable UUID id, @RequestBody ProjectUserAddEditRemDto projectUserDto){
        ApiResponse apiResponse=projectService.addOrEditRemoveProjectUser( id, projectUserDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

}
