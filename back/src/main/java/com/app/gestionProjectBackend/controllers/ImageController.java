package com.app.gestionProjectBackend.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.gestionProjectBackend.Dto.Response.ImageUploadResponse;
import com.app.gestionProjectBackend.Dto.Response.ImageUtility;
import com.app.gestionProjectBackend.Repository.ImageRepository;
import com.app.gestionProjectBackend.Repository.ProductRepository;
import com.app.gestionProjectBackend.Repository.UserRepository;
import com.app.gestionProjectBackend.models.Image;
import com.app.gestionProjectBackend.models.Product;
import com.app.gestionProjectBackend.models.User;

@RestController
//@CrossOrigin(origins = "http://localhost:8082") open for specific port
@CrossOrigin() // open for all ports
public class ImageController {

  @Autowired
  ImageRepository imageRepository;

  @Autowired
  ProductRepository productRepository;
  
  @Autowired
  UserRepository userRepository;
  
  @PostMapping("/api/upload/image")
  public ResponseEntity<ImageUploadResponse> uplaodImage(@RequestParam("image") MultipartFile file, @RequestParam("name") String entity_name)
          throws IOException {

      imageRepository.save(Image.builder()
              .name(file.getOriginalFilename())
              .type(file.getContentType())
              .entity_name(entity_name)
              .image(ImageUtility.compressImage(file.getBytes())).build());
      return ResponseEntity.status(HttpStatus.OK)
              .body(new ImageUploadResponse("Image uploaded successfully: " +
                      file.getOriginalFilename()));
  }

  @GetMapping(path = {"/api/get/image/info/{name}"})
  public Image getImageDetails(@PathVariable("name") String name) throws IOException {

      final Optional<Image> dbImage = imageRepository.findByName(name);

      return Image.builder()
              .name(dbImage.get().getName())
              .type(dbImage.get().getType())
              .image(ImageUtility.decompressImage(dbImage.get().getImage())).build();
  }
  
  @GetMapping(path = {"/api/get/image/product/{id}"})
  public List<Image> getImageProduct(@PathVariable("id") Long id) throws IOException {

	  Product p = productRepository.findById(id).get();
      final Optional<Image> dbImage = imageRepository.findByEntity_name(p.getEntity_name());
      Image img = Image.builder()
      .name(dbImage.get().getName())
      .type(dbImage.get().getType())
      .image(ImageUtility.decompressImage(dbImage.get().getImage())).build();
      
      final Optional<Image> dbImage1 = imageRepository.findByEntity_name(p.getEntity_name_1());
      Image img1 = Image.builder()
      .name(dbImage1.get().getName())
      .type(dbImage1.get().getType())
      .image(ImageUtility.decompressImage(dbImage1.get().getImage())).build();

      final Optional<Image> dbImage2 = imageRepository.findByEntity_name(p.getEntity_name_2());
      Image img2 = Image.builder()
      .name(dbImage2.get().getName())
      .type(dbImage2.get().getType())
      .image(ImageUtility.decompressImage(dbImage2.get().getImage())).build();
      
      List<Image> list = new ArrayList<>();
      list.add(img);
      list.add(img1);
      list.add(img2);
      
      return list;
  }
  
  @GetMapping(path = {"/api/get/image/user/{id}"})
  public Image getImageUser(@PathVariable("id") Long id) throws IOException {

	  User p = userRepository.findById(id).get();
      final Optional<Image> dbImage = imageRepository.findByEntity_name(p.getEntity_name());

      return Image.builder()
              .name(dbImage.get().getName())
              .type(dbImage.get().getType())
              .image(ImageUtility.decompressImage(dbImage.get().getImage())).build();
  }

  @GetMapping(path = {"/api/get/image/{name}"})
  public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) throws IOException {

      final Optional<Image> dbImage = imageRepository.findByName(name);

      return ResponseEntity
              .ok()
              .contentType(MediaType.valueOf(dbImage.get().getType()))
              .body(ImageUtility.decompressImage(dbImage.get().getImage()));
  }
}
