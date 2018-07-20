package org.wizzo.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ChatMessage {

    private String userName;
    private String message;

}
