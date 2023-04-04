package com.snva.soap.endpoints;

import com.snva.ex.soap.xml.bootcamp.Bootcamp;
import com.snva.ex.soap.xml.bootcamp.GetBootcampRequest;
import com.snva.ex.soap.xml.bootcamp.GetBootcampResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BootcampEndpoint {



    private  static  final String  NAMSPACE_URL= "http://snva.com/ex/soap/xml/bootcamp";



    @PayloadRoot(namespace = NAMSPACE_URL, localPart = "getBootcampRequest")
    @ResponsePayload

    public GetBootcampResponse getBootcamp (@RequestPayload GetBootcampRequest request){

        GetBootcampResponse response =  new GetBootcampResponse();
        Bootcamp bcamp = new Bootcamp();
        bcamp.setBootcampName(request.getBootcampName());
        bcamp.setDetails("This is the test data later we will connact mongodb here");
        bcamp.setInstructor("Viet");
        response.setBootcamp(bcamp);
        return response;
    }
}
