package rw.ntaganira.storage.validator;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import rw.ntaganira.shared.exception.BadRequestException;

import java.util.List;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : FileValidator.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Validates uploaded files
 * --------------------------------------------------------------------
 */

@Component
public class FileValidator {

    private static final List<String>
            ALLOWED_CONTENT_TYPES = List.of(
            "image/jpeg",
            "image/png",
            "image/webp"
    );

    private static final long MAX_FILE_SIZE =
            5 * 1024 * 1024;

    public void validateImage(
            MultipartFile file
    ) {

        if (file.isEmpty()) {

            throw new BadRequestException(
                    "File cannot be empty"
            );
        }

        if (!ALLOWED_CONTENT_TYPES.contains(
                file.getContentType()
        )) {

            throw new BadRequestException(
                    "Invalid image format"
            );
        }

        if (file.getSize() > MAX_FILE_SIZE) {

            throw new BadRequestException(
                    "File size exceeds 5MB"
            );
        }
    }

}