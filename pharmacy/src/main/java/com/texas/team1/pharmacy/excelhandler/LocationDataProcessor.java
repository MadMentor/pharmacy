package com.texas.team1.pharmacy.excelhandler;

import com.texas.team1.pharmacy.dto.LocationDto;
import com.texas.team1.pharmacy.entity.District;
import com.texas.team1.pharmacy.entity.LocalBodies;
import com.texas.team1.pharmacy.entity.Province;
import com.texas.team1.pharmacy.repo.DistrictRepo;
import com.texas.team1.pharmacy.repo.LocalBodiesRepo;
import com.texas.team1.pharmacy.repo.ProvinceRepo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * LocationDataProcessor
 * Created On : 5/7/2024 8:36 PM
 **/
@Component
public class LocationDataProcessor {
    private final ProvinceRepo provinceRepo;
    private final DistrictRepo districtRepo;
    private final LocalBodiesRepo localBodiesRepo;

    public LocationDataProcessor(ProvinceRepo provinceRepo, DistrictRepo districtRepo, LocalBodiesRepo localBodiesRepo) {
        this.provinceRepo = provinceRepo;
        this.districtRepo = districtRepo;
        this.localBodiesRepo = localBodiesRepo;
    }

    public void processLocationDto(List<LocationDto> locationDtoList) {
        List<LocationDto> provinceLocationList = locationDtoList.stream().filter(locationDto ->
                locationDto.getParentId() == 0).collect(Collectors.toList());
        List<Province> provinceList = convertAndSaveLocationListToProvinceList(provinceLocationList);
        for (Province province : provinceList) {
            List<LocationDto> districtLocationList = locationDtoList.stream().filter(locationDto ->
                    locationDto.getParentId() == province.getCode()).collect(Collectors.toList());
            List<District> districtList = convertAndSaveLocationListToDistrictList(districtLocationList, province);
            for (District district : districtList) {
                List<LocationDto> localBodiesLocationList = locationDtoList.stream().filter(locationDto -> locationDto.getParentId() == district.getCode()).collect(Collectors.toList());
                convertAndSaveLocationListToLocalBodiesList(localBodiesLocationList, district);
            }
        }
    }

    private List<Province> convertAndSaveLocationListToProvinceList(List<LocationDto> provinceLocationList) {
        List<Province> provinceList = new ArrayList<>();
        for (LocationDto locationDto : provinceLocationList) {
            provinceList.add(new Province(null, locationDto.getName(), locationDto.getNepaliName(),
                    locationDto.getCode()));
        }
        provinceList = provinceRepo.saveAll(provinceList);
        return provinceList;
    }

    private List<District> convertAndSaveLocationListToDistrictList(List<LocationDto> districtLocationList, Province province) {
        List<District> districtList = new ArrayList<>();
        for (LocationDto locationDto : districtLocationList) {
            districtList.add(new District(null, locationDto.getName(), locationDto.getNepaliName(),
                    locationDto.getCode(), province));
        }
        districtList = districtRepo.saveAll(districtList);
        return districtList;
    }

    private void convertAndSaveLocationListToLocalBodiesList(List<LocationDto> localBodiesLocationList, District district) {
        List<LocalBodies> localBodiesList = new ArrayList<>();
        for (LocationDto locationDto : localBodiesLocationList) {
            localBodiesList.add(new LocalBodies(null, locationDto.getName(), locationDto.getNepaliName(),
                    locationDto.getCode(), district));
        }
        localBodiesRepo.saveAll(localBodiesList);
    }
}
