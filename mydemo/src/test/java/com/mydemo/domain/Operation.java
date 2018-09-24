package com.mydemo.domain;

public enum Operation {

    ADD {
        @Override
        public int apply(int x, int y) {
            return x+y;
        }
    },
    SUBS {
        @Override
        public int apply(int x, int y) {
            return x-y;
        }
    },
    MULTIPLY {
        @Override
        public int apply(int x, int y) {
            return 0;
        }
    },
    DIVIDE {
        @Override
        public int apply(int x, int y) {
            return 0;
        }
    };

    public abstract int apply(int x, int y);
}

class Main {
    public static void main(String[] args) {
        int sum = Operation.ADD.apply(6,9);

        System.out.println(sum);
    }
}
