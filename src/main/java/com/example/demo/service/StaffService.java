package com.example.demo.service;

import com.example.demo.dto.StaffDto;
import com.example.demo.entity.BasketEntity;
import com.example.demo.entity.StaffEntity;
import com.example.demo.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;

    public StaffEntity add(StaffDto request) {
        StaffEntity staff = new StaffEntity();
        staff.setName(request.getName());
        staff.setBasket(new BasketEntity());


        return staffRepository.save(staff);
    }


    public List<StaffEntity> fetch() {
        return (List<StaffEntity>) staffRepository.findAll();
    }
}
