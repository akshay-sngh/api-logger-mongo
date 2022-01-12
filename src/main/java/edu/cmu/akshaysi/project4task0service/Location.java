package edu.cmu.akshaysi.project4task0service;

public class Location {
        private String name;
        private double no;
        private double yes;

    public Location(String name, double yes, double no) {
        this.name = name;
        this.yes = yes;
        this.no = no;
    }

    public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getNo() {
            return no;
        }

        public void setNo(double no) {
            this.no = no;
        }

        public double getYes() {
            return yes;
        }

        public void setYes(double yes) {
            this.yes = yes;
        }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", no=" + no +
                ", yes=" + yes +
                '}';
    }
}