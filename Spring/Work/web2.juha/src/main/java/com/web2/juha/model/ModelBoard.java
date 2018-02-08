package com.web2.juha.model;

public class ModelBoard {
    
    private String board_id    ; // `board_id` VARCHAR(50) NOT NULL,
    private String board_title ; // `board_title` VARCHAR(50) NOT NULL,

    public String getBoard_id() {
        return board_id;
    }

    public void setBoard_id(String board_id) {
        this.board_id = board_id;
    }

    public String getBoard_title() {
        return board_title;
    }

    public void setBoard_title(String board_title) {
        this.board_title = board_title;
    }

    public ModelBoard() {
        super();
    }

    public ModelBoard(String board_id, String board_title) {
        super();
        this.board_id = board_id;
        this.board_title = board_title;
    }

    @Override
    public String toString() {
        return "ModelBoard [board_id=" + board_id + ", board_title=" + board_title + "]";
    }
}
