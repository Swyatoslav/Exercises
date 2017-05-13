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
        if (!this.isInside(second.from) && !this.isInside(second.to)) {
            return null;
        } else if (this.isInside(second.from) && !this.isInside(second.to)) {
            return new Range(second.from, this.to);
        } else if (!this.isInside(second.from) && this.isInside(second.to)) {
            return new Range(this.from, second.to);
        } else {
            return new Range(second.from, second.to);
        }
    }

    public Range[] getCombinedRanges(Range second) {
        if (!this.isInside(second.from) && !this.isInside(second.to)) {
            return new Range[]{new Range(this.from, this.to), new Range(second.from, second.to)};
        } else if (this.isInside(second.from) && !this.isInside(second.to)) {
            return new Range[]{new Range(this.from, second.to)};
        } else if (!this.isInside(second.from) && this.isInside(second.to)) {
            return new Range[]{new Range(second.from, this.to)};
        } else {
            return new Range[]{new Range(this.from, this.to)};
        }
    }

    public Range[] getDifferenceOfRanges(Range second) {
        if (!this.isInside(second.from) && !this.isInside(second.to)) {
            return new Range[0];
        } else if (this.isInside(second.from) && !this.isInside(second.to)) {
            return new Range[]{new Range(this.from, second.from)};
        } else if (!this.isInside(second.from) && this.isInside(second.to)) {
            return new Range[]{new Range(second.to, this.to)};
        } else {
            return new Range[]{new Range(this.from, second.from), new Range(second.to, this.to)};
        }
    }
}
