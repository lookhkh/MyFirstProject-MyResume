package com.example.demo.kakao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@Component
public class KakaoAPI {

	String tokenUrl = "https://kauth.kakao.com/oauth/token";
	String infoUrl = "https://kapi.kakao.com/v2/user/me";
	
	public AccessToken getToken(String code) throws MalformedURLException
	{
		System.out.println(code+"를 받았음. 이걸 이제 토큰으로 변경");
		URL kakaoUrl = new URL(tokenUrl);
		String result="";
		try {
			HttpURLConnection http = (HttpURLConnection) kakaoUrl.openConnection();
			http.setRequestMethod("POST");
			StringBuilder sb = new StringBuilder();
			sb.append("grant_type=authorization_code&");
			sb.append("client_id=5093077e659d1be324b08d877cf40c4b&");
			sb.append("redirect_uri=http://localhost:8085/test/auth&");
			sb.append("code="+code);
			
			http.setDoOutput(true);
			BufferedWriter br = new BufferedWriter(new OutputStreamWriter(http.getOutputStream()));
			
			br.write(sb.toString());
			br.flush();
			
			int status = http.getResponseCode();
			String meg = http.getResponseMessage();
            System.out.println("호출 결과: "+status);
            System.out.println("호출 결과: "+meg);

            BufferedReader re = new BufferedReader(new InputStreamReader(http.getInputStream()));
            
            String line = "";

            
            while((line=re.readLine())!=null) {
            	result+=line;
            }
            
            System.out.println(result);
            
            
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		Gson gson = new Gson();
		AccessToken token=gson.fromJson(result, AccessToken.class);
		System.out.println(token.toString());
		
		
		return token;
		
		
		
	}
	
	public String GettingUserName(AccessToken token) {
		
		String name="";
		
		try {
			URL kakaoUrl = new URL(infoUrl);
			HttpURLConnection http = (HttpURLConnection) kakaoUrl.openConnection();
			http.setRequestMethod("POST");
			http.setRequestProperty("Authorization", "Bearer "+token.getAccess_token());
			http.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			int status = http.getResponseCode();
			String msg = http.getResponseMessage();
			
			System.out.println(status+" 상태번호 "+" 메시지 "+msg);
			//["properties.nickname"]	
			
			String line="";
			
			BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
			
			while((line=br.readLine())!=null) {
				name+=line;
			}
			

			JsonParser parser = new JsonParser();
			JsonElement ele = parser.parse(name);


			JsonObject propertie = ele.getAsJsonObject().get("properties").getAsJsonObject();
			name = propertie.getAsJsonObject().get("nickname").getAsString();
			System.out.println(name);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		return name;
	}
	
	


}
