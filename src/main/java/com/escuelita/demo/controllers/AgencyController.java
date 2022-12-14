package com.escuelita.demo.controllers;
import com.escuelita.demo.controllers.dtos.requests.CreateAgencyRequest;
import com.escuelita.demo.controllers.dtos.requests.UpdateAgencyRequest;
import com.escuelita.demo.controllers.dtos.responses.BaseResponse;
import com.escuelita.demo.controllers.dtos.responses.GetAgencyResponse;
import com.escuelita.demo.services.interfaces.IAgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("agency")
public class AgencyController {
@Autowired
private IAgencyService service;

    @GetMapping
    public ResponseEntity<BaseResponse> list(){
        BaseResponse baseResponse =  service.list();
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }
    @GetMapping("{id}")
    public  ResponseEntity<BaseResponse> get(@PathVariable Long id){
        BaseResponse baseResponse =  service.get(id);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());    }
    @PostMapping
    public  ResponseEntity<BaseResponse> create(@RequestBody CreateAgencyRequest request){
        BaseResponse baseResponse =  service.create(request);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }
   @PutMapping("{id}")
    public ResponseEntity<BaseResponse> update(@PathVariable Long id, @RequestBody UpdateAgencyRequest request){
       BaseResponse baseResponse =  service.update(id,request);
       return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }
    @DeleteMapping ("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}