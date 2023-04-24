package uz.pdp.springbootprojectprocesses.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Icon;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.IconDto;
import uz.pdp.springbootprojectprocesses.repository.AttachmentRepository;
import uz.pdp.springbootprojectprocesses.repository.IconRepository;
import uz.pdp.springbootprojectprocesses.serviceInterface.IconService;

import java.util.UUID;

@Service
public class IconServiceImpl implements IconService {

    @Autowired
    IconRepository iconRepository;
    @Autowired
    AttachmentRepository attachmentRepository;

    @Override
    public ApiResponse addIconService(IconDto iconDto) {

         Icon icon=new Icon();
        icon.setIcon(iconRepository.findById(iconDto.getIconID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        icon.setAttachment(attachmentRepository.findById(iconDto.getAttachmentID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        icon.setColor(iconDto.getColor());
        icon.setInitialLetter(iconDto.getInitialLetter());
        iconRepository.save(icon);
        return new ApiResponse("saved",true);
    }

    @Override
    public ApiResponse editIconService(IconDto iconDto, UUID uuid) {

         Icon icon = iconRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("not found"));
        icon.setIcon(iconRepository.findById(iconDto.getIconID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        icon.setAttachment(attachmentRepository.findById(iconDto.getAttachmentID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        icon.setColor(iconDto.getColor());
        icon.setInitialLetter(iconDto.getInitialLetter());
        iconRepository.save(icon);
        return new ApiResponse("edited",true);
    }

    @Override
    public ApiResponse deleteIconService(UUID id) {
        try {
              iconRepository.deleteById(id);
            return new ApiResponse("deleted",true);
        }catch (Exception e){
            return new ApiResponse("not deleted",false);
        }
    }


}
