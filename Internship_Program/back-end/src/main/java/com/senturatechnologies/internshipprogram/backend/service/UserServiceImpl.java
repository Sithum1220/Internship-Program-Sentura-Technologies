package com.senturatechnologies.internshipprogram.backend.service;

import com.senturatechnologies.internshipprogram.backend.entity.User;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserServiceImpl implements UserService {

    private final OkHttpClient client = new OkHttpClient();

    @Value("${weavy.api.key}")
    private String apiKey;

    @Value("${weavy.api.url}")
    private String baseUrl;

    @Override
    public String createUser(User user) throws IOException {
        String url = baseUrl + "users";
        RequestBody body = new FormBody.Builder()
                .add("name", user.getName())
                .add("email", user.getEmail())
                .build();

        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", "Bearer " + apiKey)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.out.println("Response Code: " + response.code());
                System.out.println("Response Message: " + response.message());
                System.out.println("Response Body: " + response.body().string());
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }

    @Override
    public String listUsers() throws IOException {
        String url = baseUrl + "users";
        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", "Bearer " + apiKey)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return response.body().string();
        }
    }

    @Override
    public String getUserDetails(String userId) throws IOException {
        String url = baseUrl + "users/" + userId;
        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", "Bearer " + apiKey)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return response.body().string();
        }
    }

    @Override
    public String updateUser(String userId, User user) throws IOException {
        String url = baseUrl + "users/" + userId;
        RequestBody body = new FormBody.Builder()
                .add("name", user.getName())
                .add("email", user.getEmail())
                .build();

        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", "Bearer " + apiKey)
                .put(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return response.body().string();
        }
    }

    @Override
    public String deleteUser(String userId) throws IOException {
        String url = baseUrl + "users/" + userId;
        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", "Bearer " + apiKey)
                .delete()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return response.body().string();
        }
    }
}
