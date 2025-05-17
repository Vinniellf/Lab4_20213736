package com.example.tele_weather.Model;

import java.util.List;

public class Pronostico {
    private String date;
    private Day day;

    private List<Hora> hour;
    private Location location;
    public String getDate() { return date; }
    public Day getDay() { return day; }
    public Location getLocation() { return location; }

    public List<Hora> getHour() { return hour; }

    public class Day {
        private String maxtemp_c;
        private String mintemp_c;
        private Condition condition;

        public String getMaxtemp_c() { return maxtemp_c; }
        public String getMintemp_c() { return mintemp_c; }
        public Condition getCondition() { return condition; }

        public class Condition {
            private String text;
            private String icon;
            public String getText() { return text; }
            public String getIcon() {return icon;}
        }
    }

}
