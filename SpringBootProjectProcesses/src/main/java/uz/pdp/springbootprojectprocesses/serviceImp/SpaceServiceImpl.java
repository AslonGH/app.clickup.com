package uz.pdp.springbootprojectprocesses.serviceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.springbootprojectprocesses.entity.Les9.Space;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.*;
import uz.pdp.springbootprojectprocesses.repository.*;
import uz.pdp.springbootprojectprocesses.serviceInterface.SpaceService;

import java.util.*;

@Service
public class SpaceServiceImpl implements SpaceService {

     @Autowired
     WorkSpaceRepository workSpaceRepository;
     @Autowired
     AttachmentRepository attachmentRepository;
     @Autowired
     SpaceRepository spaceRepository;
     @Autowired
     IconRepository iconRepository;


    @Override
    public ApiResponse addSpace(SpaceDto spaceDto, User user) {

         Space space =new Space();
        space.setName(spaceDto.getName());
        space.setWorkSpace(workSpaceRepository.findById(spaceDto.getWorkSpaceId()).orElseThrow(() -> new ResourceNotFoundException(spaceDto.getWorkSpaceId()+ " not found ")));
        space.setColor(spaceDto.getColor());
        space.setAccessType(spaceDto.getAccessType());
        space.setIcon(iconRepository.findById(spaceDto.getIconId()).orElseThrow(() -> new ResourceNotFoundException(spaceDto.getWorkSpaceId()+ " not found ")));
        space.setAvatar(attachmentRepository.findById(spaceDto.getAvatarId()).orElseThrow(() -> new ResourceNotFoundException(spaceDto.getWorkSpaceId()+ " not found ")));
        space.setInitialLetter(spaceDto.getInitialLetter());
        space.setOwner(user);
        spaceRepository.save(space);
        return new ApiResponse("Project saved",true);
    }

    @Override
    public ApiResponse editWorSpace(SpaceDto spaceDto, UUID id, User user) {

         Space space = spaceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " not found "));
        space.setName(spaceDto.getName());
        space.setWorkSpace(workSpaceRepository.findById(spaceDto.getWorkSpaceId()).orElseThrow(() -> new ResourceNotFoundException(spaceDto.getWorkSpaceId()+ " not found ")));
        space.setColor(spaceDto.getColor());
        space.setAccessType(spaceDto.getAccessType());
        space.setIcon(iconRepository.findById(spaceDto.getIconId()).orElseThrow(() -> new ResourceNotFoundException(spaceDto.getWorkSpaceId()+ " not found ")));
        space.setAvatar(attachmentRepository.findById(spaceDto.getAvatarId()).orElseThrow(() -> new ResourceNotFoundException(spaceDto.getWorkSpaceId()+ " not found ")));
        space.setInitialLetter(spaceDto.getInitialLetter());
        space.setOwner(user);
        spaceRepository.save(space);
        return new ApiResponse("Project edited",true);
    }

    @Override
    public ApiResponse deleteSpace(UUID id) {

        try {
            spaceRepository.deleteById(id);
            return new ApiResponse("deleted",true);
        }
        catch (Exception e){
            return new ApiResponse("not deleted",false);
        }
    }

    @Override
    public ApiResponse getSpaces() {
        List<Space> all = spaceRepository.findAll();
        return new ApiResponse("List of spaces",true, Collections.singletonList(all));
    }


    /* @Override
    public ApiResponse changeOwnerSpace(Long id, UUID ownerId) {
        return null;
    }
    @Override
    public ApiResponse joinToWorkSpace(UUID id, User user) {
        return null;
    }*/
}
