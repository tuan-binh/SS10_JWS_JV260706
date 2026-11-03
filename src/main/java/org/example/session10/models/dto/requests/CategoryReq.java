package org.example.session10.models.dto.requests;

import jakarta.validation.constraints.NotBlank;

public record CategoryReq(
        @NotBlank(message = "Tên danh mục không được để trống")
        String name
) {
}
