package com.company.homework2.immutable;

import java.util.Date;

public final  class ImmutablePerson {
        private final String name;
        private final int age;
        private final String colorEye;
        private final Date birthDay;

        public ImmutablePerson(String name, int age, String colorEye, Date birthDay) {
            this.name = name;
            this.age = age;
            this.colorEye = colorEye;
            this.birthDay = new Date(birthDay.getTime());
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getColorEye() {
            return colorEye;
        }

        public Date getBirthDay() {
            return new Date(birthDay.getTime());
        }

        @Override
        public String toString() {
            return "name='" + name + '\'' +
                    ", age=" + age +
                    ", colorEye='" + colorEye + '\'' +
                    ", birthDay=" + birthDay;
        }
}
