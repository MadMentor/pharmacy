package com.texas.team1.pharmacy.controller;

import com.texas.team1.pharmacy.dto.FileDto;
import com.texas.team1.pharmacy.dto.LocationDto;
import com.texas.team1.pharmacy.excelhandler.LocationDataProcessor;
import com.texas.team1.pharmacy.excelhandler.PoijiUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

/**
 * FileUploadController
 * Created On : 5/7/2024 3:44 PM
 **/
@Controller
@RequestMapping("/upload")
public class FileUploadController {
    private final PoijiUtils poijiUtils;
    private final LocationDataProcessor locationDataProcessor;

    public FileUploadController(PoijiUtils poijiUtils, LocationDataProcessor locationDataProcessor) {
        this.poijiUtils = poijiUtils;
        this.locationDataProcessor = locationDataProcessor;
    }

    @PostMapping("/excel")
    public String uploadExcel(@ModelAttribute FileDto fileDto) throws IOException {
        List<LocationDto> locationDtoList =  poijiUtils.readData(fileDto.getMultipartFile());
        locationDtoList.stream().forEach(System.out::println);
//        System.out.println("Hello" + locationDtoList);
        locationDataProcessor.processLocationDto(locationDtoList);
        return "redirect:/";
    }
}
