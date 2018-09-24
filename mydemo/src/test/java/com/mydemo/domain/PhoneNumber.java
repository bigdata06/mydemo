package com.mydemo.domain;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ComparisonChain;

import java.util.*;

import static com.google.common.base.Preconditions.checkArgument;

public class PhoneNumber implements Formattable,Comparable<PhoneNumber>{

    private final int areaCode;
    private final int number;


    private PhoneNumber(int areaCode, int number) {
        this.areaCode = areaCode;
        this.number = number;
    }


    public static PhoneNumber of(int areaCode, int number) {
        checkArgument(areaCode > 100);
        checkArgument(number > 1000);
        return new PhoneNumber(areaCode, number);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)return true;
        if (obj instanceof PhoneNumber){
            PhoneNumber other = (PhoneNumber)obj;
            return Objects.equals(other.areaCode,this.areaCode) && other.number == this.number;
        }

        return false;
    }

    @Override
    public int hashCode() {
        int result = areaCode;
        result = 31 * result + number;
        return result;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("areaCode",this.areaCode)
                .add("number",this.number)
                .toString();

    }


    public static void main(String[] args) {
        System.out.println(PhoneNumber.of(123,1234)
        );
        System.out.println(String.format("%s",PhoneNumber.of(123,1234)));
        PhoneNumber p1 = PhoneNumber.of(123,1234);
        PhoneNumber p11 = PhoneNumber.of(124,1234);
        PhoneNumber p111 = PhoneNumber.of(123,1235);
        List<PhoneNumber> list = new ArrayList<PhoneNumber>(Arrays.asList(p1,p11,p111));
        Collections.sort(list);
        list.sort(COMPARATOR);
        System.out.println(list);


    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format("%d-%d",areaCode,number);
    }

    public static final Comparator<PhoneNumber> COMPARATOR =
            Comparator.comparingInt((PhoneNumber p) -> p.areaCode)
                    .thenComparingInt(p->p.number);


    /*@Override
    public int compareTo(Object object) {
        PhoneNumber o = (PhoneNumber)object;
        return ComparisonChain.start()
                .compare(this.areaCode,o.areaCode)
                .compare(this.number,o.number)
                .result();
    }*/

    @Override
    public int compareTo(PhoneNumber o) {

                return COMPARATOR.compare(this,o);

    }


}
