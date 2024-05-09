package com.texas.team1.pharmacy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * FileDto
 * Created On : 5/7/2024 3:34 PM
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileDto {
    private MultipartFile multipartFile;
}
