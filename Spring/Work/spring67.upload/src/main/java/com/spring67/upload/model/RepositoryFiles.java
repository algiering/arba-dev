package com.spring67.upload.model;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class RepositoryFiles {
    
    // 클라이언트에서 배열 넘어오는 변수를 자바의 List로 변환하기 위한 클래스
    // 필드명으로는 클라이언트에서 넘어오는 변수명 (input 태그의 name 속성 값)
    // ex) <input type="file" name="files[0]" />
    private List<MultipartFile> files;

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "RepositoryFiles [files=" + files + "]";
    }

    public RepositoryFiles(List<MultipartFile> files) {
        super();
        this.files = files;
    }

    public RepositoryFiles() {
        super();
    }
    
}
