package com.example.capstoneWeb.Flask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FlaskController {
	private static final Logger logger = LoggerFactory.getLogger(FlaskController.class);
	private final RestTemplate restTemplate = new RestTemplate();

	@PostMapping("/news/predict")
	public String callPythonApi(@RequestParam("userCode") String userCode) {
		String apiUrl = "http://127.0.0.1:5001/predict";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// JSON 문자열 형태로 직접 구성
		String requestJson = "{\"text\":\"" + userCode + "\"}";

		HttpEntity<String> request = new HttpEntity<>(requestJson, headers);

		try {
			String result = restTemplate.postForObject(apiUrl, request, String.class);
			logger.info("Flask API 응답 값: {}", result);
			return result;
		} catch (Exception e) {
			logger.error("Flask API 호출 중 오류 발생", e);
			return "Flask API 호출 실패";
		}
	}
}
