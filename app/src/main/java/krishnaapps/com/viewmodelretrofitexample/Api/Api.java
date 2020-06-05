package krishnaapps.com.viewmodelretrofitexample.Api;

import java.util.List;

import krishnaapps.com.viewmodelretrofitexample.Model.Hero;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("demos/marvel/")
    Call<List<Hero>> getPoster();
}
