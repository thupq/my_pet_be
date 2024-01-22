package com.thupq.mypets.controllers;

import com.thupq.mypets.models.entity.transaction.Transaction;
import com.thupq.mypets.models.request.TransactionRequest;
import com.thupq.mypets.models.response.RestResult;
import com.thupq.mypets.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/i/transaction")
@RequiredArgsConstructor
public class TransactionController extends BaseController {

    private final TransactionService service;

    @PostMapping
    public ResponseEntity<RestResult<Transaction>> createTeacher(@Valid @RequestBody TransactionRequest request) {
        return ResponseEntity.ok(RestResult.ok(service.create(request)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> detail(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(service.getDetails(id));
    }
}
