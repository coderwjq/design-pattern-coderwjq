package com.coderwjq.designpattern;

/**
 * Created by coderwjq on 2017/4/21.
 */

public class BuilderDesignPattern {
    private boolean addShallot;
    private boolean addParsley;
    private boolean addChili;
    private boolean addSauerkraut;

    public BuilderDesignPattern(Builder builder) {
        this.addShallot = builder.addShallot;
        this.addParsley = builder.addParsley;
        this.addChili = builder.addChili;
        this.addSauerkraut = builder.addSauerkraut;
    }

    public static void main(String[] args) {
        // with builder
        BuilderDesignPattern noodlesC = new BuilderDesignPattern.Builder()
                .withChili()
                .withParsley()
                .build();
        System.out.println("Customer C wants: " + noodlesC);
        BuilderDesignPattern noodlesD = new BuilderDesignPattern.Builder()
                .withChili()
                .withParsley()
                .withSauerkraut()
                .withShallot()
                .build();
        System.out.println("Customer D wants: " + noodlesD);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("A bowl of hot-dry noodles has:");
        if (this.addShallot) {
            builder.append("葱花.");
        }
        if (this.addParsley) {
            builder.append("香菜.");
        }
        if (this.addChili) {
            builder.append("辣椒.");
        }
        if (this.addSauerkraut) {
            builder.append("酸菜.");
        }
        return builder.toString();
    }

    public static class Builder {
        private boolean addShallot;
        private boolean addParsley;
        private boolean addChili;
        private boolean addSauerkraut;

        public Builder() {
        }

        public Builder withShallot() {
            this.addShallot = true;
            return this;
        }

        public Builder withParsley() {
            this.addParsley = true;
            return this;
        }

        public Builder withChili() {
            this.addChili = true;
            return this;
        }

        public Builder withSauerkraut() {
            this.addSauerkraut = true;
            return this;
        }

        public BuilderDesignPattern build() {
            return new BuilderDesignPattern(this);
        }
    }

}
