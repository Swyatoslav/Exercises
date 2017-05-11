package ru.academits.yashenko.range;

class Range {
    private double from;
    private double to;

    Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    Range() {
    }

    double getRangeLength() {
        return to - from;
    }

    boolean isInside(double number) {
        return number >= from && number <= to;
    }

    void setFrom(double from) {
        this.from = from;
    }

    double getFrom() {
        return from;
    }

    void setTo(double to) {
        this.to = to;
    }

    double getTo() {
        return to;
    }

    static Range getCrossingRange(Range first, Range second) {
        if (!first.isInside(second.from) && !first.isInside(second.to)) {
            return null;
        } else if (first.isInside(second.from) && !first.isInside(second.to)) {
            return new Range(second.from, first.to);
        } else if (!first.isInside(second.from) && first.isInside(second.to)) {
            return new Range(first.from, second.to);
        } else {
            return new Range(second.from, second.to);
        }
    }


}
