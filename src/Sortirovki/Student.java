package Sortirovki;

class Student implements Comparable<Student> {
    private final String name;
    private final int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Student x) {
        if (!(name.compareTo(x.getName()) == 0)) {
            return name.compareTo(x.getName()) < 0 ? -1 : 1;
        }
        if (!(age == x.getAge())) {
            return age < x.getAge() ? -1 : 1;
        }
        return 0;
    }
    @Override
    public String toString() {
        return name + " " + age;
    }
}
