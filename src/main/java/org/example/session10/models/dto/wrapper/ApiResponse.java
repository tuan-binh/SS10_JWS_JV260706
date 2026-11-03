package org.example.session10.models.dto.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ApiResponse<T> {
    private int code; // VD: 401, 400,...
    private String message; // Message thông báo
    private T data;
}
