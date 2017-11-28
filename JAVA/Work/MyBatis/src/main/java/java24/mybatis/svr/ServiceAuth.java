package java24.mybatis.svr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java24.mybatis.ModelAuth;
import java24.mybatis.inf.IAuth;
import java24.mybatis.inf.IServiceAuth;

@Service("serviceauth")
public class ServiceAuth implements IServiceAuth {
    
    @Autowired
    @Qualifier("daoauth")
    private IAuth dao;
    
    @Override
    public int getCount(ModelAuth auth) throws Exception {
        int result = -1;
        try {
            result = dao.getCount(auth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int getMaxAuthid() throws Exception {
        int result = -1;
        try {
            result = dao.getMaxAuthid();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelAuth> selectAll() throws Exception {
        List<ModelAuth> result = null;
        try {
            result = dao.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelAuth> selectLike(ModelAuth auth) throws Exception {
        List<ModelAuth> result = null;
        try {
            result = dao.selectLike(auth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelAuth> selectEqual(ModelAuth auth) throws Exception {
        List<ModelAuth> result = null;
        try {
            result = dao.selectEqual(auth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int insertAuth(ModelAuth auth) throws Exception {
        int result = -1;
        try {
            result = dao.insertAuth(auth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateAuth(ModelAuth whereauth, ModelAuth setauth) throws Exception {
        int result = -1;
        try {
            result = dao.updateAuth(whereauth, setauth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteAuth(ModelAuth auth) throws Exception {
        int result = -1;
        try {
            result = dao.deleteAuth(auth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
