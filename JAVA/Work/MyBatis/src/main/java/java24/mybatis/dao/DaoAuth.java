package java24.mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java24.mybatis.ModelAuth;
import java24.mybatis.inf.IAuth;

@Repository("daoauth")
public class DaoAuth implements IAuth {
    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;

    @Override
    public int getCount(ModelAuth auth) throws Exception {
        int result = -1;
        result = session.selectOne("mapper.mysql.mapperAuth.getCount", auth);
        return result;
    }

    @Override
    public int getMaxAuthid() throws Exception {
        int result = -1;
        result = session.selectOne("mapper.mysql.mapperAuth.getMaxAuthid");
        return result;
    }

    @Override
    public List<ModelAuth> selectAll() throws Exception {
        List<ModelAuth> result = null;
        result = session.selectList("mapper.mysql.mapperAuth.selectAll");
        return result;
    }

    @Override
    public List<ModelAuth> selectLike(ModelAuth auth) throws Exception {
        List<ModelAuth> result = null;
        result = session.selectList("mapper.mysql.mapperAuth.selectLike", auth);
        return result;
    }

    @Override
    public List<ModelAuth> selectEqual(ModelAuth auth) throws Exception {
        List<ModelAuth> result = null;
        result = session.selectList("mapper.mysql.mapperAuth.selectEqual", auth);
        return result;
    }

    @Override
    public int insertAuth(ModelAuth auth) throws Exception {
        int result = -1;
        result = session.insert("mapper.mysql.mapperAuth.insertAuth", auth);
        return result;
    }

    @Override
    public int updateAuth(ModelAuth whereauth, ModelAuth setauth) throws Exception {
        int result = -1;
        Map<String, ModelAuth> map = new HashMap<>();
        map.put("whereauth", whereauth);
        map.put("setauth", setauth);
        result = session.update("mapper.mysql.mapperAuth.updateAuth", map);
        return result;
    }

    @Override
    public int deleteAuth(ModelAuth auth) throws Exception {
        int result = -1;
        result = session.delete("mapper.mysql.mapperAuth.deleteAuth", auth);
        return result;
    }

}
