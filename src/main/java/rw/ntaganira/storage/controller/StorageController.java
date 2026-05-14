package rw.ntaganira.storage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rw.ntaganira.shared.response.ApiResponse;
import rw.ntaganira.storage.service.StorageService;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : StorageController.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Exposes storage upload endpoints
 * --------------------------------------------------------------------
 */

@RestController
@RequestMapping("/storage")
@RequiredArgsConstructor
public class StorageController {

    private final StorageService storageService;

    @PostMapping("/products")
    public ResponseEntity<ApiResponse<String>>
    uploadProductImage(
            @RequestParam("file")
            MultipartFile file
    ) {

        String imageUrl =
                storageService.uploadProductImage(file);

        return ResponseEntity.ok(
                ApiResponse.<String>builder()
                        .success(true)
                        .message("Product image uploaded")
                        .data(imageUrl)
                        .build()
        );
    }

}