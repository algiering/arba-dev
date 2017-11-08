package java23.jdbc;

public interface IServiceBook extends IBook {

    public int transCommit(ModelBook b1, ModelBook b2);
    
    public int transRollback(ModelBook b1, ModelBook b2);
    
}
