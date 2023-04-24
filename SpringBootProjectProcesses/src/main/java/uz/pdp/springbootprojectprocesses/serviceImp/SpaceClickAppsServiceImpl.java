package uz.pdp.springbootprojectprocesses.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.entity.les10_2.ClickApps;
import uz.pdp.springbootprojectprocesses.entity.les10_2.SpaceClickApps;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.SpaceClickAppsDto;
import uz.pdp.springbootprojectprocesses.repository.ClickAppsRepository;
import uz.pdp.springbootprojectprocesses.repository.SpaceClickAppsRepository;
import uz.pdp.springbootprojectprocesses.repository.SpaceRepository;
import uz.pdp.springbootprojectprocesses.serviceInterface.SpaceClickAppsService;

import java.util.UUID;

@Service
public class SpaceClickAppsServiceImpl implements SpaceClickAppsService {

    @Autowired
    SpaceRepository spaceRepository;
    @Autowired
    ClickAppsRepository clickAppsRepository;
    @Autowired
    SpaceClickAppsRepository spaceClickAppsRepository;


    @Override
    public ApiResponse addSpaceClickApps(SpaceClickAppsDto clickAppsDto) {

         SpaceClickApps clickApps=new SpaceClickApps();
        clickApps.setSpace(spaceRepository.findById(clickAppsDto.getSpaceID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        clickApps.setClickApps(clickAppsRepository.findById(clickAppsDto.getClickAppsID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        spaceClickAppsRepository.save(clickApps);
        return new ApiResponse("saved",true);
    }

    @Override
    public ApiResponse editSpaceClickApps(SpaceClickAppsDto clickAppsDto, UUID id) {

         SpaceClickApps clickApps = spaceClickAppsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
        clickApps.setSpace(spaceRepository.findById(clickAppsDto.getSpaceID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        clickApps.setClickApps(clickAppsRepository.findById(clickAppsDto.getClickAppsID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        spaceClickAppsRepository.save(clickApps);
        return new ApiResponse("edited",true);
    }

    @Override
    public ApiResponse deleteSpaceClickApps(UUID id) {

        try {
            spaceClickAppsRepository.deleteById(id);
            return new ApiResponse("deleted",true);
        }catch (Exception e){
            return new ApiResponse("not deleted",false);
        }

    }

}
