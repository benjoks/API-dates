package com.demo.da.response;

import java.util.ArrayList;
import java.util.HashMap;

public class ResponseRest {

    private ArrayList<HashMap<String,String>> metadata = new ArrayList<>();
    public ArrayList<HashMap<String,String>> getMetadata() {
        return metadata;
    }
    public void setMetadata(String statusCode, String message,String description){
        HashMap<String,String> mapa = new HashMap<String,String>();

        mapa.put("statusCode",statusCode);
        mapa.put("message",message);
        mapa.put("description",description);

        metadata.add(mapa);
    }

}
