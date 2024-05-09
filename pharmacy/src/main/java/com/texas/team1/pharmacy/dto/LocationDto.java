package com.texas.team1.pharmacy.dto;

import com.poiji.annotation.ExcelCellName;
import lombok.Getter;
import lombok.Setter;

/**
 * LocationDto
 * Created On : 5/7/2024 3:54 PM
 **/
@Getter
@Setter
public class LocationDto {
    @ExcelCellName("Code")
    private Integer code;
    @ExcelCellName("Name")
    private String name;
    @ExcelCellName("Nepali Name")
    private String nepaliName;
    @ExcelCellName("Parent Code")
    private Integer parentId;
}
