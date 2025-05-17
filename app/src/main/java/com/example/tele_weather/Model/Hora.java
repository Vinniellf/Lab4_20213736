package com.example.tele_weather.Model;

public class Hora {
    public String time;
    public String temp_c;
    public Condition condition;

    public String chance_of_rain;

    public String getTime() { return time; }
    public String getTemp_c() { return temp_c; }
    public Condition getCondition() { return condition; }

    public String getChance_of_rain() { return chance_of_rain; }

    public class Condition {
        private String text;
        private String icon;
        public String getText() { return text; }
        public String getIcon() {return icon;}
    }
}
