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

    public boolean isNumberInside(double number) {
        return number >= from && number <= to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public Range getCrossingRange(Range range) {
        if (range.to <= this.from || range.from >= this.to) {
            return null;
        } else {
            return new Range(Math.max(this.from, range.from), Math.min(this.to, range.to));
        }
    }

    public Range[] getCombinedRanges(Range range) {
        if (range.to < this.from || range.from > this.to) {
            return new Range[]{new Range(range.from, range.to), new Range(this.from, this.to)};
        } else {
            return new Range[]{new Range(Math.min(this.from, range.from), Math.max(this.to, range.to))};
        }
    }

    public Range[] getDifferenceOfRanges(Range range) {
        if (range.to <= this.from || range.from >= this.to) {
            return null;
        } else if ((range.from > this.from && range.from < this.to) && (range.to >= this.to)) {
            return new Range[]{new Range(this.from, range.from)};
        } else if (range.from > this.from && range.to < this.to) {
            return new Range[]{new Range(this.from, range.from), new Range(range.to, this.to)};
        } else if (range.from <= this.from && (range.to > this.from && range.to < this.to)) {
            return new Range[]{new Range(range.to, this.to)};
        } else {
            return new Range[0];
        }
    }
}
