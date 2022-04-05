package uqac.dim.appinfomobile;

public class ApiClient {
    chaîne statique privée BASE_URL="http://www.mocky.io/v2/" ;

    rétrofit statique privé;

    public static Retrofit getInstance(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        rétrofit de retour ;
    }
}
