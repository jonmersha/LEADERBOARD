package com.hira_software.leaderboard.retrofit;

import com.hira_software.leaderboard.model.FormResponse;
import com.hira_software.leaderboard.model.Hoarse;
import com.hira_software.leaderboard.model.PersonIQ;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NetworkService {


    @GET("api/skilliq")
    Call<List<PersonIQ>> getTopIQ();

    @GET("api/hours")
    Call<List<Hoarse>> getTopHousr();

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    //@POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/viewform")
    @POST("1FAIpQLSeQXj7Y9ANKFGAtCsyJ5Hx8vj-5eWj3vlo3nnSZYpRf6UGKgw/formResponse")
    @FormUrlEncoded
    Call<String> googleForm(
            @Field("entry.103352098") String firstName,
            @Field("entry.986621369") String lastName,
            @Field("entry.743986810") String emailAdress,
            @Field("entry.156705721") String projectLink
                                  );
}
