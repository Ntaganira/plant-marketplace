package rw.ntaganira.storage.service.impl;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import rw.ntaganira.storage.config.MinioProperties;
import rw.ntaganira.storage.service.StorageService;

import java.util.UUID;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : StorageServiceImpl.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Implements MinIO object storage operations
 * --------------------------------------------------------------------
 */

@Service
@RequiredArgsConstructor
public class StorageServiceImpl implements StorageService {

    private final MinioClient minioClient;

    private final MinioProperties properties;

    @PostConstruct
    public void initializeBuckets() {

        createBucket(properties.getBucketProducts());

        createBucket(properties.getBucketVendors());

        createBucket(properties.getBucketProfiles());

        createBucket(properties.getBucketBanners());
    }

    @Override
    public String uploadProductImage(
            MultipartFile file
    ) {

        return uploadFile(
                file,
                properties.getBucketProducts()
        );
    }

    @Override
    public String uploadVendorLogo(
            MultipartFile file
    ) {

        return uploadFile(
                file,
                properties.getBucketVendors()
        );
    }

    @Override
    public String uploadProfilePhoto(
            MultipartFile file
    ) {

        return uploadFile(
                file,
                properties.getBucketProfiles()
        );
    }

    private String uploadFile(
            MultipartFile file,
            String bucket
    ) {

        try {

            String fileName =
                    UUID.randomUUID() +
                            "-" +
                            file.getOriginalFilename();

            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucket)
                            .object(fileName)
                            .stream(
                                    file.getInputStream(),
                                    file.getSize(),
                                    -1
                            )
                            .contentType(file.getContentType())
                            .build()
            );

            return properties.getUrl()
                    + "/"
                    + bucket
                    + "/"
                    + fileName;

        } catch (Exception ex) {

            throw new RuntimeException(
                    "Failed to upload file",
                    ex
            );
        }
    }

    private void createBucket(
            String bucketName
    ) {

        try {

            boolean exists = minioClient.bucketExists(
                    BucketExistsArgs.builder()
                            .bucket(bucketName)
                            .build()
            );

            if (!exists) {

                minioClient.makeBucket(
                        MakeBucketArgs.builder()
                                .bucket(bucketName)
                                .build()
                );
            }

        } catch (Exception ex) {

            throw new RuntimeException(
                    "Failed to create bucket",
                    ex
            );
        }
    }

}