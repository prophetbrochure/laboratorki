package Sortirovki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static void test_IntegerSort() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 8, 6, 4, 2, 0, 2, 1, 3, 5, 7, 9, 8, 6, 4, 2, 0, 2, 1, 3, 5, 7, 9, 8, 6, 4, 2, 0, 2));
        System.out.println("Изначальный список: \n" + list);

        new CountingSort(10).sort(list);
        System.out.println("Отсортированный список: \n" + list);
    }


    private static void test_StudentSort() {
        Sorting<Student> studentSorter = new MergeSort<>();
        List<Student> studentList = new ArrayList<>(List.of(
                new Student("Vasya", 21), new Student("Vasya", 19),
                new Student("Anton", 22), new Student("Antonio", 23)
        ));
        System.out.println("\nИзначальный список: ");
        studentList.forEach(System.out::println);

        studentSorter.sort(studentList);
        //альтернатива:
        //studentList.sort(Student::compareTo);
        //studentList.sort(Comparator.comparing(Student::getName).thenComparing(Student::getAge));

        System.out.println("Отсортированный список:");
        studentList.forEach(System.out::println);
    }
    private static void test_DoubleSort(){
        Sorting<Double> doubleSorter = new MergeSort<>();
        List<Double> doubleList = new ArrayList<>(Arrays.asList(1.0, 3.0, 5.0, 7.0, 9.0, 8.0, -6.0, 4.0, 2.0, 0.0));
        System.out.println("\nИзначальный список: " + doubleList);
        doubleSorter.sort(doubleList);
        System.out.println("Отсортированный список:" + doubleList);
    }



    public static void main(String[] args) {
        test_IntegerSort();
        test_StudentSort();
        test_DoubleSort();
    }


}
