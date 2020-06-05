package krishnaapps.com.viewmodelretrofitexample.viewModel;


import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import krishnaapps.com.viewmodelretrofitexample.Api.Api;
import krishnaapps.com.viewmodelretrofitexample.Api.BuildRetrofit;
import krishnaapps.com.viewmodelretrofitexample.Model.Hero;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeroViewModel extends ViewModel {

    private MutableLiveData<List<Hero>> mutableLiveData;

    public LiveData<List<Hero>> getHeroes()
    {
        if(mutableLiveData == null)
        {
            mutableLiveData = new MutableLiveData<>();
            LoadHeroes();
        }
        return mutableLiveData;

    }

    private void LoadHeroes()
    {
        Api api = BuildRetrofit.getRetrofit().create(Api.class);

        Call<List<Hero>> call = api.getPoster();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                    mutableLiveData.setValue(response.body());

            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {

            }
        });

    }
}


