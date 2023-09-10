package br.com.makersweb.reverse.consumer.infrastructure.api;

import br.com.makersweb.reverse.consumer.infrastructure.reverse.models.ReverseRequest;
import br.com.makersweb.reverse.consumer.infrastructure.reverse.models.ReverseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author aaristides
 */
@RequestMapping(value = "reverses")
@Tag(name = "Reverses")
public interface ReverseAPI {

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Create a new reverse")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created successfully"),
            @ApiResponse(responseCode = "422", description = "A validation error was thrown"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
    })
    ResponseEntity<?> createReverse(@RequestBody ReverseRequest input);

    @GetMapping(
            value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Get a reverse by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reverse retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Reverse was not found"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
    })
    ReverseResponse getById(@PathVariable(name = "id") String id);

    @PutMapping(
            value = "{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Update a reverse by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reverse updated successfully"),
            @ApiResponse(responseCode = "404", description = "Reverse was not found"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
    })
    ResponseEntity<?> updateById(@PathVariable(name = "id") String id, @RequestBody ReverseRequest input);

    @DeleteMapping(
            value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a reverse by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Reverse deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Reverse was not found"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
    })
    void deleteById(@PathVariable(name = "id") String id);

}
