package com.lab.person.onboarding.adapter.controller.base;

import com.lab.person.onboarding.infrastructure.entity.TransactionEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/transaction/v1")
public interface ITransactionController {

    @Operation(summary = "Get transaction from database")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Return Transaction from database",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = TransactionEntity.class))})})
    @GetMapping(value =  "/{transactionId}")
    public TransactionEntity getTransactionById(@PathVariable String transactionId);

    @Operation(summary = "Insert transaction at database")
    @ApiResponses(value = {@ApiResponse (responseCode ="201", description = "Return inserted data",
            content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TransactionEntity.class))}) })
    @PostMapping()
    public TransactionEntity postTransaction(TransactionEntity transactionEntity);

    @Operation(summary = "Delete transaction from database")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "Transaction deleted from database")})
    @DeleteMapping(value = "/{transaction}" )
    public ResponseEntity<Object> deleteTransaction(@PathVariable String transactionId);
}
