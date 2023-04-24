package uz.pdp.springbootprojectprocesses.serviceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Tag;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.TagDto;
import uz.pdp.springbootprojectprocesses.repository.TagRepository;
import uz.pdp.springbootprojectprocesses.repository.WorkSpaceRepository;
import uz.pdp.springbootprojectprocesses.serviceInterface.TagService;

import java.util.UUID;

@Service
public class TagServiceImpl  implements TagService {

    @Autowired
    WorkSpaceRepository workSpaceRepository;
    @Autowired
    TagRepository tagRepository;


    @Override
    public ApiResponse addTagService(TagDto tagDto) {

         Tag tag=new Tag();
        tag.setName(tagDto.getName());
        tag.setColor(tagDto.getColor());
        tag.setWorkSpace(workSpaceRepository.findById(tagDto.getWorkSpaceID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        tagRepository.save(tag);
        return new ApiResponse("saved",true);
    }

    @Override
    public ApiResponse editTagService(TagDto tagDto, UUID uuid) {

          Tag tag = tagRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("not found"));
        tag.setName(tagDto.getName());
        tag.setColor(tagDto.getColor());
        tag.setWorkSpace(workSpaceRepository.findById(tagDto.getWorkSpaceID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        tagRepository.save(tag);
        return new ApiResponse("edited",true);
    }

    @Override
    public ApiResponse deleteTagService(UUID id) {
        try {
            tagRepository.deleteById(id);
            return new ApiResponse("deleted",true);
        }catch (Exception e){
            return new ApiResponse("not deleted",false);
        }
    }

}
