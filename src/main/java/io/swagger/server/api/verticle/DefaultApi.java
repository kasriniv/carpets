package io.swagger.server.api.verticle;

import io.swagger.server.api.model.Carpets;

import java.util.List;
import java.util.Map;

public interface DefaultApi  {
    //GET_carpets
    public Carpets carpetsGet();
    
    //POST_carpets
    public Carpets carpetsPost(Carpets body);
    
}
