package uz.pdp.springbootprojectprocesses.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.entity.les10_2.SpaceView;
import uz.pdp.springbootprojectprocesses.entity.les10_2.View;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.ViewDto;
import uz.pdp.springbootprojectprocesses.repository.IconRepository;
import uz.pdp.springbootprojectprocesses.repository.ViewRepository;
import uz.pdp.springbootprojectprocesses.serviceInterface.ViewService;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
@Service
public class ViewServiceImp implements ViewService {

    @Autowired
    ViewRepository viewRepository;
    @Autowired
    IconRepository iconRepository;

    @Override
    public ApiResponse getViews() {
        List<View> all = viewRepository.findAll();
        return new ApiResponse(" View",true, Collections.singletonList(all));
    }

    @Override
    public ApiResponse addView(ViewDto viewDto, User user) {

          View view=new View();
        view.setName(viewDto.getName());
        view.setIcon(iconRepository.findById(viewDto.getIconID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        viewRepository.save(view);
        return new ApiResponse("saved",true);
    }

    @Override
    public ApiResponse editView(ViewDto viewDto, UUID id, User user) {

         View view = viewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
        view.setName(viewDto.getName());
        view.setIcon(iconRepository.findById(viewDto.getIconID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        viewRepository.save(view);
        return new ApiResponse("edited",true);
    }

    @Override
    public ApiResponse deleteView(UUID id) {
        try {
            viewRepository.deleteById(id);
            return new ApiResponse("deleted",true);
        }catch (Exception e){
            return new ApiResponse("not deleted",false);
        }
    }
}
