package com.lsl.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName chat_records
 */
@Data
public class ChatRecords implements Serializable {
    /**
     * 
     */
    private Integer chatRecordsId;

    /**
     * 
     */
    private Date timestamp;

    /**
     * 
     */
    private Integer senderId;

    /**
     * 
     */
    private Integer receiverId;

    /**
     * 
     */
    private String message;

    private static final long serialVersionUID = 1L;
}