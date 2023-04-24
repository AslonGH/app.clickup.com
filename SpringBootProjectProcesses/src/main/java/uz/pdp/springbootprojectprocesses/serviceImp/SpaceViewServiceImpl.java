package uz.pdp.springbootprojectprocesses.serviceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.springbootprojectprocesses.entity.Les9.Space;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.entity.les10_2.SpaceUser;
import uz.pdp.springbootprojectprocesses.entity.les10_2.SpaceView;
import uz.pdp.springbootprojectprocesses.entity.les10_2.View;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.SpaceUserDto;
import uz.pdp.springbootprojectprocesses.payload.SpaceViewDto;
import uz.pdp.springbootprojectprocesses.repository.*;
import uz.pdp.springbootprojectprocesses.serviceInterface.SpaceViewService;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class SpaceViewServiceImpl implements SpaceViewService {

    @Autowired
    SpaceViewRepository spaceViewRepository;
    @Autowired
    SpaceRepository spaceRepository;
    @Autowired
    ViewRepository viewRepository;


    @Override
    public ApiResponse getSpaceViewsBySpaceId(UUID uuid) {
        List<SpaceView> all = spaceViewRepository.findAllBySpaceId(uuid);
        return new ApiResponse(" SpaceView",true, Collections.singletonList(all));
    }

    @Override
    public ApiResponse addSpaceView(SpaceViewDto spaceDto) {

         SpaceView spaceView=new SpaceView();
        spaceView.setSpace(spaceRepository.findById(spaceDto.getSpaceID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        spaceView.setView(viewRepository.findById(spaceDto.getViewID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        spaceViewRepository.save(spaceView);
        return new ApiResponse("saved",true);
    }

    @Override
    public ApiResponse editSpaceView(SpaceViewDto spaceDto, UUID id) {

        SpaceView spaceView = spaceViewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
      spaceView.setSpace(spaceRepository.findById(spaceDto.getSpaceID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
      spaceView.setView(viewRepository.findById(spaceDto.getViewID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
      spaceViewRepository.save(spaceView);
      return new ApiResponse("edited",true);
    }

    @Override
    public ApiResponse deleteSpaceView(UUID id) {
        try {
            spaceViewRepository.deleteById(id);
            return new ApiResponse("deleted",true);
        }catch (Exception e){
            return new ApiResponse("not deleted",false);
        }
    }
}
