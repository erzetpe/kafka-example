package org.wizzo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class ChatMessage {

    private String userName;
    private String message;

}
