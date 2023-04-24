package uz.pdp.springbootprojectprocesses.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.springbootprojectprocesses.entity.Les9.*;
import uz.pdp.springbootprojectprocesses.entity.enums.AddType;
import uz.pdp.springbootprojectprocesses.entity.enums.WorkSpacePermissionName;
import uz.pdp.springbootprojectprocesses.entity.enums.WorkSpaceRoleName;
import uz.pdp.springbootprojectprocesses.payload.*;
import uz.pdp.springbootprojectprocesses.repository.*;
import uz.pdp.springbootprojectprocesses.serviceInterface.WorkSpaceService;


import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class WorkSpaceServiceImpl implements WorkSpaceService {

     @Autowired
     WorkSpaceRepository workSpaceRepository;
     @Autowired
     AttachmentRepository attachmentRepository;
     @Autowired
     WorkspaceUserRepository workspaceUserRepository;
     @Autowired
     WorkSpaceRoleRepository workSpaceRoleRepository;
     @Autowired
     WorkSpacePermissionRepository workSpacePermissionRepository;
     @Autowired
     UserRepository userRepository;


      @Override
      public ApiResponse addWorSpace(WorkSpaceDto workSpaceDto, User ownerUser)  {

          // WORKSPACE OCHDIK
          // SYSTEMAGA KIRGAN USERDA BOSHQA BUNDAY NOMLI  WORKSPACE BO'LMASLIGI KERAK
          if (workSpaceRepository.existsByOwnerIdAndName(ownerUser.getId(), workSpaceDto.getName()))
          return new ApiResponse("Sizda bunday nomli ishxona mavjud",false);

           WorkSpace workSpace=new WorkSpace( workSpaceDto.getName(), workSpaceDto.getColor(), ownerUser,
          workSpaceDto.getAvatarId()==null?null:attachmentRepository.findById(workSpaceDto.getAvatarId()).
          orElseThrow( () -> new ResourceNotFoundException("Attachment")) );
          workSpaceRepository.save(workSpace);

          // WORK SPACE ROLE OCHDIK VA YUQORIDA SAQLANGAN workSpace NI HAM QOLLADIK
          WorkSpaceRole ownerRole = workSpaceRoleRepository.save(new WorkSpaceRole(workSpace, WorkSpaceRoleName.ROLE_OWNER.name(),  null));
          WorkSpaceRole adminRole = workSpaceRoleRepository.save(new WorkSpaceRole(workSpace, WorkSpaceRoleName.ROLE_ADMIN.name(),  null));
          WorkSpaceRole memberRole= workSpaceRoleRepository.save(new WorkSpaceRole(workSpace, WorkSpaceRoleName.ROLE_MEMBER.name(), null));
          WorkSpaceRole guestRole = workSpaceRoleRepository.save(new WorkSpaceRole(workSpace, WorkSpaceRoleName.ROLE_GUEST.name(),  null));

          // ENUMNING ICHIDAN AJRATIB OLAMIZ VA OWNERGA HUQUQLARNI BERYAPIZ
          WorkSpacePermissionName [] workSpacePermissionNames = WorkSpacePermissionName.values();

          List<WorkSpacePermission>workSpacePermissionList=new ArrayList<>();

          for (WorkSpacePermissionName workSpacePermissionName : workSpacePermissionNames)
          {
               // COMPANY YARATILGAN VAQTDA 4 TA STATIC ROLE LAR BOLADI : ownerRole, adminRole, memberRole, guestRole
               WorkSpacePermission workSpacePermission=new WorkSpacePermission(ownerRole, workSpacePermissionName);
              workSpacePermissionList.add(workSpacePermission);

               if (workSpacePermissionName.getWorkSpaceRoleNames().contains(WorkSpaceRoleName.ROLE_ADMIN)){
                   workSpacePermissionList.add(new WorkSpacePermission(adminRole, workSpacePermissionName));
               }
               if (workSpacePermissionName.getWorkSpaceRoleNames().contains(WorkSpaceRoleName.ROLE_MEMBER)){
                   workSpacePermissionList.add(new WorkSpacePermission(memberRole, workSpacePermissionName));
               }
               if (workSpacePermissionName.getWorkSpaceRoleNames().contains(WorkSpaceRoleName.ROLE_GUEST)){
                   workSpacePermissionList.add(new WorkSpacePermission(guestRole, workSpacePermissionName));
               }
          }
          // workSpacePermissionRepository  ga  4 ta WorkSpacePermission  larni  birdan saqladik
         workSpacePermissionRepository.saveAll(workSpacePermissionList);

          // WORKSPACE USER OCHDIK
        workspaceUserRepository.save(new WorkSpaceUser(workSpace, ownerUser, ownerRole,
        new Timestamp(System.currentTimeMillis()), new Timestamp( System.currentTimeMillis()) ));

        return new ApiResponse("WorkSpace saved",true);

     }


      // SZSTEMAGA KIRGAN USER OZINING WORKSPACE IGA YANGI ROLE QOSHADI
      @Override
      public ApiResponse addWorSpaceRole(Long workSpaceId, WorkSpaceRoleDto workSpaceRoleDto, User ownerUser) {

      Optional<WorkSpace> optionalWorkSpace = workSpaceRepository.findByOwnerId(ownerUser.getId());
      if (!optionalWorkSpace.isPresent())
      return new ApiResponse("Sizda bunday nomli ishxona mavjud emas",false);

      // BIZ YANGI OCHMOQCHI BO'LGAN WORKSPACEROLE VA PERMISSION  BASADA BOLMASLIGI KERAK.
      if (workSpaceRoleRepository.existsByWorkSpaceIdAndName(workSpaceId, workSpaceRoleDto.getName())){;
      return new ApiResponse("Error",false);}
      else {
      WorkSpaceRole workSpaceRole = workSpaceRoleRepository.save(
                 new WorkSpaceRole(optionalWorkSpace.get(), workSpaceRoleDto.getName(), workSpaceRoleDto.getExtendsRole()) );

      // ROLE_ADMIN, ROLE_MEMBER, ROLE_GUEST dan bittasini extend qilishi mumkin.
      // BIZ YANGI OCHGAN workSpaceRole GA PERMISSION BIRIKTIRAMIZ. YANI OZI EXTEND QILGAN ADMIN ROLININING PERMISSIONLARINI OLADI.
      List<WorkSpacePermission> workSpacePermissionList = workSpacePermissionRepository.findAllByWorkSpaceRole_NameAndWorkSpaceRole_WorkSpaceId(
                                                          workSpaceRoleDto.getExtendsRole().name(), workSpaceId);
      List<WorkSpacePermission> newWorkSpacePermissions=new ArrayList<>();

      for (WorkSpacePermission workSpacePermission : workSpacePermissionList) {
          WorkSpacePermission newWorkSpacePermission=new WorkSpacePermission(workSpaceRole, workSpacePermission.getPermissionName());
          newWorkSpacePermissions.add(newWorkSpacePermission);
      }
      workSpacePermissionRepository.saveAll(newWorkSpacePermissions);
      return new ApiResponse("Accepted",true);
      }
  }

      //WorkSpaceRole ga Permission qo'shish yoki olib tashlash
     @Override
     public ApiResponse addOrRemovePermissionToWorkSpaceRole(AddRemovePermissionDto dto) {

          Optional<WorkSpaceRole> optionalRole= workSpaceRoleRepository.findById(dto.getRoleId());
         if(!optionalRole.isPresent())
         return new ApiResponse("bunday nomli ishxona role yo'q",false);

         Optional<WorkSpacePermission> optionalWorkSpacePermission =
          workSpacePermissionRepository.findByWorkSpaceRoleIdAndPermissionName(dto.getRoleId(), dto.getPermissionName());

         if (dto.getAddType().equals(AddType.ADD)) {
             if (optionalWorkSpacePermission.isPresent()) return new ApiResponse("Allaqachon qoshilgan",false);

            WorkSpacePermission workSpacePermission=new WorkSpacePermission(optionalRole.get(), dto.getPermissionName());
          workSpacePermissionRepository.save(workSpacePermission);
          return new ApiResponse("WorkSpacePermission muvaffaqiyatli qo'shildi",true);
         }
         else if (dto.getAddType().equals(AddType.REMOVE)) {
             if (optionalWorkSpacePermission.isPresent()){
                 workSpacePermissionRepository.delete(optionalWorkSpacePermission.get());
                 return new ApiResponse("Muvaffaqiyatli ochirildi",true);
             }
               return new ApiResponse("Bunday WorkSpacePermission yoq ",false);
         }
         return new ApiResponse("Bunday buyruq yoq ",false);
     }

      // WorkSpace ni  Add, Edit,  Remove   qilish
     @Override
     public ApiResponse addOrEditRemoveWorkSpace(Long id, MemberDto memberDto) {

              if (memberDto.getAddType().equals(AddType.ADD)) {
             WorkSpaceUser workSpaceUser=new WorkSpaceUser(
            workSpaceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id "+id)),
            userRepository.findById(memberDto.getId()).orElseThrow(() -> new ResourceNotFoundException("id "+ memberDto.getId())),
            workSpaceRoleRepository.findById(memberDto.getRoleId()).orElseThrow(() -> new ResourceNotFoundException("id "+memberDto.getRoleId())),
            new Timestamp(System.currentTimeMillis()),  null);
            workspaceUserRepository.save(workSpaceUser);
            // TODO EMAILGA INVITE XABAR YUBORISH
        }
        else if (memberDto.getAddType().equals(AddType.EDIT))  {

            WorkSpaceUser workSpaceUser=
                    workspaceUserRepository.findByWorkSpaceIdAndUserId(id, memberDto.getId()).orElseGet(WorkSpaceUser::new); // AKS HOLDA SHU USER NI O'ZINI SAQLAYMIZ
            workSpaceUser.setWorkSpaceRole( workSpaceRoleRepository.findById(memberDto.getRoleId()).orElseThrow(() -> new ResourceNotFoundException("id")));
            workspaceUserRepository.save(workSpaceUser);
        }
        else if (memberDto.getAddType().equals(AddType.REMOVE)) {
            workspaceUserRepository.deleteByWorkSpaceIdAndUserId(id, memberDto.getId());
        }

        return new ApiResponse("Muvaffaqiyatli bajarildi",true);
    }

     @Override
     public ApiResponse editWorSpace(WorkSpaceDto workSpaceDto) {

         WorkSpace workSpace = workSpaceRepository.findById(workSpaceDto.getId()).orElseThrow(
                                                            () -> new ResourceNotFoundException("not found"));
         workSpace.setName(workSpaceDto.getName());
         workSpace.setColor(workSpaceDto.getColor());
         workSpace.setAvatar(workSpaceDto.getAvatarId()==null?null:attachmentRepository.findById(workSpaceDto.getAvatarId()).
                                                  orElseThrow( () -> new ResourceNotFoundException("Attachment")));
         workSpaceRepository.save(workSpace);
         return new ApiResponse("WorkSpace edited",true);

     }

     @Override
     public ApiResponse changeOwnerWorkSpace(Long id, UUID ownerId) {

         Optional<WorkSpace> workSpaceOptional = workSpaceRepository.findById(id);
         if (!workSpaceOptional.isPresent())
             return new ApiResponse("Sizda id li ishxona mavjud emas",false);

         Optional<WorkSpaceUser> optionalUser = workspaceUserRepository.findById(ownerId);
         if (!optionalUser.isPresent()) return new ApiResponse("User mavjud emas",false);

          WorkSpace workSpace = workSpaceOptional.get();
         workSpace.setOwner(optionalUser.get().getUser());
         workSpaceRepository.save(workSpace);
         return new ApiResponse("WorkSpace saved",true);
     }

     @Override
     public ApiResponse deleteWorkSpace(Long id) {

          try {
          workSpaceRepository.deleteById(id);
          return new ApiResponse("Ochirildi",true);
     }catch (Exception e){
               return new ApiResponse("Ochirilmadi Xatolik",false);
          }
     }

     // WorkSpace ga User qo'shish
     @Override
     public ApiResponse joinToWorkSpace(Long id, User user) {
         Optional<WorkSpaceUser> optionalWorkSpaceUser = workspaceUserRepository.findByWorkSpaceIdAndUserId(id, user.getId());
         if (optionalWorkSpaceUser.isPresent()){
             WorkSpaceUser workSpaceUser = optionalWorkSpaceUser.get();
             workSpaceUser.setDateJoined(new Timestamp(System.currentTimeMillis()));
             workspaceUserRepository.save(workSpaceUser);
             return new ApiResponse("Success",true);
         }
        return new ApiResponse("Error", false);
     }


     @Override
     public List<MemberDto> getMemberAndGuestWorkSpaces(Long id) {
     /*
         List<WorkSpaceRoleName> names=new ArrayList<>(Arrays.asList(WorkSpaceRoleName.ROLE_GUEST,WorkSpaceRoleName.ROLE_MEMBER));
         List<WorkSpaceUser> list = workspaceUserRepository.findAllByWorkSpaceIdAndWorkSpaceRoleRoleNameIn(id,names);
         return new ApiResponse("List",true, Collections.singletonList(list));
     */

     List<WorkSpaceUser> workSpaceUsers = workspaceUserRepository.findAllByWorkSpaceId(id);

       /* List<MemberDto>members=new ArrayList<>();
           for (WorkSpaceUser workSpaceUser : workSpaceUsers) {
             MemberDto memberDto = mapWorkSpaceUserToMemberDto(workSpaceUser);
             members.add(memberDto);
         }*/

     // IKKINCHI USUL: FOR O'RNIDA "LAMDA". YA'NI -stream ga solib map b-n aylanamiz, va bizga workSpaceUser qataradi va
     // uni mapWorkSpaceUserToMemberDto ga beramiz . Bu bizga MemberDtolarni ni qataradi.Biz ularni List ga Collect qilamiz.
     List<MemberDto> memberDtoList = workSpaceUsers.stream().map(workSpaceUser -> mapWorkSpaceUserToMemberDto(workSpaceUser))
                                     .collect(Collectors.toList());

     // KEYINGI USUL - METHOD REFERENZ USULI : this - workSpaceUser, ni  mapWorkSpaceUserToMemberDto METHODGA BERADI
     return workSpaceUsers.stream().map(this::mapWorkSpaceUserToMemberDto).collect(Collectors.toList());
   }

     @Override
     public List<WorkSpaceDto> getMyWorkSpaces(User user) {

        List<WorkSpaceUser> workSpaceUsers = workspaceUserRepository.findAllByUserId(user.getId());
        return workSpaceUsers.stream().map(workSpaceUser ->
                mapWorkSpaceUserToWorkSpaceDto(workSpaceUser.getWorkSpace())).collect(Collectors.toList());
    }


     public WorkSpaceDto mapWorkSpaceUserToWorkSpaceDto(WorkSpace workSpace){

     WorkSpaceDto workSpaceDto=new WorkSpaceDto();
     workSpaceDto.setId(workSpace.getId());
     workSpaceDto.setInitialLetter(workSpace.getInitialLetter());
     workSpaceDto.setName(workSpace.getName());
     // AVATARNING ID SI NULL BOLSA NULLPOINTERGA TUSHADI SHU SABAB - null?null  ni qo'lladik
     workSpaceDto.setAvatarId(workSpace.getAvatar()==null?null:workSpace.getAvatar().getId());
     workSpaceDto.setColor(workSpace.getColor());
     return workSpaceDto;
     }

     // MemberDto KERAKLI JOYGA SHU METHODNI CHAQRAMIZ.
     public MemberDto mapWorkSpaceUserToMemberDto(WorkSpaceUser workSpaceUser){
          MemberDto memberDto=new MemberDto();
        memberDto.setId(workSpaceUser.getUser().getId());
        memberDto.setFullName(workSpaceUser.getUser().getFullName());
        memberDto.setEmail(workSpaceUser.getUser().getEmail());
        memberDto.setRoleName(workSpaceUser.getWorkSpaceRole().getName());
        memberDto.setLastActive(workSpaceUser.getUser().getLastActiveTime());
        return memberDto;
    }

}
