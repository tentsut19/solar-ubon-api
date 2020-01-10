package th.co.solar.solarapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.co.solar.solarapi.scheduler.QueueScheduler;
import th.co.solar.solarapi.service.ConsumerService;

@RestController
@RequestMapping("/api/v1/")
@Slf4j
@CrossOrigin(origins = "*")
public class ProcessController {

    @Autowired
    ConsumerService consumerService;

    @GetMapping(value = "/processQueueTotal", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity.BodyBuilder processQueueTotal() {
        consumerService.processQueueTotal();
        return ResponseEntity.ok();
    }

}

