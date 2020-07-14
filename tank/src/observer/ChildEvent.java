package observer;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 10:13 AM
 * @Description: observer
 * decouple Source  and observers
 * @version: 1.0
 */
public class ChildEvent {
    private long when;
    private String where;
    private Child source;

    public ChildEvent(long when, String where, Child source) {
        this.when = when;
        this.where = where;
        this.source = source;
    }


    public long getWhen() {
        return when;
    }

    public void setWhen(long when) {
        this.when = when;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public Child getSource() {
        return source;
    }

    public void setSource(Child source) {
        this.source = source;
    }
}
