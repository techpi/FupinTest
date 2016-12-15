package cn.techpi.fupintest;

/**
 * Created by chaxin on 2016/12/14.
 */

public class Message {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public long getAddtime() {
        return addtime;
    }

    public void setAddtime(long addtime) {
        this.addtime = addtime;
    }

    private String title;
    private String uname;
    private long addtime;
}
