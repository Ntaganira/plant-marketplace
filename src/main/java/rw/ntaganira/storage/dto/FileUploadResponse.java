package rw.ntaganira.storage.dto;

import lombok.Builder;
import lombok.Data;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : FileUploadResponse.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Represents uploaded file response
 * --------------------------------------------------------------------
 */

@Data
@Builder
public class FileUploadResponse {

    private String fileName;

    private String fileUrl;

    private String contentType;

    private Long size;

}