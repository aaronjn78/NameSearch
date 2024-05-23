public class SortStringArray {

    public static String[] SortList(String[] arrayStrings) {

        String name1;
        String name2;

        for (int i = 0; i < arrayStrings.length - 1; i++) {
            for (int j = 0; j < arrayStrings.length - 1; j++) {
                name1 = arrayStrings[i];
                name2 = arrayStrings[j];

                if (name1.compareToIgnoreCase(name2) < 0) {
                    arrayStrings[i] = name2;
                    arrayStrings[j] = name1;
                }

            }
        }
        return arrayStrings;

    }
}
