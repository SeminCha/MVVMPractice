package com.example.krinlech.mvvmpractice;

/**
 * Test Repository
 */
public class Repository {

    private interface Holder {
        Repository INSTANCE = new Repository();
    }

    public static Repository get() {
        return Holder.INSTANCE;
    }

    public TestData findTestData(int index) {
        switch (index) {
            case 1:
                return new TestData("1", "1st James");
            case 2:
                return new TestData("2", "2nd James");
        }
        return null;
    }
}
