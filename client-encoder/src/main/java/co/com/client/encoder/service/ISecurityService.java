package co.com.client.encoder.service;

import co.com.client.encoder.dtos.Request;
import co.com.client.encoder.dtos.Response;

public interface ISecurityService {

    Response encrypt(Request request);

}