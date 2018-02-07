package com.example.searchjpa;

import com.example.searchjpa.model.Users;
import org.apache.commons.lang.RandomStringUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
public class MainCreate {
    public static void main(String[] args) {
        createUser();
    }
   static List<String> arrayString = Arrays.asList("Amsterdam", "Andorra", "Athens", "Belfast", "Belgrade", "Berlin", "Bratislava", "Brussels", "Bucharest", "Budapest", "Chisinau", "Copenhagen", "Dublin", "Gibraltar", "Guernsey", "Helsinki", "Isle_of_Man", "Istanbul", "Jersey", "Kaliningrad", "Kiev", "Lisbon", "Ljubljana", "London", "Luxembourg", "Madrid", "Malta", "Mariehamn", "Minsk", "Monaco", "Moscow", "Nicosia", "Oslo", "Paris", "Podgorica", "Prague", "Riga", "Rome", "Samara", "San_Marino", "Sarajevo", "Simferopol", "Skopje", "Sofia", "Stockholm", "Tallinn", "Tirane", "Tiraspol", "Uzhgorod", "Vaduz", "Vatican", "Vienna", "Vilnius", "Volgograd", "Warsaw", "Zagreb", "Zaporozhye", "Zurich", "Adelaide", "Brisbane", "Broken_Hill", "Currie", "Darwin", "Eucla", "Hobart", "Lindeman", "Lord_Howe", "Melbourne", "Perth", "Sydney", "Abidjan", "Accra", "Addis_Ababa", "Algiers", "Asmara", "Bamako", "Bangui", "Banjul", "Bissau", "Blantyre", "Brazzaville", "Bujumbura", "Cairo", "Casablanca", "Ceuta", "Conakry", "Dakar", "Dar_es_Salaam", "Djibouti", "Douala", "El_Aaiun", "Freetown", "Gaborone", "Harare", "Johannesburg", "Juba", "Kampala", "Khartoum", "Kigali", "Kinshasa", "Lagos", "Libreville", "Lome", "Luanda", "Lubumbashi", "Lusaka", "Malabo", "Maputo", "Maseru", "Mbabane", "Mogadishu", "Monrovia", "Nairobi", "Ndjamena", "Niamey", "Nouakchott", "Ouagadougou", "Porto-Novo", "Sao_Tome", "Timbuktu", "Tripoli", "Tunis", "Windhoek", "Aden", "Almaty", "Amman", "Anadyr", "Aqtau", "Aqtobe", "Ashgabat", "Ashkhabad", "Baghdad", "Bahrain", "Baku", "Bangkok", "Beirut", "Bishkek", "Brunei", "Choibalsan", "Chongqing", "Chungking", "Colombo", "Damascus", "Dhaka", "Dili", "Dubai", "Dushanbe", "Gaza", "Harbin", "Hebron", "Ho_Chi_Minh", "Hong_Kong", "Hovd", "Irkutsk", "Istanbul", "Jakarta", "Jayapura", "Jerusalem", "Kabul", "Kamchatka", "Karachi", "Kashgar", "Kathmandu", "Kolkata", "Krasnoyarsk", "Kuala_Lumpur", "Kuching", "Kuwait", "Macau", "Magadan", "Makassar", "Manila", "Muscat", "Nicosia", "Novokuznetsk", "Novosibirsk", "Omsk", "Oral", "Phnom_Penh", "Pontianak", "Pyongyang", "Qatar", "Qyzylorda", "Rangoon", "Riyadh", "Saigon", "Sakhalin", "Samarkand", "Seoul", "Shanghai", "Singapore", "Taipei", "Tashkent", "Tbilisi", "Tehran", "Tel_Aviv", "Thimphu", "Tokyo", "Ulan_Bator", "Urumqi", "Vientiane", "Vladivostok", "Yakutsk", "Yekaterinburg", "Yerevan", "Casey", "Davis", "DumontDUrville", "Macquarie", "Mawson", "McMurdo", "Palmer", "Rothera", "South_Pole", "Syowa", "Vostok", "Antananarivo", "Chagos", "Christmas", "Cocos", "Comoro", "Kerguelen", "Mahe", "Maldives", "Mauritius", "Mayotte", "Reunion", "Azores", "Bermuda", "Canary", "Cape_Verde", "Faroe_Islands", "Jan_Mayen", "Madeira", "Reykjavik", "South_Georgia", "St_Helena", "Stanley", "Apia", "Auckland", "Chatham", "Chuuk_Lagoon", "Easter", "Efate", "Enderbury", "Fakaofo", "Fiji", "Funafuti", "Galapagos", "Gambier", "Guadalcanal", "Guam", "Honolulu", "Johnston", "Kiritimati", "Kosrae", "Kwajalein", "Majuro", "Marquesas", "Midway", "Nauru", "Niue", "Norfolk", "Noumea", "Pago_Pago", "Palau", "Pitcairn", "Pohnpei", "Ponape", "Port_Moresby", "Rarotonga", "Saipan", "Samoa", "Tahiti", "Tarawa", "Tongatapu", "Wake", "Wallis", "Yap", "Adak", "Anchorage", "Anguilla", "Antigua", "Araguaina", "Argentina/Buenos_Aires", "Argentina/Catamarca", "Argentina/Comodoro_Rivadavia", "Argentina/Cordoba", "Argentina/Jujuy", "Argentina/La_Rioja", "Argentina/Mendoza", "Argentina/Rio_Gallegos", "Argentina/Salta", "Argentina/San_Juan", "Argentina/San_Luis", "Argentina/Tucuman", "Argentina/Ushuaia", "Aruba", "Asuncion", "Atikokan", "Atka", "Bahia", "Bahia_Banderas", "Barbados", "Belem", "Belize", "Blanc-Sablon", "Boa_Vista", "Bogota", "Boise", "Brasilia", "Cambridge_Bay", "Campo_Grande", "Cancun", "Caracas", "Cayenne", "Cayman", "Chicago", "Chihuahua", "Coral_Harbour", "Costa_Rica", "Creston", "Cuiaba", "Curacao", "Danmarkshavn", "Dawson", "Dawson_Creek", "Denver", "Detroit", "Dominica", "Edmonton", "Eirunepe", "El_Salvador", "Ensenada", "Fort_Wayne", "Fortaleza", "Glace_Bay", "Godthab", "Goose_Bay", "Grand_Turk", "Grenada", "Guadeloupe", "Guatemala", "Guayaquil", "Guyana", "Halifax", "Havana", "Hermosillo", "Indiana/Indianapolis", "Indiana/Knox", "Indiana/Marengo", "Indiana/Petersburg", "Indiana/Tell_City", "Indiana/Vevay", "Indiana/Vincennes", "Indiana/Winamac", "Indianapolis", "Inuvik", "Iqaluit", "Jamaica", "Juneau", "Kentucky/Louisville", "Kentucky/Monticello", "Knox_IN", "Kralendijk", "La_Paz", "Lima", "Los_Angeles", "Louisville", "Lower_Princes", "Maceio", "Managua", "Manaus", "Marigot", "Martinique", "Matamoros", "Mazatlan", "Menominee", "Merida", "Metlakatla", "Mexico_City", "Miquelon", "Moncton", "Monterrey", "Montevideo", "Montreal", "Montserrat", "Nassau", "New_York", "Nipigon", "Nome", "Noronha", "North_Dakota/Beulah", "North_Dakota/Center", "North_Dakota/New_Salem", "Ojinaga", "Panama", "Pangnirtung", "Paramaribo", "Phoenix", "Port-au-Prince", "Port_of_Spain", "Porto_Acre", "Porto_Velho", "Puerto_Rico", "Rainy_River", "Rankin_Inlet", "Recife", "Regina", "Resolute", "Rio_Branco", "Rosario", "Santa_Isabel", "Santarem", "Santiago", "Santo_Domingo", "Sao_Paulo", "Scoresbysund", "Shiprock", "Sitka", "St_Barthelemy", "St_Johns", "St_Kitts", "St_Lucia", "St_Thomas", "St_Vincent", "Swift_Current", "Tegucigalpa", "Thule", "Thunder_Bay", "Tijuana", "Toronto", "Tortola", "Vancouver", "Virgin", "Whitehorse", "Winnipeg", "Yakutat", "Yellowknife");

    public static void createUser() {
        System.out.println("Runnable running");
        int n = 3300000;
        int i = 0;
        StringBuilder stringBuilder=new StringBuilder();
        while (i <= n) {
            Users users = new Users();
            String lastname = RandomName();
            String firstname = RandomName();
            String email = RandomName()+RandomString(4) + "@gmail.com";
            String pass = RandomString(10);
            String mobile = randomNumber(10);
            users.setLastname(lastname);
            users.setFirstname(firstname);
            users.setUsername(lastname + firstname);
            users.setAddress(RandomString(13));
            users.setCity(RandomName() + RandomString(2));
            users.setDateCreate(new Date());
            users.setBirthday(new Date() + "");
            users.setMobile(mobile);
            users.setEmail(email);
            users.setSex("male");
            users.setPassword(pass);
            users.setState(RandomString(2) + RandomName() + RandomString(2));
            stringBuilder
                    .append("insert into users (address, birthday, city," +
                            "date_create, email, firstname, lastname, mobile, " +
                            "password, sex, state, username) " +
                            "values ('"+users.getAddress()+"', '2018-01-31 15:58:34', '"+users.getCity()+"', '2018-01-31 15:58:34', '"+users.getEmail()+"', '"+users.getFirstname()+"', '"+users.getLastname()+"', '"+users.getMobile()+"', '"+users.getPassword()+"', '"+users.getSex()+"', '"+users.getState()+"', '"+users.getUsername()+"');"
                    );
            i++;
            System.out.println(i);
        }
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("myfile.sql", true)));
            out.println(stringBuilder);
            out.close();
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    private static String RandomName() {
        Random random = new Random();
            return arrayString.get(random.nextInt(30));
    }

    private static String RandomString(int length) {
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        return generatedString;
    }

    private static String randomNumber(int length) {
        Random random = new Random();
        return "" + random.nextInt(2000000000);
    }
}
