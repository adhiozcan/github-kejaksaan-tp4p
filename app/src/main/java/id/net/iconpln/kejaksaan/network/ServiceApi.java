package id.net.iconpln.kejaksaan.network;

import id.net.iconpln.kejaksaan.model.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Ozcan createNew 24/11/2016.
 *
 * @author Ozcan
 */

public interface ServiceApi {

    @FormUrlEncoded
    @POST(ServiceUrl.USER_LOGIN)
    Call<LoginResponse> loginUser(
            @Field("username") String username,
            @Field("password") String password
    );
}
