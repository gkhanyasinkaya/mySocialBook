import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DateFormatter {
    public String DateToString(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String strDate = formatter.format(date);
        return strDate;
    }
    public Date StringToDate(String strDate){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        try {

            Date date = formatter.parse(strDate);
            formatter.format(date);
            return date;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Date GetDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return date;
    }

    }

