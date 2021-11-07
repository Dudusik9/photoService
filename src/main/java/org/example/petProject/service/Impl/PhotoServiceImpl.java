package org.example.petProject.service.Impl;

import org.example.petProject.entity.BaseResponse;
import org.example.petProject.repositories.PhotoRepository;
import org.example.petProject.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class PhotoServiceImpl implements PhotoService {
    private final PhotoRepository photoRepository;

    @Autowired
    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public BaseResponse getTestMessage(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<byte[]> downloadFile(Long id) {
        try {
            Path path = Paths.get(photoRepository.findById(id).get().getPathToPhoto());
            byte[] byteArrayImage = Files.readAllBytes(path);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            headers.setContentLength(byteArrayImage.length);
            return new ResponseEntity<>(byteArrayImage, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
