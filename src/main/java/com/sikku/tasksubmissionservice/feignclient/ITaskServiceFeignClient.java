package com.sikku.tasksubmissionservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.sikku.tasksubmissionservice.model.Task;

@Service
@FeignClient(name = "TASK-SERVICE")
public interface ITaskServiceFeignClient {
	
	@GetMapping("/{taskId}")
	public ResponseEntity<Task> getTaskById(@PathVariable Long taskId, @RequestHeader("authorization") String jwtToken)
			throws Exception;
	
	@PutMapping("/{taskId}/complete")
	public ResponseEntity<Task> completeTask(@PathVariable Long taskId, @RequestHeader("authorization") String jwtToken)
			throws Exception;

}
