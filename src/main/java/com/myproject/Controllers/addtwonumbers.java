package com.myproject.Controllers;

import com.myproject.Entitiy.twoNumber;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class addtwonumbers {
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @CrossOrigin
    public ResponseEntity<String> add(@RequestBody twoNumber number)
    {
       Logger l= Logger.getLogger("");
       l.info("add mehtod started");
        int sum=-1;
        ResponseEntity<String> responseEntity;
        try
        {
            sum=number.getFirstnumber()+number.getSecondnumber();
            responseEntity=  new ResponseEntity<String>("{\"sum\":"+sum+"}", HttpStatus.OK);
        }
        catch (Exception e)
        {
            l.warning("add mehtod started");
            responseEntity=  new ResponseEntity<String>("{data:'OOOPS!'} "+e.getMessage(), HttpStatus.BAD_REQUEST);

        }
        l.info("add mehtod started");
        return responseEntity;
    }
    @RequestMapping("/home")
    @CrossOrigin
    public String home()
    {
        return  "hello! this is home webservice.In spring boot add two number app....!!!!";
    }

}
