package com.appmp3.appnhac.Service;

public class APIService {
        private static String base_url = "http://10.0.2.2:8081/PhpAppNhac/Service/";

    public static Dataservice getService(){
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}
