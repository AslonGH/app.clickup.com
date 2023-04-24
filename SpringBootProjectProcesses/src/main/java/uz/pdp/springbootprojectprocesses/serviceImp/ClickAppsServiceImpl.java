package uz.pdp.springbootprojectprocesses.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.entity.les10_2.ClickApps;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.ClickAppsDto;
import uz.pdp.springbootprojectprocesses.repository.ClickAppsRepository;
import uz.pdp.springbootprojectprocesses.repository.IconRepository;
import uz.pdp.springbootprojectprocesses.serviceInterface.ClickAppsService;

import java.util.UUID;

@Service
public class ClickAppsServiceImpl implements ClickAppsService {

    @Autowired
    IconRepository iconRepository;
    @Autowired
    ClickAppsRepository clickAppsRepository;



    @Override
    public ApiResponse addClickApps(ClickAppsDto clickAppsDto) {
          ClickApps clickApps=new ClickApps();
        clickApps.setName(clickAppsDto.getName());
        clickApps.setIcon(iconRepository.findById(clickAppsDto.getIconID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        clickAppsRepository.save(clickApps);
        return new ApiResponse("saved",true);
    }

    @Override
    public ApiResponse editClickApps(ClickAppsDto clickAppsDto, UUID id) {
          ClickApps clickApps = clickAppsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
        clickApps.setName(clickAppsDto.getName());
        clickApps.setIcon(iconRepository.findById(clickAppsDto.getIconID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        clickAppsRepository.save(clickApps);
        return new ApiResponse("edited",true);
    }

    @Override
    public ApiResponse deleteClickApps(UUID id) {
        try {
            clickAppsRepository.deleteById(id);
            return new ApiResponse("deleted",true);
        }catch (Exception e){
            return new ApiResponse("not deleted",false);
        }
    }


}
