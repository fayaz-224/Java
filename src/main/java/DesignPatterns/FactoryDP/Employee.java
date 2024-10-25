package DesignPatterns.FactoryDP;

interface Employee {
    int getSalary();
}


class AndroidDeveloper implements Employee {
    @Override
    public int getSalary() {
        return 50000;
    }
}

class WebDeveloper implements Employee {
    @Override
    public int getSalary() {
        return 25000;
    }
}