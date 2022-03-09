package com.example.demo.controller;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.StaffDto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.StaffEntity;
import com.example.demo.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;


    @PostMapping("")
    public StaffEntity addStaff(@RequestBody StaffDto staffDto) {
        return staffService.add(staffDto);
    }

    @GetMapping("")
    public List<StaffEntity> getStaffs()  {
        return staffService.fetch();
    }

}
