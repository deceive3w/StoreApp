package com.example.root.cartsystem.service.client;

import retrofit2.Retrofit;

public class NetworkService {
    Retrofit.Builder retrofit;
    private  static NetworkService networkService;
    public static NetworkService get(){
        if(networkService == null){
            networkService = new NetworkService();

        }
        return networkService;
    }
    public NetworkService(){
    }
}
