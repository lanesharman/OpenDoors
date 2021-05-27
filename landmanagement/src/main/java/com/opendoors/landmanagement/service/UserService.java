package com.opendoors.landmanagement.service;

import java.net.URLEncoder;

import com.opendoors.landmanagement.domain.User;

import org.springframework.stereotype.Service;


@Service
public class UserService {
    //Field id
    // String idCode = "1000532";
    // String idName = "1000539";
    // String idEmail = "1000533";
    // String idPhone = "1000534";
    // String idStatus = "1000535";
    // String idMessage = "1000536";

    String idCode = "1000019";
    String idName = "1000024";
    String idEmail = "1000020";
    String idPhone = "1000021";
    String idStatus = "1000022";
    String idMessage = "1000023";

    RagicHttpService ragicHttpService = new RagicHttpService();

    public void checkCode(String code) throws Exception {
        if (code == null || code.isEmpty()) {
            throw new Exception("Authentication Code is required");
        }
    }
    public void checkUser(User user) throws Exception {
        if (user.getEmail().isEmpty()) {
            throw new Exception("Email is required");
        }
        else if (user.getPhone().isEmpty()) {
            throw new Exception("Phone Number is required");
        }
        else {
            postUser(user);
        }
        System.out.println(user);
        
    }

    public void postUser(User user){
        String json = userJsonTrans(user);
        String url = "https://na3.ragic.com/zoeisdoingsometest/land-management/1?v=3&api";
        //String url = "https://www.ragic.com/ozquantum/real-estate/10?v=3&api";
        try{
            System.out.println(ragicHttpService.sendPost(url, json));
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    public String userJsonTrans(User user){
        String json = "";
        try{
            json += idCode+ "=" + URLEncoder.encode(user.getCode(), "UTF-8") + "&" + 
                    idName + "=" + URLEncoder.encode(user.getName(), "UTF-8") + "&" + 
                    idEmail + "=" + URLEncoder.encode(user.getEmail(), "UTF-8") + "&" + 
                    idPhone + "=" + URLEncoder.encode(user.getPhone(), "UTF-8") + "&" + 
                    idStatus + "=" + URLEncoder.encode(user.getStatus(), "UTF-8") + "&" + 
                    idMessage + "=" + URLEncoder.encode(user.getMessage(), "UTF-8");
    
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return json;
    }

}
