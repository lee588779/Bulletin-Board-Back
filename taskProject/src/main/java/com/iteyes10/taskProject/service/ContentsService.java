package com.iteyes10.taskProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.iteyes10.taskProject.domain.Contents;
import com.iteyes10.taskProject.repository.ContentsRepository;

@Service
public class ContentsService {

    @Autowired
    ContentsRepository repository;

    public Page<Contents> get_contents_list(String type, int page) {
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(Sort.Order.desc("regdt"));
        Pageable pageable = PageRequest.of(page, 20, Sort.by(orders));
        return repository.findByType(pageable, type);
    }

    public Contents get_detail(int cid) {
        Optional<Contents> tmp = repository.findById(cid);
        if(tmp.isPresent()) {
            return tmp.get();
        }
        return null;
    }
}
