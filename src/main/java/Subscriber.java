import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Subscriber implements SubscribeConstants {
    private final String surname;
    private final String name;
    private final String patronymic;
    private final String fullName;
    private final String nickName;

    private String groupSubscriber;
    private final String phoneHouse;
    private final String phoneMobile;
    private final String Email;
    private final String profileSkype;
    private final String index;
    private final String city;
    private final String street;
    private final String numberHouse;
    private final String apartNumber;
    private String datesMaking;
    private String datesLastModification;

    public Subscriber(String[] array) {
        if (array.length == COUNT_ARGS) {
            this.surname = array[0];
            this.name = array[1];
            this.patronymic = array[2];
            this.fullName = defineFullName();
            this.nickName = array[3];
            this.phoneHouse = array[4];
            this.phoneMobile = array[5];
            this.Email = array[6];
            this.profileSkype = array[7];
            this.index = array[8];
            this.city = array[9];
            this.street = array[10];
            this.numberHouse = array[11];
            this.apartNumber = array[12];
            this.datesMaking = datesMaking(new Date());
        } else
            throw new IllegalArgumentException("There are not enough arguments");
    }

    private String defineFullName() {
        StringBuilder sb = new StringBuilder(surname);
        sb.append(" ").append(name.toUpperCase(Locale.ROOT).charAt(0)).append(".")
                .append(patronymic.toUpperCase(Locale.ROOT).charAt(0)).append(".");
        return sb.substring(0);
    }

    public String getAddressString() {
        StringBuilder sb = new StringBuilder();
        sb.append(index).append(' ');
        sb.append(city).append(' ');
        sb.append(", улица ").append(street);
        sb.append(", дом. ").append(numberHouse);
        sb.append(", кв. ").append(apartNumber);
        return sb.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(surname).append(' ');
        sb.append(name).append(' ');
        sb.append(patronymic);
        sb.append(",\nФ.И.О ").append(fullName);
        sb.append(",\nnickName ").append(nickName);
        sb.append(",\nт.дом. ").append(phoneHouse);
        sb.append(",\nмоб. ").append(phoneMobile);
        sb.append(",\nEmail ").append(Email);
        sb.append(",\nSkype ").append(profileSkype);
        sb.append(",\n").append(index);
        sb.append(", г.").append(city);
        sb.append(", ул.'").append(street);
        sb.append(",").append(numberHouse);
        sb.append(", кв. ").append(apartNumber);
        sb.append(",\nдата регистрации ").append(datesMaking);
        return sb.toString();
    }


    private String datesMaking(Date datesMaking) {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        return formatDate.format(datesMaking);

    }


}
