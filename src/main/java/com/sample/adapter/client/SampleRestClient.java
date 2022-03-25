package com.sample.adapter.client;

import java.util.Collections;

import com.sample.model.CommonResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SampleRestClient {

	@Autowired
	RestTemplate restTemplate;

	// public static final String URL =
	// "http://webservice.recruit.co.jp/hotpepper/gourmet/v1/?key=01ae4aacad59cfae&large_area=Z011&format=json&type=lite";
	public static final String URL = "https://jsonplaceholder.typicode.com/todos/1";

	public CommonResponse getTestResponse() {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		// headers.setContentType(new MediaType("text", "json",
		// Charset.forName("utf-8")));
		HttpEntity<Void> request = new HttpEntity<>(headers);

		// return restTemplate.getForObject(URL, CommonResponse.class, request);

		ResponseEntity<CommonResponse> res = restTemplate.exchange(
				URL,
				HttpMethod.GET,
				request,
				CommonResponse.class);

		return res.getBody();
	}

}