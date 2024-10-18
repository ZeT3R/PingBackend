package com.ping.pinglocal;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class TestImgController {
    
    @GetMapping("/img")
    public ResponseEntity<Resource> getImage() throws IOException {
        Resource imageResource = new ClassPathResource("images/image.png"); 
        
        if (!imageResource.exists() || !imageResource.isReadable()) {
            return ResponseEntity.notFound().build();
        }


        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=image.png")
                .body(imageResource);

    }
    
}
