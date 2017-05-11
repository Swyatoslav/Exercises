package ru.academits.yashenko.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public Range() {
    }

    public double getRangeLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getFrom() {
        return from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getTo() {
        return to;
    }

    public Range getCrossingRange(Range first, Range second) {
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

    public Range[] getCombinedRanges(Range first, Range second) {
        Range[] rangesArray;
        if (!first.isInside(second.from) && !first.isInside(second.to)) {
            rangesArray = new Range[2];
            rangesArray[0] = new Range(first.from, first.to);
            rangesArray[1] = new Range(second.from, second.to);
            return rangesArray;
        } else if (first.isInside(second.from) && !first.isInside(second.to)) {
            rangesArray = new Range[1];
            rangesArray[0] = new Range(first.from, second.to);
            return rangesArray;
        } else if (!first.isInside(second.from) && first.isInside(second.to)) {
            rangesArray = new Range[1];
            rangesArray[0] = new Range(second.from, first.to);
            return rangesArray;
        } else {
            rangesArray = new Range[1];
            rangesArray[0] = new Range(first.from, first.to);
            return rangesArray;
        }
    }

    public Range[] getDifferenceOfRanges(Range first, Range second) {
        Range[] rangesArray;
        if (!first.isInside(second.from) && !first.isInside(second.to)) {
            return null;
        } else if (first.isInside(second.from) && !first.isInside(second.to)) {
            rangesArray = new Range[1];
            rangesArray[0] = new Range(first.from, second.from);
            return rangesArray;
        } else if (!first.isInside(second.from) && first.isInside(second.to)) {
            rangesArray = new Range[1];
            rangesArray[0] = new Range(second.to, first.to);
            return rangesArray;
        } else {
            rangesArray = new Range[2];
            rangesArray[0] = new Range(first.from, second.from);
            rangesArray[1] = new Range(second.to, first.to);
            return rangesArray;
        }
    }
}
