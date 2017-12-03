package com.anb.amrapalinoticeboard;

/**
 * Created by dipanker on 29/08/17.
 */

public class only_text_Data {
    private String title;
    private String msg;
    private String faculty;

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public only_text_Data(String title, String msg,String faculty) {
        this.setMsg(msg);
        this.setTitle(title);
        this.setFaculty(faculty);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
