package uz.pdp.springbootprojectprocesses.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Comment;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.CommentDto;
import uz.pdp.springbootprojectprocesses.repository.CommentRepository;
import uz.pdp.springbootprojectprocesses.repository.TaskRepository;
import uz.pdp.springbootprojectprocesses.serviceInterface.CommentService;

import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    CommentRepository commentRepository;


    @Override
    public ApiResponse addComment(CommentDto commentDto) {

         Comment comment=new Comment();
        comment.setName(commentDto.getName());
        comment.setTask(taskRepository.findById(commentDto.getTaskId()).orElseThrow(() -> new ResourceNotFoundException(commentDto.getTaskId()+"not found")));
        commentRepository.save(comment);
        return new ApiResponse("saved",true);
    }

    @Override
    public ApiResponse editComment(CommentDto commentDto, UUID uuid) {

         Comment comment = commentRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("not found"));
        comment.setName(commentDto.getName());
        comment.setTask(taskRepository.findById(commentDto.getTaskId()).orElseThrow(() -> new ResourceNotFoundException(commentDto.getTaskId()+"not found")));
        commentRepository.save(comment);
        return new ApiResponse("saved",true);
    }

    @Override
    public ApiResponse deleteComment(UUID id) {
        try {
          commentRepository.deleteById(id);
            return new ApiResponse("deleted",true);
        }catch (Exception e){
            return new ApiResponse("not deleted",false);
        }
    }
}
