package com.lab.person.onboarding.adapter.controller.base;

import com.lab.person.onboarding.infrastructure.entity.TransactionEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/download/v1")
public interface ITransactionDownloadController{

    @Operation(summary = "Get all transactions by document from database")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Return all transaction from database",
            content = {@Content(mediaType= "csv", schema = @Schema(implementation = TransactionEntity.class))})})

    @GetMapping(value = "/{}")
    public TransactionEntity getAll(@PathVariable String document);
}