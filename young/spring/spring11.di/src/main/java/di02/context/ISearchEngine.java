package di02.context;

import java.util.List;

public interface ISearchEngine {
    
    List<Document> findByType(Type documentType);
    List<Document> listAll();    
}
