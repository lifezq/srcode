package com.record.srcode.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("user")
@Data
public class User {
    @Value("1")
    private Long id;

    @Value("user_name_1")
    private String userName;

    @Value("note_1")
    private String note;
}
