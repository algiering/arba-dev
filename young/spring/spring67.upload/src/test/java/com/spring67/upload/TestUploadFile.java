package com.spring67.upload;

import static org.junit.Assert.*;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.spring67.upload.model.ModelUploadFile;
import com.spring67.upload.model.RepositoryFiles;
import com.spring67.upload.service.IServiceUploadFile;

public class TestUploadFile {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private static ApplicationContext context;
    private static IServiceUploadFile service;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
        context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service = context.getBean(IServiceUploadFile.class);
    }

    @Test
    public void test01_InsertUploadFile() throws IOException {
        int result = -1;
        
        // 테스트용 변수 설정 : client로 부터 받게 되는 값들.
        File uploadfile = new File("src/test/resources/image.png");
        FileInputStream inputFile = new FileInputStream( uploadfile.getAbsolutePath() );  
        MockMultipartFile clinetfile = new MockMultipartFile( uploadfile.getName(), uploadfile.getName(), "image/png", inputFile);
        String UPLOAD_PATH = "C:\\"; // 클라이언트에서 올라온 image.png 를 저장할 서버의 폴더 위치.
         
        // step2. 클라이언트의 첨부 파일을 서버로 올리고  DB insert 처리
        if( !clinetfile.getOriginalFilename().isEmpty() ){
            
            // 서버의 업로드 폴더 존재 여부 체크. 없으면 폴더 생성.
            java.io.File uploadDir = new java.io.File( UPLOAD_PATH  );
            if( !uploadDir.exists() ) uploadDir.mkdir();            

            // 클라이언트의 첨부 파일을 서버로 복사
            String fileName  = clinetfile.getOriginalFilename();
            String tempName  = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            String filepath  = UPLOAD_PATH + tempName;                 
            java.io.File serverfile   = new java.io.File( filepath );                
            clinetfile.transferTo( serverfile ); // 실제로 파일 카피 발생.

            // DB insert 처리를 위한 코드
            ModelUploadFile attachfile = new ModelUploadFile();
            attachfile.setFileNameOrig( fileName );
            attachfile.setFileNameTemp( tempName );
            attachfile.setFileSize( (Long)serverfile.length() );
            attachfile.setContentType( clinetfile.getContentType() ); // 파일 확장자
    
            // DB insert 
            result = service.insertUploadFile(attachfile);
        }
        
        assertTrue( result > 0 );
    }

    @Test
    public void test02_InsertUploadFileList() throws IOException {
        int result = -1;
        
        // step1. 테스트용 변수 설정 : client로 부터 받게 되는 값들.
        List<MultipartFile> localfiles = new ArrayList<>();
        for(int i=0; i<10; i++){
            File uploadfile           = new File("src/test/resources/image.png");
            FileInputStream inputFile = new FileInputStream( uploadfile.getAbsolutePath() );  
            MockMultipartFile file    = new MockMultipartFile( uploadfile.getName(), uploadfile.getName(), "image/png", inputFile);
            localfiles.add(file);
        }
        RepositoryFiles uploadForm = new RepositoryFiles();
        uploadForm.setFiles(localfiles);
        String UPLOAD_PATH = "C:\\aaaaaa"; 
         
                
        // step2. 클라이언트의 파일을 서버로 복사 && table insert 작업
        if( uploadForm != null && uploadForm.getFiles().size()>0 ){
            
            // 업로드 폴더 존재 여부 체크. 없으면 폴더 생성.
            java.io.File uploadDir = new java.io.File( UPLOAD_PATH  );
            if( !uploadDir.exists() ) uploadDir.mkdir();            

            // DB에 insert 할 데이터를 닫는 list
            List<ModelUploadFile> listfile = new ArrayList<>();
            
            List<MultipartFile> files = uploadForm.getFiles();
            if( files != null && files.size() > 0 ){
                
                int index = 0;
                for (MultipartFile clientfile : files) {
                    
                    // 클라이언트의 첨부 파일을 서버로 복사
                    String fileName = clientfile.getOriginalFilename();
                    String tempName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) +  String.format("%04d", ++index);
                    String filepath = UPLOAD_PATH + "/" + tempName;                 
                    java.io.File serverfile   = new java.io.File( filepath );                
                    clientfile.transferTo( serverfile ); 
                    
                    // DB insert 처리를 위한 코드
                    ModelUploadFile attachfile = new ModelUploadFile();
                    attachfile.setFileNameOrig( fileName );
                    attachfile.setFileNameTemp( tempName );
                    attachfile.setFileSize( (Long)serverfile.length() );
                    attachfile.setContentType( clientfile.getContentType() ); // 확장자
                    
                    //
                    listfile.add(attachfile);
                }
            }   
    
            // DB insert 
            result = service.insertUploadFileList(listfile);
        }
        
        assertTrue( result > 0 );
    }


    @Test
    public void test03_GetUploadFile() {
        ModelUploadFile file = new ModelUploadFile();
        file.setUploadFileNo(1);
        
        // DB select 
        List<ModelUploadFile> result = service.getUploadFile(file);
        
        assertNotNull(result);
        assertSame( 1, result.get(0).getUploadFileNo() );
        assertTrue( !result.get(0).getFileNameTemp().isEmpty() );
        
        

        result = service.getUploadFile( null );
        
        assertNotNull(result);
        assertSame( 1, result.get(0).getUploadFileNo() );
        assertTrue( !result.get(0).getFileNameTemp().isEmpty() );
    }
    
    
    @Test
    public void test04_DeleteUploadFile() {
        ModelUploadFile file = new ModelUploadFile();
        file.setUploadFileNo(1);
        
        // DB delete 
        int result = service.deleteUploadFile(file);
        
        assertSame(1, result);
    }
}
