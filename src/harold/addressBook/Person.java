package harold.addressBook;

import java.io.Serializable;

public class Person implements  Serializable {

    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private int zipCode;
    private String phoneNumber;

    private Person(Builder builder){
        firstName = builder.firstName;
        lastName = builder.lastName;
        phoneNumber = builder.phoneNumber;
        streetAddress = builder.streetAddress;
        city = builder.city;
        streetAddress = builder.state;
        zipCode = builder.zipCode;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static class Builder{

        private String streetAddress;
        private String city;
        private String state;
        private int zipCode;
        private String firstName;
        private String lastName;
        private String phoneNumber;

        public Person build(){
            return new Person(this);
        }

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder streetAddress(String streetAddress){
            this.streetAddress = streetAddress;
            return this;
        }

        public Builder city(String city){
            this.city = city;
            return this;
        }

        public Builder state(String state){
            this.state = state;
            return this;
        }

        public Builder zipCode(int zipCode){
            this.zipCode = zipCode;
            return this;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(firstName).append(" ").append(lastName)
                .append("\n").append(streetAddress).append("\n")
                .append(city).append(", ").append(state).append(" ")
                .append(zipCode);
        return builder.toString();
    }
}