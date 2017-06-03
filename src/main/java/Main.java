import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.google.gson.Gson;
import graphql.introspection.IntrospectionQuery;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static void main(String[] args) throws IOException {

        InputStream resourceAsStream = Main.class.getResourceAsStream("/request.graphql");
        String query = CharStreams.toString(new InputStreamReader(resourceAsStream, Charsets.UTF_8));
        resourceAsStream.close();

        String url = "https://vkpwr4q53.lp.gql.zone/graphql";
        OkHttpClient client = new OkHttpClient();

        Map<String, String> requestBody = new LinkedHashMap<>();
        requestBody.put("query", query);

        Gson gson = new Gson();
        String bodyReal = gson.toJson(requestBody);
        RequestBody body = RequestBody.create(JSON, bodyReal);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        String responseString = response.body().string();
        Map responseBody = gson.fromJson(responseString, Map.class);
        System.out.println(responseBody);
    }

}
