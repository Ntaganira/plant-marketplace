package rw.ntaganira.products.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rw.ntaganira.categories.entity.Category;
import rw.ntaganira.categories.repository.CategoryRepository;
import rw.ntaganira.products.dto.ProductRequest;
import rw.ntaganira.products.dto.ProductResponse;
import rw.ntaganira.products.entity.Product;
import rw.ntaganira.products.repository.ProductRepository;
import rw.ntaganira.products.service.ProductService;
import rw.ntaganira.shared.exception.ResourceNotFoundException;

import java.util.List;
import java.util.UUID;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : ProductServiceImpl.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Implements product business operations
 * --------------------------------------------------------------------
 */

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    @Override
    public ProductResponse createProduct(ProductRequest request) {

        Category category = categoryRepository
                .findById(request.getCategoryId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Category not found"
                        ));

        Product product = new Product();

        product.setName(request.getName());

        product.setSlug(
                request.getName()
                        .toLowerCase()
                        .replace(" ", "-")
                        + "-" +
                        UUID.randomUUID()
                                .toString()
                                .substring(0, 5)
        );

        product.setDescription(request.getDescription());

        product.setShortDescription(
                request.getShortDescription()
        );

        product.setPrice(request.getPrice());

        product.setDiscountPrice(
                request.getDiscountPrice()
        );

        product.setStockQuantity(
                request.getStockQuantity()
        );

        product.setCategory(category);

        Product savedProduct =
                productRepository.save(product);

        return mapToResponse(savedProduct);
    }

    @Override
    public List<ProductResponse> getAllProducts() {

        return productRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public ProductResponse getProductBySlug(String slug) {

        Product product = productRepository
                .findBySlug(slug)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product not found"
                        ));

        return mapToResponse(product);
    }

    @Override
    public List<ProductResponse> searchProducts(
            String keyword
    ) {

        return productRepository
                .findByNameContainingIgnoreCase(keyword)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private ProductResponse mapToResponse(
            Product product
    ) {

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .slug(product.getSlug())
                .description(product.getDescription())
                .shortDescription(
                        product.getShortDescription()
                )
                .price(product.getPrice())
                .discountPrice(
                        product.getDiscountPrice()
                )
                .stockQuantity(
                        product.getStockQuantity()
                )
                .thumbnailUrl(
                        product.getThumbnailUrl()
                )
                .category(
                        product.getCategory() != null
                                ? product.getCategory().getName()
                                : null
                )
                .vendor(
                        product.getVendor() != null
                                ? product.getVendor().getFirstName()
                                : null
                )
                .build();
    }

}