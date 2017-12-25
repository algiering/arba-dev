package java24.mybatis.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java24.mybatis.ModelBook;
import java24.mybatis.inf.IBook;

@Repository("daobook")
public class DaoBook implements IBook {

    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;

    @Override
    public int getCount(ModelBook book) throws Exception {
        int result = -1;
        result = session.selectOne("mapper.mysql.mapperBook.getCount", book);
        return result;
    }

    @Override
    public int getMaxBookid() throws Exception {
        int result = -1;
        result = session.selectOne("mapper.mysql.mapperBook.getMaxBookid");
        return result;
    }

    @Override
    public List<ModelBook> selectAll() throws Exception {
        List<ModelBook> result = null;
        result = session.selectList("mapper.mysql.mapperBook.selectAll");
        return result;
    }

    @Override
    public List<ModelBook> selectLike(ModelBook book) throws Exception {
        List<ModelBook> result = null;
        result = session.selectList("mapper.mysql.mapperBook.selectLike", book);
        return result;
    }

    @Override
    public List<ModelBook> selectEqual(ModelBook book) throws Exception {
        List<ModelBook> result = null;
        result = session.selectList("mapper.mysql.mapperBook.selectEqual", book);
        return result;
    }

    @Override
    public List<ModelBook> selectDynamic(ModelBook book) throws Exception {
        List<ModelBook> result = null;
        result = session.selectList("mapper.mysql.mapperBook.selectDynamic", book);
        return result;
    }

    @Override
    public int insertBook(ModelBook book) throws Exception {
        @SuppressWarnings("unused")
        int result = -1;
        result = session.insert("mapper.mysql.mapperBook.insertBook", book);
        return book.getBookid();
    }

    @Override
    public int insertMap(String bookname, Date dtm, int authid) throws Exception {
        int result = -1;
        Map<String, Object> map = new HashMap<>();
        map.put("bookname", bookname);
        map.put("dtm",      dtm     );
        map.put("authid",   authid  );
        result = session.insert("mapper.mysql.mapperBook.insertMap", map);
        return result;
    }

    @Override
    public int updateBook(ModelBook wherebook, ModelBook setbook) throws Exception {
        int result = -1;
        Map<String, ModelBook> map = new HashMap<>(); 
        map.put("setbook", setbook);
        map.put("wherebook", wherebook);
        result = session.update("mapper.mysql.mapperBook.updateBook", map);
        return result;
    }

    @Override
    public int deleteBook(ModelBook book) throws Exception {
        int result = -1;
        result = session.delete("mapper.mysql.mapperBook.deleteBook", book);
        return result;
    }
    
    public int autoIncrementRefresh() throws Exception {
        int result = -1;
        result = session.update("mapper.mysql.mapperBook.autoIncrementRefresh");
        return result;
    }
}
