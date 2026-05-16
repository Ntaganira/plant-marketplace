package rw.ntaganira.products.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rw.ntaganira.categories.entity.Category;
import rw.ntaganira.categories.repository.CategoryRepository;
import rw.ntaganira.products.dto.ProductFilterRequest;
import rw.ntaganira.products.dto.ProductRequest;
import rw.ntaganira.products.dto.ProductResponse;
import rw.ntaganira.products.entity.Product;
import rw.ntaganira.products.repository.ProductRepository;
import rw.ntaganira.products.service.ProductService;
import rw.ntaganira.shared.exception.BadRequestException;
import rw.ntaganira.shared.exception.ResourceNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import rw.ntaganira.products.dto.VendorProductRequest;
import rw.ntaganira.users.entity.User;
import rw.ntaganira.users.repository.UserRepository;

import java.util.List;
import java.util.UUID;

/**
 * --------------------------------------------------------------------
 * Project : Rwanda Plant Marketplace
 * File : ProductServiceImpl.java
 * Author : Heritier Ntaganira
 * Company : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description : Implements product business operations
 * --------------------------------------------------------------------
 */

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

        private final ProductRepository productRepository;

        private final CategoryRepository categoryRepository;

        private final UserRepository userRepository;

        @Override
        public ProductResponse createProduct(ProductRequest request) {

                Category category = categoryRepository
                                .findById(request.getCategoryId())
                                .orElseThrow(() -> new ResourceNotFoundException(
                                                "Category not found"));

                Product product = new Product();

                product.setName(request.getName());

                product.setThumbnailUrl(
                                request.getThumbnailUrl());

                product.setSlug(
                                request.getName()
                                                .toLowerCase()
                                                .replace(" ", "-")
                                                + "-" +
                                                UUID.randomUUID()
                                                                .toString()
                                                                .substring(0, 5));

                product.setDescription(request.getDescription());

                product.setShortDescription(
                                request.getShortDescription());

                product.setPrice(request.getPrice());

                product.setDiscountPrice(
                                request.getDiscountPrice());

                product.setStockQuantity(
                                request.getStockQuantity());

                product.setCategory(category);

                Product savedProduct = productRepository.save(product);

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
                                .orElseThrow(() -> new ResourceNotFoundException(
                                                "Product not found"));

                return mapToResponse(product);
        }

        @Override
        public List<ProductResponse> searchProducts(
                        String keyword) {

                return productRepository
                                .findByNameContainingIgnoreCase(keyword)
                                .stream()
                                .map(this::mapToResponse)
                                .toList();
        }

        @Override
        public List<ProductResponse> getVendorProducts() {

                User vendor = getAuthenticatedUser();

                return productRepository
                                .findByVendor(vendor)
                                .stream()
                                .map(this::mapToResponse)
                                .toList();
        }

        @Override
        public ProductResponse createVendorProduct(
                        VendorProductRequest request) {

                User vendor = getAuthenticatedUser();

                Category category = categoryRepository
                                .findById(request.getCategoryId())
                                .orElseThrow(() -> new ResourceNotFoundException(
                                                "Category not found"));

                Product product = new Product();

                product.setName(request.getName());

                product.setSlug(
                                request.getName()
                                                .toLowerCase()
                                                .replace(" ", "-")
                                                + "-"
                                                + UUID.randomUUID()
                                                                .toString()
                                                                .substring(0, 5));

                product.setDescription(
                                request.getDescription());

                product.setShortDescription(
                                request.getShortDescription());

                product.setPrice(request.getPrice());

                product.setDiscountPrice(
                                request.getDiscountPrice());

                product.setStockQuantity(
                                request.getStockQuantity());

                product.setThumbnailUrl(
                                request.getThumbnailUrl());

                product.setCategory(category);

                product.setVendor(vendor);

                Product savedProduct = productRepository.save(product);

                return mapToResponse(savedProduct);
        }

        @Override
        public ProductResponse updateVendorProduct(
                        Long productId,
                        VendorProductRequest request) {

                User vendor = getAuthenticatedUser();

                Product product = productRepository
                                .findById(productId)
                                .orElseThrow(() -> new ResourceNotFoundException(
                                                "Product not found"));

                if (!product.getVendor().getId()
                                .equals(vendor.getId())) {

                        throw new BadRequestException(
                                        "Unauthorized product access");
                }

                Category category = categoryRepository
                                .findById(request.getCategoryId())
                                .orElseThrow(() -> new ResourceNotFoundException(
                                                "Category not found"));

                product.setName(request.getName());

                product.setDescription(
                                request.getDescription());

                product.setShortDescription(
                                request.getShortDescription());

                product.setPrice(request.getPrice());

                product.setDiscountPrice(
                                request.getDiscountPrice());

                product.setStockQuantity(
                                request.getStockQuantity());

                product.setThumbnailUrl(
                                request.getThumbnailUrl());

                product.setCategory(category);

                Product updatedProduct = productRepository.save(product);

                return mapToResponse(updatedProduct);
        }

        @Override
        public void deleteVendorProduct(
                        Long productId) {

                User vendor = getAuthenticatedUser();

                Product product = productRepository
                                .findById(productId)
                                .orElseThrow(() -> new ResourceNotFoundException(
                                                "Product not found"));

                if (!product.getVendor().getId()
                                .equals(vendor.getId())) {

                        throw new BadRequestException(
                                        "Unauthorized product access");
                }

                productRepository.delete(product);
        }

        @Override
        public Page<ProductResponse> searchProducts(
                        ProductFilterRequest request) {

                Pageable pageable = PageRequest.of(
                                request.getPage(),
                                request.getSize(),
                                Sort.by(
                                                request.getDirection(),
                                                request.getSortBy()));

                Page<Product> products;

                if (request.getKeyword() != null
                                && !request.getKeyword().isBlank()) {

                        products = productRepository
                                        .findByNameContainingIgnoreCase(
                                                        request.getKeyword(),
                                                        pageable);

                } else {

                        products = productRepository
                                        .findAll(pageable);
                }

                return products.map(this::mapToResponse);
        }

        private User getAuthenticatedUser() {

                String email = SecurityContextHolder
                                .getContext()
                                .getAuthentication()
                                .getName();

                return userRepository
                                .findByEmail(email)
                                .orElseThrow(() -> new ResourceNotFoundException(
                                                "User not found"));
        }

        private ProductResponse mapToResponse(
                        Product product) {

                return ProductResponse.builder()
                                .id(product.getId())
                                .name(product.getName())
                                .slug(product.getSlug())
                                .description(product.getDescription())
                                .shortDescription(
                                                product.getShortDescription())
                                .price(product.getPrice())
                                .discountPrice(
                                                product.getDiscountPrice())
                                .stockQuantity(
                                                product.getStockQuantity())
                                .thumbnailUrl(
                                                product.getThumbnailUrl())
                                .category(
                                                product.getCategory() != null
                                                                ? product.getCategory().getName()
                                                                : null)
                                .vendor(
                                                product.getVendor() != null
                                                                ? product.getVendor().getFirstName()
                                                                : null)
                                .build();
        }

}