package ru.academits.yashenko.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public Range getCrossingRange(Range second) {
        if (second.to <= this.from || second.from >= this.to) {
            return null;
        } else if (second.from > this.from && second.to < this.to) {
            return new Range(second.from, second.to);
        } else if ((second.from > this.from && second.from < this.to) && (second.to >= this.to)) {
            return new Range(second.from, this.to);
        } else if ((second.from < this.from) && (second.to > this.from && second.to < this.to)) {
            return new Range(this.from, second.to);
        } else {
            return new Range(this.from, this.to);
        }
    }

    public Range[] getCombinedRanges(Range second) {
        if (second.to < this.from || second.from > this.to) {
            return new Range[]{new Range(second.from, second.to), new Range(this.from, this.to)};
        } else if (second.from > this.from && second.to < this.to) {
            return new Range[]{new Range(this.from, this.to)};
        } else if ((second.from > this.from && second.from <= this.to) && (second.to > this.to)) {
            return new Range[]{new Range(this.from, second.to)};
        } else if ((second.from < this.from) && (second.to >= this.from && second.to < this.to)) {
            return new Range[]{new Range(second.from, this.to)};
        } else {
            return new Range[]{new Range(second.from, second.to)};
        }
    }

    public Range[] getDifferenceOfRanges(Range second) {
        if (second.from > this.from && second.to < this.to) {
            return new Range[]{new Range(this.from, second.from), new Range(second.to, this.to)};
        } else if ((second.from > this.from && second.from < this.to) && (second.to > this.to)) {
            return new Range[]{new Range(this.from, second.from)};
        } else if ((second.from < this.from) && (second.to > this.from && second.to < this.to)) {
            return new Range[]{new Range(second.to, this.to)};
        } else {
            return new Range[0];
        }
    }
}
