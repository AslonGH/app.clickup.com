package uz.pdp.springbootprojectprocesses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Attachment;
import uz.pdp.springbootprojectprocesses.payload.Result;
import uz.pdp.springbootprojectprocesses.serviceInterface.AttachmentService;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {
    // BEAN ICHIDAGI IKKITA CLASSNI @Autowired QILIB CHAQIRSA BÖLADI
    @Autowired
    AttachmentService attachmentService;


    @PostMapping("/upload")
    public Result upload(MultipartHttpServletRequest request){
        Result result = attachmentService.uploadFile(request);
        return result;
    }

    @GetMapping("/infos")
    public List<Attachment> fileInfo(){
        List<Attachment> attachments = attachmentService.infoFiles();
        return attachments;
    }

    @GetMapping("/info/{id}")
    public Attachment infoFileById(@PathVariable UUID id) {
        Attachment attachment = attachmentService.infoFileById(id);
        return attachment;
    }


     @GetMapping("/download/{id}")
    public Attachment downloadFileById(@PathVariable UUID id, HttpServletResponse response) throws IOException {
        Attachment attachment = attachmentService.downloadFileById(id,response);
        return attachment;
    }


    @PutMapping("/delete/{id}")
    public Result delete(UUID id){
        Result result = attachmentService.deleteFile(id);
        return result;
    }


}
