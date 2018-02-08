package com.web2.juha.inf;

import com.web2.juha.model.ModelVote;

public interface IDaoVote {
    
    int getVoteCount(ModelVote vote);
    
    int insertVote(ModelVote vote);
    
    int deleteVote(ModelVote vote);

}
