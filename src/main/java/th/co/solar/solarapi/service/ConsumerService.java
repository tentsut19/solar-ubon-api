package th.co.solar.solarapi.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.co.solar.solarapi.model.WeatherForecast7Days;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class ConsumerService {
    public void processQueue() {
        log.info("Start consume queue at {}", new Date());

        // Get a reference to our posts
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("ParameterDaily");
        DatabaseReference refTotal = database.getReference("ParameterDailyTotal");

        // Attach a listener to read the data at our posts reference
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                log.info("dataSnapshot : {}",dataSnapshot);
                if(dataSnapshot.exists()){
                    HashMap<String,HashMap> hashMapData = (HashMap<String,HashMap>) dataSnapshot.getValue();
                    if(hashMapData != null) {
                        Long chartdailygrid_total = 0L;
                        Long chartdailyinv1pv_total = 0L;
                        Long chartdailyinv1solar_total = 0L;
                        Long chartdailyload_total = 0L;
                        Long chartdailypv_total = 0L;
                        Long chartdailysolar_total = 0L;
                        for (Map.Entry<String, HashMap> entry : hashMapData.entrySet()) {
                            HashMap parameterDailyMap = entry.getValue();
                            Object object = parameterDailyMap.get("date");
                            if (object == null) {
                                continue;
                            }

                            Object obj = parameterDailyMap.get("DataDaily");
                            if (obj == null) {
                                continue;
                            }
                            HashMap dataMap = (HashMap) obj;
                            Long chartdailygrid = 0L;
                            Long chartdailyinv1pv = 0L;
                            Long chartdailyinv1solar = 0L;
                            Long chartdailyload = 0L;
                            Long chartdailypv = 0L;
                            Long chartdailysolar = 0L;
                            Object chartdailygrid_obj = dataMap.get("chartdailygrid");
                            if(chartdailygrid_obj != null){
                                chartdailygrid = (Long) chartdailygrid_obj;
                            }
                            Object chartdailyinv1pv_obj = dataMap.get("chartdailyinv1pv");
                            if(chartdailyinv1pv_obj != null){
                                chartdailyinv1pv = (Long) chartdailyinv1pv_obj;
                            }
                            Object chartdailyinv1solar_obj = dataMap.get("chartdailyinv1solar");
                            if(chartdailyinv1solar_obj != null){
                                chartdailyinv1solar = (Long) chartdailyinv1solar_obj;
                            }
                            Object chartdailyload_obj = dataMap.get("chartdailyload");
                            if(chartdailyload_obj != null){
                                chartdailyload = (Long) chartdailyload_obj;
                            }
                            Object chartdailypv_obj = dataMap.get("chartdailypv");
                            if(chartdailypv_obj != null){
                                chartdailypv = (Long) chartdailypv_obj;
                            }
                            Object chartdailysolar_obj = dataMap.get("chartdailysolar");
                            if(chartdailysolar_obj != null){
                                chartdailysolar = (Long) chartdailysolar_obj;
                            }
                            chartdailygrid_total += chartdailygrid;
                            chartdailyinv1pv_total += chartdailyinv1pv;
                            chartdailyinv1solar_total += chartdailyinv1solar;
                            chartdailyload_total += chartdailyload;
                            chartdailypv_total += chartdailypv;
                            chartdailysolar_total += chartdailysolar;
                        }
                        log.info("chartdailygrid_total : {}",chartdailygrid_total);
                        log.info("chartdailyinv1pv_total : {}",chartdailyinv1pv_total);
                        log.info("chartdailyinv1solar_total : {}",chartdailyinv1solar_total);
                        log.info("chartdailyload_total : {}",chartdailyload_total);
                        log.info("chartdailypv_total : {}",chartdailypv_total);
                        log.info("chartdailysolar_total : {}",chartdailysolar_total);

                        Map<String, Object> userUpdates = new HashMap<>();
                        userUpdates.put("chartdailygrid_total", chartdailygrid_total);
                        userUpdates.put("chartdailyinv1pv_total", chartdailyinv1pv_total);
                        userUpdates.put("chartdailyinv1solar_total", chartdailyinv1solar_total);
                        userUpdates.put("chartdailyload_total", chartdailyload_total);
                        userUpdates.put("chartdailypv_total", chartdailypv_total);
                        userUpdates.put("chartdailysolar_total", chartdailysolar_total);
                        refTotal.setValueAsync(userUpdates);

                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                log.error("The read failed: " + databaseError.getCode());
            }
        });

    }

    public void processQueueWeather() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference weatherForecast7Days = database.getReference("WeatherForecast7Days");
        log.info("Start processQueueWeather at {}", new Date());
        final String uri = "https://data.tmd.go.th/api/WeatherForecast7Days/V1/?type=json";

        RestTemplate restTemplate = new RestTemplate();
        WeatherForecast7Days result = restTemplate.getForObject(uri, WeatherForecast7Days.class);
        log.info("WeatherForecast7Days : {}",result);
        weatherForecast7Days.setValueAsync(result);
    }

    public void processQueueWeatherToday() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference WeatherTodayRef = database.getReference("WeatherToday");
        log.info("Start processQueueWeather at {}", new Date());
        final String uri = "https://data.tmd.go.th/api/WeatherToday/V1/?type=json";

        RestTemplate restTemplate = new RestTemplate();
        Object result = restTemplate.getForObject(uri, Object.class);
        log.info("WeatherToday : {}",result);
        WeatherTodayRef.setValueAsync(result);
    }
}
