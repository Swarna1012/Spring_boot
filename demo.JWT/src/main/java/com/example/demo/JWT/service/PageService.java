package com.example.demo.JWT.service;

import com.example.demo.JWT.common.APIResponse;
import com.example.demo.JWT.common.PaginationMeta;
import com.example.demo.JWT.data.UserData;
import com.example.demo.JWT.entity.ImageData;
import com.example.demo.JWT.entity.User;
import com.example.demo.JWT.repo.Repository;
import com.example.demo.JWT.repo.UserPageRepository;
import com.example.demo.JWT.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PageService {

    @Autowired
    private UserPageRepository userPageRepository;

    @Autowired
    private Repository repository;

    public APIResponse getUsers(Pageable pageable) {
        APIResponse apiResponse = new APIResponse();

        // make db call to get user
        Page<User> userPage = userPageRepository.findAll(pageable);

        List<User> users = userPage.getContent();
        PaginationMeta userPaginationMeta = PaginationMeta.createPagination(userPage);

        UserData userData = new UserData();
        userData.setUsers(users);
        userData.setPagination(userPaginationMeta);

        apiResponse.setData(userData);
        return apiResponse;
    }

    public String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData = repository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imagedata(ImageUtils.compressImage(file.getBytes())).build());

        if(imageData!=null){
            return "file uploaded : " + file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadImage(String filename) {
        Optional<ImageData> dbImageData = repository.findByName(filename);
        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImagedata());
        return images;
    }
}
