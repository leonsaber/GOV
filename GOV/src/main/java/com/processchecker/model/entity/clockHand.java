package com.processchecker.model.entity;

    public class clockHand {
        int degree; // Hour or Min hand current degree in 360;
        int hand; // input 12 to present to present hour, 60 to present min;
        clockHand(int val, int hand) {
            this.degree = 360 / hand * val;
        }
    }
