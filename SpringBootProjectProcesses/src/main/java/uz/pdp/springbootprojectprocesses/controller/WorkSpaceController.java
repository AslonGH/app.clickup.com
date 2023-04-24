package uz.pdp.springbootprojectprocesses.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.*;
import uz.pdp.springbootprojectprocesses.security.CurrentUser;
import uz.pdp.springbootprojectprocesses.serviceInterface.WorkSpaceService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/workspace")
public class WorkSpaceController {

    @Autowired
    WorkSpaceService workSpaceService;
/*
   Workspace edit qilish, ownerini o'zgartish, member va mehmonlarini ko'rish,  Workspacelari ro'yxatini olish, Workspace ga
   role qo'shish   va  Workspace rolelarini  permisison berish yoki olib tashlash   kabi amallarni bajaruvchi method larni yozing.

*/


    // SYSTEMAGA KIRGAN USER OZIGA  WORKSPACE OCHAYAPTI
    @PostMapping("/addWorkSpace")
    public HttpEntity<?>addWorkSpace(@Valid @RequestBody WorkSpaceDto workSpaceDto, @CurrentUser User user){
      ApiResponse apiResponse=workSpaceService.addWorSpace( workSpaceDto, user);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }


     @PostMapping("/addWorkSpaceRole")
     public HttpEntity<?>addWorkSpaceRole(@RequestParam Long workSpaceId,
                                          @RequestBody  WorkSpaceRoleDto workSpaceRoleDto,
                                          @CurrentUser  User user) {
       ApiResponse apiResponse=workSpaceService.addWorSpaceRole(workSpaceId, workSpaceRoleDto, user);
       return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }


    /**
     * NAME, COLOR, AVATAR O'ZGARAISHI MUMKIN
     *
     * @param workSpaceDto
     * @return
     */
    @PutMapping
    public HttpEntity<?>editWorkSpace(@RequestBody WorkSpaceDto workSpaceDto) {
      ApiResponse apiResponse=workSpaceService.editWorSpace(workSpaceDto);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }


    /**
     * NAME,COLOR, AVATAR O'ZGARTIRISH MUMKIN
     * @param id
     * @param ownerId
     * @return
    */
    @PutMapping("/changeOwnerId/{id}")
    public HttpEntity<?>changeOwnerWorkSpace(@PathVariable Long id, @RequestParam UUID ownerId) {
      ApiResponse apiResponse=workSpaceService.changeOwnerWorkSpace(id, ownerId);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }


    /**
     * ISHXONANI O'CHIRISH
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public HttpEntity<?>deleteWorkSpace(@PathVariable Long id) {
      ApiResponse apiResponse=workSpaceService.deleteWorkSpace(id);
      return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }


    @PostMapping("/addOrEditRemove/{id}")
    public HttpEntity<?>addOrEditRemoveWorkSpace(@PathVariable Long id, @RequestBody MemberDto memberDto) {
        ApiResponse apiResponse=workSpaceService.addOrEditRemoveWorkSpace( id, memberDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }


    @PostMapping("/addOrRemovePermissionToWorkSpaceRole/{id}")
    public HttpEntity<?>addOrRemovePermissionToWorkSpaceRole(@RequestBody AddRemovePermissionDto dto) {
        ApiResponse apiResponse=workSpaceService.addOrRemovePermissionToWorkSpaceRole(dto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }


    /**
     * ISHXONANI O'ZGARTIRISH
     *
     * @param id
     * @return
     */
    @PutMapping("/join")
    public HttpEntity<?>joinToWorkSpace(@RequestParam Long id, @CurrentUser User user) {
        ApiResponse apiResponse=workSpaceService.joinToWorkSpace( id, user);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }


     // member va mehmonlarini ko'rish.
    @GetMapping("/member/{id}")
    public HttpEntity<?>getMemberAndGuestWorkSpace(@PathVariable Long id) {
        // ApiResponse apiResponse=workSpaceService.getMemberAndGuestWorkSpaces(id);
        // return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
        List<MemberDto> members=workSpaceService.getMemberAndGuestWorkSpaces(id);
        return ResponseEntity.ok(members);
    }


    // SYSTEMAGA KIRGAN USERNING AZO BOLGAN HAMMA WORKSPACELAR:
    @GetMapping
    public HttpEntity<?> getMyWorkSpaces(@CurrentUser User user) {
       List<WorkSpaceDto>workSpaces=workSpaceService.getMyWorkSpaces(user);
       return ResponseEntity.ok(workSpaces);
    }


}
