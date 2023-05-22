package com.microprac.springrabbitmqconsumer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMessage {

    private String messageId;

    private String message;

    private Date messageDate;

}
