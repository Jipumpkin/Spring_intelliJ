package com.example.Springboot.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookPayloadDTO {

    @NotBlank // 공백이 아니여야함을 명시하는 어노테이션
    @Schema(
            description = "책의 제목",
            example = "JAVA",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String title;

    @NotBlank
    private  int price;
    @NotBlank
    private String author;
    @NotBlank
    private int page;

}
