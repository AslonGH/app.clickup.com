package uz.pdp.springbootprojectprocesses.serviceInterface;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Attachment;
import uz.pdp.springbootprojectprocesses.payload.Result;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface AttachmentService {


    Result uploadFile(MultipartHttpServletRequest request);

    List<Attachment> infoFiles();

    Attachment infoFileById(UUID id);

    Attachment downloadFileById(UUID id, HttpServletResponse response) throws IOException;

    Result deleteFile(UUID id);

}

