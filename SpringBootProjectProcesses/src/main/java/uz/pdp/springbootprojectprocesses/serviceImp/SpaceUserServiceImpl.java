package uz.pdp.springbootprojectprocesses.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.springbootprojectprocesses.entity.Les9.Space;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.entity.les10_2.SpaceUser;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.SpaceDto;
import uz.pdp.springbootprojectprocesses.payload.SpaceUserDto;
import uz.pdp.springbootprojectprocesses.repository.SpaceRepository;
import uz.pdp.springbootprojectprocesses.repository.SpaceUserRepository;
import uz.pdp.springbootprojectprocesses.repository.UserRepository;
import uz.pdp.springbootprojectprocesses.serviceInterface.SpaceUserService;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class SpaceUserServiceImpl implements SpaceUserService {

    @Autowired
    SpaceUserRepository spaceUserRepository;
    @Autowired
    SpaceRepository spaceRepository;
    @Autowired
    UserRepository userRepository;



    @Override
    public ApiResponse getSpaceUsers() {
         List<SpaceUser> all = spaceUserRepository.findAll();
        return new ApiResponse(" SpaceUser",true, Collections.singletonList(all));
    }

    @Override
    public ApiResponse addSpaceUser(SpaceUserDto spaceDto) {

        SpaceUser spaceUser=new SpaceUser();
      spaceUser.setSpace(spaceRepository.findById(spaceDto.getSpaceID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
      spaceUser.setMember(userRepository.findById(spaceDto.getMemberID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
      spaceUserRepository.save(spaceUser);
      return new ApiResponse("saved",true);
    }

    @Override
    public ApiResponse editSpaceUser(SpaceUserDto spaceDto, UUID id) {

       SpaceUser spaceUser = spaceUserRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
      spaceUser.setSpace(spaceRepository.findById(spaceDto.getSpaceID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
      spaceUser.setMember(userRepository.findById(spaceDto.getMemberID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
      spaceUserRepository.save(spaceUser);
      return new ApiResponse("edited",true);
    }

    @Override
    public ApiResponse deleteSpaceUser(UUID id) {
        try {
            spaceUserRepository.deleteById(id);
            return new ApiResponse("deleted",true);
        }catch (Exception e){
            return new ApiResponse("not deleted",false);
        }
    }


}
