package set003.entities;

import java.util.Date;
import java.util.Objects;

public class LogEntry {

    protected String user;
    protected Date moment;

    public LogEntry(String user, Date moment) {
        this.user = user;
        this.moment = moment;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogEntry logEntry = (LogEntry) o;
        return Objects.equals(user, logEntry.user);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(user);
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "user='" + user + '\'' +
                ", moment=" + moment +
                '}';
    }
}
