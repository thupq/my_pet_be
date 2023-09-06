package com.thupq.mypets.controllers;

import com.thupq.mypets.models.request.UserRequest;
import com.thupq.mypets.models.request.UserSearchRequest;
import com.thupq.mypets.models.response.RestResult;
import com.thupq.mypets.models.response.UserResponse;
import com.thupq.mypets.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController extends BaseController {
    private final UserService userService;

    @Operation(summary = "Create a users")
    @PostMapping
    public ResponseEntity<RestResult<UserResponse>> createTeacher(@Valid @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(RestResult.ok(userService.create(userRequest)));
    }

    @Operation(summary = "Get detail of a user")
    @GetMapping("/{id}")
    public ResponseEntity<RestResult<UserResponse>> detail(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(RestResult.ok(userService.getDetails(id)));
    }

    @Operation(summary = "Update a teacher info")
    @PutMapping("/{id}")
    public ResponseEntity<RestResult<UserResponse>> update(@PathVariable("id") Long id, @Valid @RequestBody UserRequest userUpdateRequest) {
        return ResponseEntity.ok(RestResult.ok(userService.update(id,userUpdateRequest)));
    }

    @Operation(summary = "Get user list with filter supported")
    @PostMapping("/search")
    public ResponseEntity<RestResult<Page<UserResponse>>> search(@RequestBody UserSearchRequest userSearchRequest, Pageable pageable) {
        log.debug("REST request to search Teacher : {}", userSearchRequest);
        return ResponseEntity.ok(RestResult.ok(userService.searchUser(userSearchRequest, pageable)));
    }
}
