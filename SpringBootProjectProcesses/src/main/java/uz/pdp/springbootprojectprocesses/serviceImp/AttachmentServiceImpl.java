package uz.pdp.springbootprojectprocesses.serviceImp;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Attachment;
import uz.pdp.springbootprojectprocesses.entity.les10_1.AttachmentContent;
import uz.pdp.springbootprojectprocesses.payload.Result;
import uz.pdp.springbootprojectprocesses.repository.AttachmentContentRepository;
import uz.pdp.springbootprojectprocesses.repository.AttachmentRepository;
import uz.pdp.springbootprojectprocesses.serviceInterface.AttachmentService;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    AttachmentRepository attachmentRepository;

    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    @SneakyThrows  // Try Catch ning bir turi

    // CREATE
    public Result uploadFile(MultipartHttpServletRequest request){

         Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());

         Attachment attachment=new Attachment();
        attachment.setName(file != null ? file.getName() : null);
        attachment.setOriginalName(Objects.requireNonNull(file).getOriginalFilename());
        attachment.setSize(file.getSize());
        attachment.setContentType(file.getContentType());
         Attachment savedAttachment = attachmentRepository.save(attachment);

         AttachmentContent attachmentContent=new AttachmentContent();
        attachmentContent.setBytes(file.getBytes());
        attachmentContent.setAttachment(savedAttachment);
        attachmentContent.setName(file.getName());
        attachmentContentRepository.save(attachmentContent);
        return new Result("Fayl saqlandi",true, savedAttachment.getId());
    }

    @Override
    public Attachment downloadFileById(UUID id, HttpServletResponse response) throws IOException {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()) {
            Attachment attachment = optionalAttachment.get();
            Optional<AttachmentContent> contentOptional = attachmentContentRepository.findByAttachmentId(id);
            if (contentOptional.isPresent()) {
                AttachmentContent attachmentContent = contentOptional.get();
                response.setHeader("Content-Disposition", "attachment; filename=\"" + attachment.getName()+ "\"");
                response.setContentType(attachment.getContentType());
                FileCopyUtils.copy(attachmentContent.getBytes(), response.getOutputStream());
            }
        }
        return new Attachment();
    }



    public List<Attachment> infoFiles() {
        return attachmentRepository.findAll();
    }
    @Override
    public Attachment infoFileById(UUID id) {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        return optionalAttachment.orElseGet(Attachment::new);
    }
    @Override
    public Result deleteFile(UUID id) {
        try {
            attachmentRepository.deleteById(id);
            return new Result("File deleted",true);
        }catch (Exception e){
            return new Result("File not deleted",false);
        }
    }

}
