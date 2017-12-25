package java24.mybatis.svr;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java24.mybatis.ModelBook;
import java24.mybatis.inf.IBook;
import java24.mybatis.inf.IServiceBook;

@Service("servicebook")
public class ServiceBook implements IServiceBook {
    
    @Autowired
    @Qualifier("daobook")
    private IBook dao;

    @Override
    public int getCount(ModelBook book) throws Exception {
        int result = -1;
        try {
            result = dao.getCount(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int getMaxBookid() throws Exception {
        int result = -1;
        try {
            result = dao.getMaxBookid();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelBook> selectAll() throws Exception {
        List<ModelBook> result = null;
        try {
            result = dao.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelBook> selectLike(ModelBook book) throws Exception {
        List<ModelBook> result = null;
        try {
            result = dao.selectLike(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelBook> selectEqual(ModelBook book) throws Exception {
        List<ModelBook> result = null;
        try {
            result = dao.selectEqual(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelBook> selectDynamic(ModelBook book) throws Exception {
        List<ModelBook> result = null;
        try {
            result = dao.selectDynamic(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int insertBook(ModelBook book) throws Exception {
        int result = -1;
        try {
            result = dao.insertBook(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int insertMap(String bookname, Date dtm, int authid) throws Exception {
        int result = -1;
        try {
            result = dao.insertMap(bookname, dtm, authid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateBook(ModelBook wherebook, ModelBook setbook) throws Exception {
        int result = -1;
        try {
            result = dao.updateBook(wherebook, setbook);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteBook(ModelBook book) throws Exception {
        int result = -1;
        try {
            result = dao.deleteBook(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int autoIncrementRefresh() throws Exception {
        int result = -1;
        try {
            result = dao.autoIncrementRefresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
