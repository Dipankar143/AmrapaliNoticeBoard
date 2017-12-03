package com.anb.amrapalinoticeboard;

/**
 * Created by dipanker on 19/08/17.
 */

public class Data {

    public String url;
    public long time;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Data(String url,Long time) {
        this.setUrl(url);
        this.setTime(time);
    }



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
