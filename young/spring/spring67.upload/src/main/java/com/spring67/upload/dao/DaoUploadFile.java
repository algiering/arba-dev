package com.spring67.upload.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring67.upload.model.ModelUploadFile;
import com.spring67.upload.model.ModelUploadImage;

@Repository
public class DaoUploadFile implements IDaoUploadFile {
    
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    org.apache.ibatis.session.SqlSession session;
    
    @Override
    public List<ModelUploadFile> getUploadFile(ModelUploadFile file) {
        return session.selectList("mapper.mysql.mapperUpload.getUploadFile", file);
    }
    
    @Override
    public int insertUploadFile(ModelUploadFile file) {
        session.insert("mapper.mysql.mapperUpload.insertUploadFile", file);
        // inserted 된 primary key 값이 반환됨
        return file.getUploadFileNo() ;  
    }
    
    @Override
    public int insertUploadFileList(List<ModelUploadFile> files) {
        return session.insert("mapper.mysql.mapperUpload.insertUploadFileList", files);
    }
    
    @Override
    public int deleteUploadFile(ModelUploadFile file) {
        return session.delete("mapper.mysql.mapperUpload.deleteUploadFile", file);
    }
    


    @Override
    public int insertPhoto(ModelUploadImage attachfile) {
        
       /*Oracle 용 
        Map<String, Object> map = new  HashMap<String, Object>();
        map.put("file"  , attachfile);
        map.put("result", null);
        
        session.insert("mapper.mapperUpload.insertPhoto", map);
        int result = map.get("result") != null ? (int) map.get("result") : -1;
        
        return result;
        */
        
        session.insert("mapper.mapperUpload.insertPhoto", attachfile );
        return attachfile.getUploadImageNo();
    }
    
    @Override
    public ModelUploadImage getImageByte(int attachfileno) {
        return session.selectOne("mapper.mapperUpload.getImageByte", attachfileno);
    }
}
