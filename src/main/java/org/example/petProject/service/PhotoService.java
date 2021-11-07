package org.example.petProject.service;

import org.example.petProject.entity.BaseResponse;
import org.springframework.http.ResponseEntity;

public interface PhotoService {
    BaseResponse getTestMessage (Long id);
    ResponseEntity<byte[]> downloadFile(Long id);
}
