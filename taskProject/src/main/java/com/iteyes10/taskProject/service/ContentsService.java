package com.iteyes10.taskProject.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.iteyes10.taskProject.domain.Contents;
import com.iteyes10.taskProject.dto.board_list;
import com.iteyes10.taskProject.dto.update_data;
import com.iteyes10.taskProject.dto.write_data;
import com.iteyes10.taskProject.repository.ContentsRepository;

import jakarta.transaction.Transactional;

@Service
public class ContentsService {

    @Autowired
    ContentsRepository repository;

    public board_list get_contents_list(String type, int page) {
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(Sort.Order.desc("regdt"));
        Pageable pageable = PageRequest.of(page, 20, Sort.by(orders));
        return new board_list(repository.findByType(pageable, type));
    }

    public Contents get_detail(int cid) {
        Optional<Contents> tmp = repository.findById(cid);
        if(tmp.isPresent()) {
            return tmp.get();
        }
        return null;
    }

    public boolean contents_delete(int cid, String uid) {
        Optional<Contents> tmp = repository.findById(cid);
        if(tmp.isPresent()) {
            Contents ct = tmp.get();
            if(ct.getUid().equals(uid)) {
                repository.deleteById(cid);
                return true;
            }
        }
        return false;
    }

    @Transactional
    public Contents contents_update(update_data data, String uid) {
        Optional<Contents> tmp = repository.findById(data.getId());
        if(tmp.isPresent()) {
            Contents update = tmp.get();
            if(!update.getUid().equals(uid))
                return null;
            update.setText(data.getText());
            update.setTitle(data.getTitle());
            update.setRegdt(LocalDate.now());
            return update;
        }
        return null;
    }

    @Transactional
    public Contents contents_write(write_data data, String uid) {
        return new Contents(data, uid);
    }
}
