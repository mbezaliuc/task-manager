package com.usm.taskmanagement.integration.client;

import retrofit2.Call;
import retrofit2.http.GET;
import com.usm.taskmanagement.integration.model.User;

import java.util.List;

public interface UserManagerClient {

    @GET("users")
    Call<List<User>> getUsers();

}
