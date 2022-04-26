package com.example.nic.nic.Service;

import com.example.nic.nic.Controller.FarpsReportingProducerController;
import com.example.nic.nic.Model.FarpsReportingUpdateConsumer;
import com.example.nic.nic.Repository.FarpsReportingConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FarpsReportingConsumerService {

    @Autowired
    private FarpsReportingProducerController farpsReportingProducerController;

    @Autowired
    private FarpsReportingConsumerRepository repository;

    @PersistenceContext
    private EntityManager entityManager;


//    @ResponseBody
//    public String updateRecordsLessThanUpdatedDate() {
//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        Request request = new Request.Builder()
//                .url("http://localhost:8080/updateDate?date=2022-04-16")
//                .method("GET", null)
//                .addHeader("date", "2022-04-06")
//                .build();
//        Response response = client.newCall(request).execute();
//    }

    @ResponseBody
    public String updateRecordsLessThanUpdatedDate() {
        String queryStr = "select max(maindb) from farps_reporting_update_consumer ";
        Query query = entityManager.createNativeQuery(queryStr);
        List<Object[]> result = (List<Object[]>) query.getResultList();

        Date now = new Date();
        for (Object obj : result) {
            now = (Date)(obj);
        }

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String strDate = format.format(now);
//        List<Object[]> list = farpsReportingProducerController.updateDate(strData);

        HttpURLConnection connection = null;

        try{
            String urlString = "http://localhost:8080/updateDate?date="+strDate;
            if(urlString.contains(" ")){
                urlString = urlString.replace(" ", "%20");
            }
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod( "GET" );

            int responseCode = connection.getResponseCode();

            System.out.println("GET Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println(response.toString());
                connection.disconnect();
                return response.toString();
            } else {
                System.out.println("GET request not worked");
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(connection != null){
                connection.disconnect();
            }
        }
//        insertData(list);
        return "";
    }

    public void insertData(List<Object[]> list){
        for (Object[] obj: list) {
            FarpsReportingUpdateConsumer updateConsumer = new FarpsReportingUpdateConsumer();
            updateConsumer.setEmpCode((int)obj[1]);
            updateConsumer.setRepCode((int)obj[2]);
            updateConsumer.setMainDB((Date)obj[3]);
            updateConsumer.setUpdatedAt(new Date());
            repository.save(updateConsumer);
        }
    }
}
