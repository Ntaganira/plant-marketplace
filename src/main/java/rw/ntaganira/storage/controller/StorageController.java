package rw.ntaganira.storage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rw.ntaganira.shared.response.ApiResponse;
import rw.ntaganira.storage.dto.FileUploadResponse;
import rw.ntaganira.storage.service.StorageService;
import rw.ntaganira.storage.validator.FileValidator;

/**
 * --------------------------------------------------------------------
 * Project : Rwanda Plant Marketplace
 * File : StorageController.java
 * Author : Heritier Ntaganira
 * Company : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description : Exposes storage upload endpoints
 * --------------------------------------------------------------------
 */

@RestController
@RequestMapping("/storage")
@RequiredArgsConstructor
public class StorageController {

        private final StorageService storageService;

        private final FileValidator fileValidator;

        @PostMapping("/products")
        public ResponseEntity<ApiResponse<String>> uploadProductImage(
                        @RequestParam("file") MultipartFile file) {

                String imageUrl = storageService.uploadProductImage(file);

                return ResponseEntity.ok(
                                ApiResponse.<String>builder()
                                                .success(true)
                                                .message("Product image uploaded")
                                                .data(imageUrl)
                                                .build());
        }

        @PostMapping("/products/upload")
        public ResponseEntity<ApiResponse<FileUploadResponse>> uploadProduct(
                        @RequestParam("file") MultipartFile file) {

                fileValidator.validateImage(file);

                FileUploadResponse response = storageService.upload(
                                file,
                                "products");

                return ResponseEntity.ok(
                                ApiResponse.<FileUploadResponse>builder()
                                                .success(true)
                                                .message("File uploaded successfully")
                                                .data(response)
                                                .build());
        }
}