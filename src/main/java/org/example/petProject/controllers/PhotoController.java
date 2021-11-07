package org.example.petProject.controllers;

import org.example.petProject.dto.BaseResponseDto;
import org.example.petProject.entity.BaseResponse;
import org.example.petProject.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class PhotoController {

    private final PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping
    public String response(@RequestParam(name = "numberPhoto") Long id){
        BaseResponse baseResponse = photoService.getTestMessage(id);
        BaseResponseDto baseResponseDto = BaseResponseDto.builder()
                .id(baseResponse.getId())
                .value(baseResponse.getValue())
                .description(baseResponse.getDescription())
                .build();
        return baseResponseDto.getDescription();
    }

    @GetMapping("/getPhoto")
    public ResponseEntity<byte[]> dowmloadPhoto(@RequestParam(name = "numberPhoto") Long id){
        return photoService.downloadFile(id);
    }
}
