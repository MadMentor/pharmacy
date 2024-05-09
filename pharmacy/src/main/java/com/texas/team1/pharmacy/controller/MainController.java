package com.texas.team1.pharmacy.controller;

import com.texas.team1.pharmacy.dto.FileDto;
import com.texas.team1.pharmacy.excelhandler.PoijiUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author MainController
 * java-suraj -- 2024-01-26
 */

@Controller
@RequestMapping("/")
public class MainController {
    private final PoijiUtils poijiUtils;

    public MainController(PoijiUtils poijiUtils) {
        this.poijiUtils = poijiUtils;
    }

//    public PoijiUtils getPoijiUtils() {
//        return poijiUtils;
//    }

    //    @RequestMapping(method = RequestMethod.GET, value = "/")
    @GetMapping
    public String openLandingPage(Model model) {
        model.addAttribute("fileDto", new FileDto());
        return "landingpage";
    }
}
