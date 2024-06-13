package com.springboot.employee.daos;

import lombok.Getter;
import lombok.Setter;

/**
 * @author prabhakar, @Date 13-06-2024
 */
@Setter
@Getter
public class SearchRequest {

    private String firstName;
    private String lastName;
    private String email;


}
