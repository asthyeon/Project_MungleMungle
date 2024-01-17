package com.munggle.openAPI.controller;

import com.munggle.openAPI.service.OpenAPIService;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@RestController
@RequestMapping("/openapi")
@RequiredArgsConstructor
public class OpenAPIController {

    private final OpenAPIService openAPIService;

    @Value("${api.serviceKey}")
    private String serviceKey_en;

    // 동물보호관리시스템 유기동물 정보 조회 서비스 URL
    @Value("${api.abandoned}")
    private String abandonedUrl;
    @Value("${api.lostDog}")
    private String lostDogUri;
    @Value("${api.kind}")
    private String kindUri;

    // 품종 정보 요청
    @GetMapping("/kind")
    public void kind() throws IOException, ParseException {

        StringBuilder urlBuilder = new StringBuilder(abandonedUrl); /*URL*/
        urlBuilder.append(kindUri);
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey_en); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("up_kind_cd","UTF-8") + "=" + URLEncoder.encode("417000", "UTF-8")); /*축종코드 (개 : 417000, 고양이 : 422400, 기타 : 429900) (입력 시 데이터 O, 미입력 시 데이터 X)*/
        urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*xml(기본값) 또는 json*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        System.out.println(sb.toString());
        // DB에 저장
        openAPIService.insertKind(sb.toString());
    }

    // 유기 동물 정보 요청
    @GetMapping("/lostdog")
    public void lostDog() throws IOException, ParseException {

        Long totalCnt = -1L;
        Long pageNo = 0L;
        int numOfRows = 1000;

        long beforeTime = System.currentTimeMillis();
        do {
            // 페이지 번호를 증가시키며 전체 데이터 DB에 저장
            pageNo++;

            StringBuilder urlBuilder = new StringBuilder(abandonedUrl); /*URL*/
            urlBuilder.append(lostDogUri);
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey_en); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("upkind", "UTF-8") + "=" + URLEncoder.encode("417000", "UTF-8")); /*축종코드 (개 : 417000, 고양이 : 422400, 기타 : 429900)*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + pageNo); /*페이지 번호 (기본값 : 1)*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + numOfRows); /*페이지당 보여줄 개수 (1,000 이하), 기본값 : 10*/
            urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*xml(기본값) 또는 json*/

            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            System.out.println("Response code: " + conn.getResponseCode());
            BufferedReader rd;
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
            }
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            rd.close();
            conn.disconnect();

            // 중간에 totalCnt가 바뀔수도 있으니까 그때마다 갱신되어도 ok
            totalCnt = openAPIService.insertLostDog(sb.toString());

            // totalCount에 따라서 요청을 반복
        } while (numOfRows * pageNo < totalCnt);

        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);
    }

}
