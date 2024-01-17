package com.cbfacademy.restapiexercise.ious;

import com.cbfacademy.restapiexercise.core.ApiErrorResponse;
import com.cbfacademy.restapiexercise.core.IOUNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/ious")
public class IOUController {

    private final IOUService iouService;

    @Autowired
    public IOUController(IOUService iouService) {
        this.iouService = iouService;
    }

    @GetMapping
    public ResponseEntity<List<IOU>> getAllIOUs() {
        return new ResponseEntity<>(iouService.getAllIOUs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IOU> getIOUById(@PathVariable UUID id) {
        IOU iou = iouService.getIOU(id);
        if (iou == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(iou, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<IOU> addIOU(@RequestBody IOU iou) {
        return new ResponseEntity<>(iouService.createIOU(iou), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IOU> updateIOU(@PathVariable UUID id, @RequestBody IOU iou) {
        IOU updatedIOU = iouService.updateIOU(id, iou);
        if (updatedIOU == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedIOU, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIOU(@PathVariable UUID id) {
        iouService.deleteIOU(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(IOUNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleNotFound(IOUNotFoundException ex) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}