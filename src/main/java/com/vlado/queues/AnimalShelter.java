package com.vlado.queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Animal shelter with dogs and cats. People may adopt either the
 * oldest, or select whether they want a cat or a dog.
 * Create a data structure with enqueue, dequeueAny, dequeueDog, dequeueCat
 */
public class AnimalShelter {

    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();

        shelter.enqueue(new Dog("Burk"));
        shelter.enqueue(new Cat("Tomy"));
        shelter.enqueue(new Dog("Jim"));
        shelter.enqueue(new Dog("Rex"));
        shelter.enqueue(new Cat("Vivian"));

        System.out.println(shelter.dequeueAny());//Burk
        System.out.println(shelter.dequeueDog());//Jim
        System.out.println(shelter.dequeueCat());//Tomy
    }

    private Queue<AnimalElement> cats = new LinkedList<>();
    private Queue<AnimalElement> dogs = new LinkedList<>();

    private int number = 0;

    public void enqueue(Animal animal) {
        if (animal instanceof Cat) {
            cats.add(new AnimalElement(animal, ++number));
        } else if (animal instanceof Dog) {
            dogs.add(new AnimalElement(animal, ++number));
        }
    }

    public Animal dequeueAny() {
        if (dogs.size() == 0) {
            return dequeueCat();
        } else if (cats.size() == 0) {
            return dequeueDog();
        }

        AnimalElement doge = dogs.peek();
        AnimalElement cate = cats.peek();
        return doge.isOlderThan(cate) ? dequeueDog() : dequeueCat();
    }

    public Dog dequeueDog() {
        if (dogs.size() > 0) {
            return (Dog) dogs.poll().getAnimal();
        }
        return null;
    }

    public Cat dequeueCat() {
        if (cats.size() > 0) {
            return (Cat) cats.poll().getAnimal();
        }
        return null;
    }

    private class AnimalElement {
        private Animal animal;
        private int number;

        AnimalElement(Animal animal, int number) {
            this.animal = animal;
            this.number = number;
        }

        public Animal getAnimal() {
            return animal;
        }

        int getNumber() {
            return number;
        }

        public boolean isOlderThan(AnimalElement other) {
            return this.number < other.getNumber();
        }
    }

    static abstract class Animal {
        private String name;

        public Animal(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class Dog extends Animal {

        public Dog(String name) {
            super(name);
        }
    }

    static class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }
    }
}
