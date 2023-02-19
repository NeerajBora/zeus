package com.walmart.zeus.resource;

import com.walmart.zeus.dto.TaskDTO;
import com.walmart.zeus.dto.TaskDetailsDTO;
import com.walmart.zeus.dto.TenantDTO;
import com.walmart.zeus.service.ZeusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/zeus")
public class ZeusResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(ZeusResource.class);

    @Autowired
    ZeusService zeusService;

    @PostMapping(value = {"/registerTenant"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerTenant(@RequestBody TenantDTO tenant) {
        LOGGER.info("[registerTenant] Tenant registration start for: {}", tenant);
        Instant start = Instant.now();
        zeusService.registerTenant(tenant);
        Instant end = Instant.now();
        LOGGER.info("Time taken to for publishEvents api execution: {} ms",
                Duration.between(start, end).toMillis());
        return ResponseEntity.ok("Event Successfully published");
    }

    @GetMapping(value = {"/taskList/{app}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaskDTO>> getApprovalsTaskList(@PathVariable("app") String app) {

        Instant start = Instant.now();
        List<TaskDTO> taskList = zeusService.fetchApprovaltaskList(app);
        Instant end = Instant.now();
        LOGGER.info("Time taken to for getApprovalsTaskList api execution: {} ms",
                Duration.between(start, end).toMillis());
        return ResponseEntity.ok(taskList);
    }

    @GetMapping(value = {"/taskDetails/{taskID}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDetailsDTO> getTaskDetails(@PathVariable("taskID") String taskID) {

        Instant start = Instant.now();
        TaskDetailsDTO taskDetailsDTO = zeusService.fetchtaskDetails(taskID);
        Instant end = Instant.now();
        LOGGER.info("Time taken to for getTaskDetails api execution: {} ms",
                Duration.between(start, end).toMillis());
        return ResponseEntity.ok(taskDetailsDTO);
    }


    //need to discuss on this
    @PostMapping(value = {"/events/{event}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> publishEvents(@PathVariable("event") String event) {

        Instant start = Instant.now();
        zeusService.trigerButtonEvents(event);
        Instant end = Instant.now();
        LOGGER.info("Time taken to for publishEvents api execution: {} ms",
                Duration.between(start, end).toMillis());
        return ResponseEntity.ok("Event Successfully published");
    }

}
