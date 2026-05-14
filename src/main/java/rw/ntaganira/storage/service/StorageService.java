package rw.ntaganira.storage.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : StorageService.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Handles object storage operations
 * --------------------------------------------------------------------
 */

public interface StorageService {

    String uploadProductImage(
            MultipartFile file
    );

    String uploadVendorLogo(
            MultipartFile file
    );

    String uploadProfilePhoto(
            MultipartFile file
    );

}