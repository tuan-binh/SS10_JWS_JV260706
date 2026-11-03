package org.example.session10.models.dto.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductReq(
        @NotBlank(message = "Tên sản phẩm không được để trống")
        String name,
        @NotNull(message = "Giá sản phẩm không được để trống")
        @Min(value = 1,message = "Giá phải lớn hơn 0")
        Double price,
        @Positive(message = "Giá sản phẩm phải lớn hơn 0")
        Integer stock,
        @NotNull(message = "Mã danh mục không được để trống")
        Long categoryId
) {
}
