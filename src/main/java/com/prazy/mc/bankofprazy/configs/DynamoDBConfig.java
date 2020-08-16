package com.prazy.mc.bankofprazy.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDBConfig {
	
	@Value("${amazon.access.key}")
	private String awsAccessKey;
	
	@Value("${amazon.access.secret-key}")
	private String awsSecretKey;
	
	@Value("${amazon.region}")
	private String awsRegion;
	
	@Value("${amazon.end-point.url}")
	private String awsDynamoDbEndpoint;
	
	@Bean
	public DynamoDBMapper mapper() {
		return new DynamoDBMapper(amazonDynamoDBConfig());		
	}
	
	public AmazonDynamoDB amazonDynamoDBConfig() {
		
		AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
			.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(awsDynamoDbEndpoint, awsRegion))
			.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey)))
			.build();
		
		return amazonDynamoDB;
	}

	@Override
	public String toString() {
		return "DynamoDBConfig [awsAccessKey=" + awsAccessKey + ", awsSecretKey=" + awsSecretKey + ", awsRegion="
				+ awsRegion + ", awsDynamoDbEndpoint=" + awsDynamoDbEndpoint + "]";
	}
	
}