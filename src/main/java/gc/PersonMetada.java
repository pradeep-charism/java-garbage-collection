package gc;

import java.util.Date;

public class PersonMetada {
    Date date;

    public PersonMetada() {
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "PersonMetada{" +
                "date=" + date +
                '}';
    }
}
