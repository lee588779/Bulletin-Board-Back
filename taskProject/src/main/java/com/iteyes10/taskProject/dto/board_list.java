package com.iteyes10.taskProject.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import com.iteyes10.taskProject.domain.Contents;

import lombok.Data;

@Data
public class board_list {
    List<list_data> list;
    int max_page;

    public board_list(Page<Contents> page) {
        this.max_page = page.getTotalPages();
        this.list = new ArrayList<>();
        List<Contents> pages = page.getContent();
        for(Contents tmp : pages) {
            this.list.add(contents_to_data(tmp));
        }
    }

    private list_data contents_to_data(Contents contents) {
        return new list_data(contents.getCid(),contents.getTitle(),contents.getUid(),contents.getRegdt());
    }
}
