import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class WeatherInformationService {
    public static void main(String[] args){
        try {
            String apiKey = "d28c06e51b29f658068aeabd9fada2ac\n";
            String location = "Karnataka";//Enter location here
            String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + apiKey;
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
            System.out.println(result);
            System.out.println("Today Weather condition in "+location);
            JSONObject weatherData = new JSONObject(result.toString());
            JSONObject main = weatherData.getJSONObject("main");
            double temperature = main.getDouble("temp");
            System.out.println("Current temperature in " + location + ": " + temperature + "°C");
            double humidity = main.getDouble("humidity");
            System.out.println("Current humidity in " + location + ": " + humidity+"°C" );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
